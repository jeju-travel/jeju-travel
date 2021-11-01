package controller.member;

import java.io.IOException;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Lodgingadmin.LodgingDao;
import dao.Lodgingadmin.LodgingDaoImpl;
import dao.air.AirlineDao;
import dao.air.AirlineDaoImpl;
import dao.car.CarDao;
import dao.car.CarDaoImpl;
import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import dao.reserve.ReserveDao;
import dao.reserve.ReserveDaoImpl;
import model.Lodging.Lodgingadmin;
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

			if (cnt == 0) {
				System.out.println("사용 가능한 아이디");
				req.setAttribute("useTF", true);
			} else if (cnt == 1) {
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
	         String memId = (String) session.getAttribute("member");

	         System.out.println("memno:" + memId);

	         List<Reservation> reslist = null;
	         MemberDao m_dao = new MemberDaoImpl();
	         ReserveDao dao = new ReserveDaoImpl();
	         Member member = m_dao.selectById(memId);
	         reslist = dao.selectByMemNo(member.getNo());
	         
	      
	         //
	         try {
	            for (Reservation res : reslist) {
	               // 예약 날짜 지날시 예약 상태를 예약 확인으로 수정
	               SimpleDateFormat format = new SimpleDateFormat("yy.MM.dd");
	               Date currentTime = new Date();

	               String date = format.format(currentTime);
	               String endDay = res.getEndDay();

	               Date endDate = format.parse(endDay);
	               Date todate = format.parse(date);

	               System.out.println("endDate:" + endDate);
	               System.out.println("todate:" + todate);
	               int compare = endDate.compareTo(todate);

	               System.out.println("compare:" + compare);

	               if (compare < 0) {
	                  System.out.println("예약 상태 예약 확인으로 수정");
	                  ReserveDao resDao = new ReserveDaoImpl();
	                  resDao.updateResState(res.getResNo());
	                  res.setState("예약확인");
	               }
	               // 예약 항목 뽑아오기
	               String items = "";
	               if (res.getairResNo() != 0) {// 예약번호
	                  ReserveDao airdao = new ReserveDaoImpl();
	                  String airName = dao.selectNameAirResNo(res.getairResNo());

	                  items += airName + "\t";
	               }

	               // select loadging_name from lodging_reserve ar inner join lodging a on
	               // a.lodging_no = ar.lodging_no
	               if (res.getroomResNo() != 0) {
	                  ReserveDao roomdao = new ReserveDaoImpl();
	                  String room = roomdao.selectNameRoomResNo(res.getroomResNo());
	                  items += "\t" + room + "\t";
	               }

	               // select car_name from car_reserve ar inner join car a on a.car_no = ar.car_no
	               if (res.getcarResNo() != 0) {
	            	  
	                  ReserveDao cardao = new ReserveDaoImpl();
	                  String carName = cardao.selectNameCarResNo(res.getcarResNo());
	                  System.out.println("자동차예약번호1234자동"+res.getcarResNo());
	                  items += "\t" + carName + "\t";
	               }

	               res.setItems(items);
	               System.out.println("예약 번호: " + res.getResNo() + " 예약항목: " + res.getairResNo() + ", "
	                     + res.getroomResNo() + ", " + res.getcarResNo() + " -> " + res.getItems());

	            }
	            req.setAttribute("reslist", reslist);
	         } catch (Exception pe) {
	            System.out.println("parseException 발생");
	         }
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
			dispatchUrl = "login_input";
		} else if (action.equals("mypage")) {
			dispatchUrl = "/jsp/member/mypage.jsp";
		} else if (action.equals("detail")) {
			dispatchUrl = "/jsp/member/detail.jsp";
		} else if (action.equals("update")) {
			dispatchUrl = "mypage";
		} else if (action.equals("delete")) {
			dispatchUrl = "index.jsp";
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatchUrl);
		dispatcher.forward(req, resp);
	}
}
