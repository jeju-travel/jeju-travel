package controller.reserve;

import java.io.IOException;
import java.util.List;
import model.Lodging.Lodging_reserve;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Lodgingadmin.LodgingDao;
import dao.Lodgingadmin.LodgingDaoImpl;
import dao.air.AirReserveDao;
import dao.air.AirReserveDaoImpl;
import dao.air.AirReviewDao;
import dao.air.AirlineDao;
import dao.air.AirlineDaoImpl;
import dao.car.CarDao;
import dao.car.CarDaoImpl;
import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import dao.reserve.ReserveDao;
import dao.reserve.ReserveDaoImpl;
import model.Lodging.Lodgingadmin;
import model.air.AirReserve;
import model.air.Airline;
import model.car.Car;
import model.car.CarReserve;
import model.manager.Member;
import model.manager.Reservation;

@WebServlet(name = "ReserveController", urlPatterns = {"/res_detail",  "/shopping_cart", "/reserve", "/reserve_delete"})
public class ReserveController extends HttpServlet {

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
		if (action.equals("res_detail")) {

			int resNo = Integer.parseInt(req.getParameter("resNo"));
			System.out.println("예약번호" + resNo);
			
			ReserveDao dao = new ReserveDaoImpl();
			Reservation res = dao.selectByResNo(resNo);
			System.out.println("안녕하세요");
			System.out.println(res.toString());
			
			AirReserve airRes = dao.selectAirResByResNo(res.getairResNo());
		
			Lodging_reserve roomRes = dao.selectRoomResByResNo(res.getroomResNo());

			System.out.println(roomRes.toString());
			CarReserve carRes = dao.selectCarResByResNo(res.getcarResNo());
	
			
			Airline air = dao.selectAirByResNo(res.getairResNo());
			Lodgingadmin room = dao.selectRoomByResNo(res.getroomResNo());
			System.out.println(room.toString());
			Car car = dao.selectCarByResNo(res.getcarResNo());
			
			
			
			
			
			//req.setAttribute("resNo", resNo);
			req.setAttribute("air", air);
			req.setAttribute("car", car);
			req.setAttribute("airRes", airRes);
			req.setAttribute("carRes", carRes);
			req.setAttribute("room", room);
			req.setAttribute("roomRes", roomRes);
			
			req.setAttribute("res", res);
			
		}  else if(action.equals("shopping_cart")) {
			
			HttpSession session = req.getSession();
			
			
			//세션 정보 받아오기
			Reservation res = (Reservation)session.getAttribute("res");
			
			AirReserve airRes = (AirReserve) session.getAttribute("airReserve");
			Lodging_reserve roomRes = (Lodging_reserve) session.getAttribute("lodgingReserve");
			CarReserve carRes = (CarReserve) session.getAttribute("carReserve");
			
			Airline air =null;
			Lodgingadmin room = null;
			Car car = null;
			
			if(airRes != null) {
				AirlineDao dao = new AirlineDaoImpl();
				air = dao.selectByNo(airRes.getAirNo());
			}
			
			if(roomRes != null) {
				LodgingDao dao = new LodgingDaoImpl();
				room = dao.selectBylodging_no(roomRes.getLodging_no());
			}
			
			if(carRes != null) {
				
				CarDao dao = new CarDaoImpl();
				car = dao.selectByCarno(carRes.getCar_no());
			}
			
			
			req.setAttribute("air", air);
			req.setAttribute("airRes", airRes);
			req.setAttribute("room", room);
			req.setAttribute("roomRes", roomRes);
			req.setAttribute("car", car);
			req.setAttribute("carRes", carRes);
			
			req.setAttribute("res", res);
		
		} else if(action.equals("reserve")) {
			HttpSession session = req.getSession();
			
			//세션 정보 받아오기
			Reservation res = (Reservation)session.getAttribute("res");
			
			AirReserve airRes = (AirReserve) session.getAttribute("airReserve");
			Lodging_reserve roomRes = (Lodging_reserve) session.getAttribute("lodgingReserve");
			CarReserve carRes = (CarReserve) session.getAttribute("carReserve");
			
			String id = (String)session.getAttribute("member");
			
			MemberDao memDao = new MemberDaoImpl();
			Member member = memDao.selectById(id);
			
	
			
			if(airRes != null) {
				AirReserveDao dao = new AirReserveDaoImpl();
				dao.insert(airRes.getTakeOff(), airRes.getLanding(), airRes.getPersonnel(), airRes.getAirNo());
				
			}
			
			if(roomRes != null) {
				ReserveDao dao = new ReserveDaoImpl();
				dao.insertRoomRes(roomRes);
			}
			
			if(carRes != null) {
				CarDao dao = new CarDaoImpl();
				dao.CarReserve(carRes);
			}
			
			

			ReserveDao dao = new ReserveDaoImpl();
			dao.insert(member.getNo(), res.getStartDay(), res.getEndDay(), res.getPrice(), airRes.getAirNo(), roomRes.getLodging_no(), carRes.getCar_no());
			
			
			session.removeAttribute("resNo");
		} else if(action.equals("reserve_delete")) {

			HttpSession session = req.getSession();
			int resNo = (int)session.getAttribute("resNo");

			ReserveDao dao = new ReserveDaoImpl();
			Reservation res = dao.selectByResNo(resNo);

			if(res.getairResNo() != 0) {
			dao.deleteAirRes(res.getairResNo());}
			if(res.getroomResNo() != 0) {
			dao.deleteLodgingRes(res.getroomResNo());
			}
			if(res.getcarResNo() != 0) {
			dao.deleteCarRes(res.getcarResNo());
			}

			dao.deleteRes(res.getResNo());

			session.removeAttribute("resNo");

		} 


		// 주소 이동
		String dispatchUrl = null;
		if (action.equals("res_detail")) {
			dispatchUrl = "/jsp/reserve/res_detail.jsp";
		} else if(action.equals("shopping_cart")) {
			dispatchUrl = "/jsp/reserve/shoppingbasket.jsp";
		} else if(action.equals("reserve")) {
			dispatchUrl = "mypage";
		} else if(action.equals("reserve_delete")) {
			dispatchUrl = "mypage";
		}


		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatchUrl);
		dispatcher.forward(req, resp);
	}
}
