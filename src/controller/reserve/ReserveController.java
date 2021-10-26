package controller.reserve;

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
import dao.reserve.ReserveDao;
import dao.reserve.ReserveDaoImpl;
import model.air.Airline;
import model.car.Car;
import model.manager.Reservation;

@WebServlet(name = "ReserveController", urlPatterns = {"/res_detail", "/review", "/shopping_cart", "/review_insert" })
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
			System.out.println(resNo);
			
			ReserveDao dao = new ReserveDaoImpl();
			Reservation res = dao.selectByResNo(resNo);
			
			
			req.setAttribute("res", res);
			
		} else if(action.equals("review")) {
			
			int airNo = Integer.parseInt(req.getParameter("air"));
			int carNo = Integer.parseInt(req.getParameter("car"));
			
			AirlineDao airDao = new AirlineDaoImpl();
			Airline air = airDao.selectByNo(airNo);
			
			CarDao carDao = new CarDaoImpl();
			Car car = carDao.selectByCarno(carNo);
			
			req.setAttribute("air", air);
			req.setAttribute("car", car);
			
		} else if(action.equals("shopping_cart")) {
			
			HttpSession session = req.getSession();
			
			
			//나중에 수정
			String air = (String) session.getAttribute("air");
			String room = (String) session.getAttribute("room");
			String car = (String) session.getAttribute("car");
		
			req.setAttribute("air", air);
			req.setAttribute("room", room);
			req.setAttribute("car", car);
		} else if(action.equals("review_insert")){
			
			String airContent = req.getParameter("airContent");
			int airStar = Integer.parseInt(req.getParameter("airStar"));
			int resNo = Integer.parseInt(req.getParameter("airResNo"));
			
			
			
		}


		// 주소 이동
		String dispatchUrl = null;
		if (action.equals("res_detail")) {
			dispatchUrl = "/jsp/reserve/res_detail.jsp";
		} else if(action.equals("review")) {
			dispatchUrl = "/jsp/reserve/review.jsp";
		} else if(action.equals("shopping_cart")) {
			dispatchUrl = "/jsp/reserve/shoppingbasket.jsp";
		}  else if(action.equals("review_insert")){
			dispatchUrl = "/jsp/member.mypage.jsp";
			
		}


		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatchUrl);
		dispatcher.forward(req, resp);
	}
}
