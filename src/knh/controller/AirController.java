package knh.controller;

import java.io.IOException;
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

import knh.dao.AirReserveDao;
import knh.dao.AirReserveDaoImpl;
import knh.dao.AirReviewDao;
import knh.dao.AirReviewDaoImpl;
import knh.dao.AirlineDao;
import knh.dao.AirlineDaoImpl;
import knh.model.Airline;

@WebServlet(name="CustomerController", 
urlPatterns= {"/reserveAirlineCheck", "/reserveAirline", "/addAirline"
		, "/goAddAirline", "/updateAirline", "/showAirline", "/updateSetAirline"
<<<<<<< HEAD
		, "/deleteFromAirline", "/basketAirline", "/reserveAll", "/writeAirReview"})
=======
		, "/deleteFromAirline"})
>>>>>>> branch 'namho' of https://github.com/jeju-travel/jeju-travel.git
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
			
			String startDay = req.getParameter("startDay");
			String endDay = req.getParameter("endDay");

			HttpSession session = req.getSession();
			session.setAttribute("sDay", startDay);
			session.setAttribute("eDay", endDay);
			
		}else if(action.equals("reserveAirline")) {
			
			AirlineDao dao = new AirlineDaoImpl();
			List<Airline> airlineList = dao.selectAll();
			
			req.setAttribute("airlineList", airlineList);
			
			/*HttpSession session = req.getSession();
			session.removeAttribute("sDay");
			session.removeAttribute("eDay");*/
			
		}else if(action.equals("addAirline")) {
			
			AirlineDao dao = new AirlineDaoImpl();
			
			Airline airline = new Airline();
			airline.setAirName(req.getParameter("airName"));
			airline.setPrice(Integer.parseInt(req.getParameter("price")));
			airline.setAirLoc(req.getParameter("airLoc"));
			airline.setTakeOff(req.getParameter("takeOff"));
			airline.setAirImage(req.getParameter("airImage"));
			
			dao.insert(airline);
			
		}else if(action.equals("showAirline")) {
			
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

			AirlineDao dao = new AirlineDaoImpl();
			dao.update(airName, price, airLoc, takeOff, airNo);
			
		}else if(action.equals("deleteFromAirline")) {
			
			AirlineDao dao = new AirlineDaoImpl();
			
			int airNo = Integer.parseInt(req.getParameter("airNum"));
			
			dao.delete(airNo);
<<<<<<< HEAD
			
		}else if(action.equals("basketAirline")) {
			AirlineDao dao = new AirlineDaoImpl();
			
			int airNo = Integer.parseInt(req.getParameter("airNo"));
			int personnel = Integer.parseInt(req.getParameter("personnel"));
			
			Airline airline = dao.selectByNo(airNo);
			
			HttpSession session = req.getSession();
			session.setAttribute("reserveAirline", airline);
			session.setAttribute("airPersonnel", personnel);
			
		}else if(action.equals("reserveAll")) {
			
			int airNo = Integer.parseInt(req.getParameter("reserve_airNo"));
			HttpSession session = req.getSession();
			int personnel = (int) session.getAttribute("airPersonnel");

			AirlineDao dao = new AirlineDaoImpl();
			Airline airline = dao.selectByNo(airNo);
			
			AirReserveDao reserveDao = new AirReserveDaoImpl();
			reserveDao.insert(airline.getTakeOff(), airline.getTakeOff(), personnel, 1001, airNo);
			
			session.removeAttribute("sDay");
			session.removeAttribute("eDay");
			session.removeAttribute("reserveAirline");
			session.removeAttribute("airPersonnel");
			
		}else if(action.equals("writeAirReview")) {
			List<Airline> airlineList = new ArrayList<>();
			
			AirReviewDao reviewDao = new AirReviewDaoImpl();
			List<Integer> reserveList = reviewDao.check_member(999);
			
			AirlineDao dao = new AirlineDaoImpl();
			for (Integer i : reserveList) {
				airlineList.add(dao.selectByNo(i));
			}
			
			req.setAttribute("airlineList", airlineList);
=======
>>>>>>> branch 'namho' of https://github.com/jeju-travel/jeju-travel.git
		}
		
		
		String dispatcherUrl = null;
		
		if(action.equals("reserveAirlineCheck")) {
			dispatcherUrl = "/air/airReserveCheck.jsp";
		}else if(action.equals("reserveAirline")) {
			dispatcherUrl = "/air/airReserveList.jsp";
		}else if(action.equals("goAddAirline")) {
			dispatcherUrl = "/air/addAirline.jsp";
		}else if(action.equals("addAirline")) {
			dispatcherUrl = "/mainTemp.jsp";
		}else if(action.equals("updateAirline")) {
			dispatcherUrl = "/air/updateAirline.jsp";
		}else if(action.equals("showAirline")) {
			dispatcherUrl = "/air/showAirline.jsp";
		}else if(action.equals("updateSetAirline")) {
			dispatcherUrl = "showAirline";
		}else if(action.equals("deleteFromAirline")) {
			dispatcherUrl = "showAirline";
<<<<<<< HEAD
		}else if(action.equals("basketAirline")) {
			dispatcherUrl = "/air/basket.jsp";
		}else if(action.equals("reserveAll")) {
			dispatcherUrl = "/mainTemp.jsp";
		}else if(action.equals("writeAirReview")) {
			dispatcherUrl = "/air/writeAirReview.jsp";
=======
>>>>>>> branch 'namho' of https://github.com/jeju-travel/jeju-travel.git
		}
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}

}
