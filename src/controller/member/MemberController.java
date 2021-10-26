package controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.air.AirlineDao;
import dao.air.AirlineDaoImpl;
import dao.car.CarDao;
import dao.car.CarDaoImpl;
import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import dao.reserve.ReserveDao;
import dao.reserve.ReserveDaoImpl;
import model.air.Airline;
import model.car.Car;
import model.manager.Member;
import model.manager.Reservation;

@WebServlet(name = "MemberConroller", urlPatterns = { "/join", "/idcheck", "/save", "/mypage", "/detail", "/update",
		"/delete" })
public class MemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		System.out.println(uri);
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);

		// logic
		if (action.equals("join")) {

		} else if (action.equals("idcheck")) {
			// 화면에서 id 값 받아오기
			String id = req.getParameter("id_value");

			MemberDao memberDao = new MemberDaoImpl();

			System.out.println(id);
			int cnt = memberDao.selectCntById(id);
			
			if(cnt == 0) {
				System.out.println("사용 가능한 아이디");
				req.setAttribute("useTF", true);
			}else if(cnt == 1) {
				System.out.println("사용 불가능한 아이디");
				req.setAttribute("useTF", false);
				
			}

		} else if (action.equals("save")) {

			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String name = req.getParameter("name");
			String hint = req.getParameter("hint");
			String answer = req.getParameter("answer");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");

			Member member = new Member(id, pw, name, hint, answer, phone, email);
			MemberDao dao = new MemberDaoImpl();

			dao.insert(member);
		} else if (action.equals("mypage")) {

			HttpSession session = req.getSession();
			String memId = (String)session.getAttribute("member");
			
			System.out.println("memno:" + memId);
			
			
			List<Reservation> reslist = null;
			MemberDao m_dao = new MemberDaoImpl();
			ReserveDao dao = new ReserveDaoImpl();
			Member member = m_dao.selectById(memId);
			reslist = dao.selectByMemNo(member.getNo());
			
			
			for (Reservation res : reslist) {
				
				//예약 항목 뽑아오기
				int num[] = dao.selectItemNoByResNo(res.getResNo());
				
				System.out.println("1: " + num[0] + " 2: " +num[1] + " 3: " +num[2]);
				String items = "";
				
				for(int i=0; i<3; i ++) {
					if(num[i] != 0) {
						//예약번호를 넣어서 항목이름 뽑아오기
						switch(i) {
						//항공 이름 가져오기
						case 0:
							AirlineDao airDao = new AirlineDaoImpl();
							Airline air =  airDao.selectByNo(num[0]);
							
							items += air.getAirName()+ "  " ;
							
							res.setAirNo(air.getAirNo());
							break;
						//숙소 이름 가져오기
						case 1:
							
							
							items += "	결과값	" ;
							break;
						//차 이름 가져오기	
						case 2:
							CarDao carDao = new CarDaoImpl();
							Car car = carDao.selectByCarno(num[2]);
							
							System.out.println(car.toString());
							items += "  " + car.getCar_name() + "  " ;
							
							res.setCarNo(car.getCar_no());
							break;
						}
							
						
			
					}
				}
				
				res.setItems(items);
			}
			
			req.setAttribute("reslist", reslist);

		
		} else if (action.equals("detail")) {

			HttpSession session = req.getSession();
			String mem_id = (String) (session.getAttribute("member"));

			MemberDao dao = new MemberDaoImpl();
			Member member = dao.selectById(mem_id);

			req.setAttribute("mem", member);

		} else if (action.equals("update")) {

			int no = Integer.parseInt(req.getParameter("no"));
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String name = req.getParameter("name");
			String hint = req.getParameter("hint");
			String answer = req.getParameter("answer");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");

			Member member = new Member(no, id, pw, name, hint, answer, phone, email);

			MemberDao dao = new MemberDaoImpl();
			dao.update(member);
		} else if (action.equals("delete")) {

			int no = Integer.parseInt(req.getParameter("no"));

			MemberDao dao = new MemberDaoImpl();
			dao.delete(no);
			
			HttpSession session = req.getSession();
			session.removeAttribute("member");
		}


		// 주소 이동
		String dispatchUrl = null;
		if (action.equals("join")) {
			dispatchUrl = "/jsp/member/join.jsp";
		} else if (action.equals("idcheck")) {
			dispatchUrl = "/ajax/idcheck.jsp";

		} else if (action.equals("save")) {
			dispatchUrl = "/index.jsp";
		} else if (action.equals("mypage")) {
			dispatchUrl = "/jsp/member/mypage.jsp";
		} else if (action.equals("detail")) {
			dispatchUrl = "/jsp/member/detail.jsp";
		} else if (action.equals("update")) {
			dispatchUrl = "/jsp/member/mypage.jsp";
		} else if(action.equals("delete")) {
			dispatchUrl = "index.jsp";
		}


		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatchUrl);
		dispatcher.forward(req, resp);
	}
}
