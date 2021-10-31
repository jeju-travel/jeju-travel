package controller.air;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.air.AirReserveDao;
import dao.air.AirReserveDaoImpl;
import dao.air.AirReviewDao;
import dao.air.AirReviewDaoImpl;
import dao.air.AirlineDao;
import dao.air.AirlineDaoImpl;
import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import dao.reserve.ReserveDao;
import dao.reserve.ReserveDaoImpl;
import model.air.AirReserve;
import model.air.Airline;
import model.manager.Member;
import model.manager.Reservation;

@WebServlet(name="CustomerController", 
urlPatterns= {"/reserveAirlineCheck", "/reserveAirline", "/addAirline"
		, "/air_input", "/updateAirline", "/air_list", "/updateSetAirline"
		, "/deleteFromAirline", "/basketAirline", "/reserveAll", "/writeAirReview"
		, "/saveAirReview", "/reviewSave_air", "/main_air"})
public class AirController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		req.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		if(action.equals("reserveAirlineCheck")) {
			
			
			
		}else if(action.equals("reserveAirline")) {
			
			AirlineDao dao = new AirlineDaoImpl();
			List<Airline> airlineList = dao.selectAll();
			
			AirReviewDao reviewDao = new AirReviewDaoImpl();
			
			for (Airline airline : airlineList) {
				double d = reviewDao.avg_horoscope(airline.getAirNo());
				airline.setHoroscope(d);
			}
			
			req.setAttribute("airlineList", airlineList);
			
			
		}else if(action.equals("addAirline")) {
			
			AirlineDao dao = new AirlineDaoImpl();
			
			Airline airline = new Airline();
			airline.setAirName(req.getParameter("airName"));
			airline.setPrice(Integer.parseInt(req.getParameter("price")));
			airline.setAirLoc(req.getParameter("airLoc"));
			airline.setTakeOff(req.getParameter("takeOff"));
			airline.setAirImage(req.getParameter("airImage"));
			
			dao.insert(airline);
			
		}else if(action.equals("air_list")) {
			
			AirlineDao dao = new AirlineDaoImpl();
			List<Airline> airlineList = dao.selectAll();
			
			req.setAttribute("airlineList", airlineList);
			
		}else if(action.equals("updateAirline")) {

			AirlineDao dao = new AirlineDaoImpl();
			Airline airline = dao.selectByNo(Integer.parseInt(req.getParameter("airNo")));
			
			req.setAttribute("airline", airline);
			
		}else if(action.equals("updateSetAirline")) {
			
			String airName = req.getParameter("airName");
			int price = Integer.parseInt(req.getParameter("price"));
			String airLoc = req.getParameter("airLoc");
			String takeOff = req.getParameter("takeOff");
			int airNo = Integer.parseInt(req.getParameter("airNum"));
			String airImage = req.getParameter("airImage");

			AirlineDao dao = new AirlineDaoImpl();
			dao.update(airName, price, airLoc, takeOff, airImage, airNo);
			
		}else if(action.equals("deleteFromAirline")) {
			
			AirlineDao dao = new AirlineDaoImpl();
			
			int airNo = Integer.parseInt(req.getParameter("airNum"));
			
			dao.delete(airNo);
			
		}else if(action.equals("basketAirline")) {
			AirlineDao dao = new AirlineDaoImpl();
			
			int airNo = Integer.parseInt(req.getParameter("airNo"));
			int personnel = Integer.parseInt(req.getParameter("personnel"));
			
			Airline airline = dao.selectByNo(airNo);
			
			HttpSession session = req.getSession();
			session.setAttribute("reserveAirline", airline);
			session.setAttribute("airPersonnel", personnel);
			
		}else if(action.equals("reserveAll")) {
			
			int airNo = Integer.parseInt(req.getParameter("airNo"));
			HttpSession session = req.getSession();
			int personnel = (int) session.getAttribute("airPersonnel");

			AirlineDao dao = new AirlineDaoImpl();
			Airline airline = dao.selectByNo(airNo);
			
			AirReserve airRes = new AirReserve();
			airRes.setTakeOff(airline.getTakeOff());
			airRes.setLanding(airline.getTakeOff());
			airRes.setPersonnel(personnel);
			airRes.setAirNo(airNo);
			
			session.setAttribute("airRes", airRes);
			
			session.removeAttribute("reserveAirline");
			session.removeAttribute("airPersonnel");
			
			/*session.removeAttribute("sDay");
			session.removeAttribute("eDay");
			session.removeAttribute("reserveAirline");
			session.removeAttribute("airPersonnel");
			session.removeAttribute("recentAirReserve");*/
			
		}else if(action.equals("writeAirReview")) {
			List<Airline> airlineList = new ArrayList<>();
			
			AirReviewDao reviewDao = new AirReviewDaoImpl();
			List<Integer> reserveList = reviewDao.check_member(999);
			
			AirReserveDao reserveDao = new AirReserveDaoImpl();
			
			AirlineDao dao = new AirlineDaoImpl();
			for (Integer i : reserveList) {
				AirReserve airReserve = reserveDao.selectByNo(i);
				if(airReserve != null) {
					airlineList.add(dao.selectByNo(airReserve.getAirNo()));
				}
			}
			req.setAttribute("airlineList", airlineList);
			
		}else if(action.equals("saveAirReview")) {
			int airlineNo = Integer.parseInt(req.getParameter("airNo"));
			
			req.setAttribute("airlineNo", airlineNo);
			
		}else if(action.equals("reviewSave_air")) {
			HttpSession session = req.getSession();
			
			String writer = (String) session.getAttribute("member");
			String content = req.getParameter("content");
			double airHoroscope = Integer.parseInt(req.getParameter("horoscope"));
			int airNo = Integer.parseInt(req.getParameter("airlineNo"));
			
			AirReviewDao reviewDao = new AirReviewDaoImpl();
			reviewDao.insert(writer, content, airHoroscope, airNo);
			
		}else if(action.equals("main_air")) {
			HttpSession session = req.getSession();
			
			if(session.getAttribute("member") != null) {
				String startDay = req.getParameter("start_day");
				String endDay = req.getParameter("end_day");
	
				session.setAttribute("startDay", startDay);
				session.setAttribute("endDay", endDay);
				
				MemberDao memberDao = new MemberDaoImpl();
				Member member = memberDao.selectById((String) session.getAttribute("member"));
				
				Reservation reservation = new Reservation();
				reservation.setMemNo(member.getNo());
				reservation.setStartDay(startDay);
				reservation.setEndDay(endDay);
				reservation.setPrice(0);
				session.setAttribute("reserve", reservation);
			}
		}
		
		/* 예약을 생성할 부분
		HttpSession session = req.getSession();
		//
		AirReserveDao airResDao = new AirReserveDaoImpl();
		AirReserve airRes = (AirReserve) session.getAttribute("airRes");
		airResDao.insert(airRes);
		int airResNo = airResDao.recentAirReserve();
		
		ReserveDao reserveDao = new ReserveDaoImpl();
		int resNo = reserveDao.recentReservation();
		
		airResDao.updateReservation(resNo, airResNo);
		session.removeAttribute("airRes");
		*/
		
		String dispatcherUrl = null;
		
		if(action.equals("reserveAirlineCheck")) {
			dispatcherUrl = "/jsp/air/airReserveCheck.jsp";
			
		}else if(action.equals("reserveAirline")) {
			dispatcherUrl = "/jsp/air/airReserveList.jsp";
			
		}else if(action.equals("air_input")) {
			dispatcherUrl = "/jsp/air/addAirline.jsp";
			
		}else if(action.equals("addAirline")) {
			dispatcherUrl = "/jsp/lodging_admin/adminmain.jsp";
			
		}else if(action.equals("updateAirline")) {
			dispatcherUrl = "/jsp/air/updateAirline.jsp";
			
		}else if(action.equals("air_list")) {
			dispatcherUrl = "/jsp/air/showAirline.jsp";
			
		}else if(action.equals("updateSetAirline")) {
			dispatcherUrl = "showAirline";
			
		}else if(action.equals("deleteFromAirline")) {
			dispatcherUrl = "showAirline";
			
		}else if(action.equals("basketAirline")) {
			dispatcherUrl = "/jsp/air/basket.jsp";
			
		}else if(action.equals("reserveAll")) {
			dispatcherUrl = "/jsp/main/lodging.jsp";
			
		}else if(action.equals("writeAirReview")) {
			dispatcherUrl = "/jsp/air/reserveList.jsp";
			
		}else if(action.equals("saveAirReview")) {
			dispatcherUrl = "/jsp/air/writeAirReview.jsp";
			
		}else if(action.equals("reviewSave_air")) {
			dispatcherUrl = "/mainTemp.jsp";
			
		}else if(action.equals("main_air")) {
			HttpSession session = req.getSession();
			if(session.getAttribute("member") != null) {
				dispatcherUrl = "/jsp/main/air.jsp";
			}else {				
				resp.setContentType("text/html; charset=UTF-8"); 
				PrintWriter writer = resp.getWriter(); 
				writer.println("<script>alert('로그인을 해주세요'); location.href='index.jsp';</script>");
				writer.close();

			}
			
		}//
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}

}
