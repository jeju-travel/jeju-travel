package knh.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import knh.dao.AirlineDao;
import knh.dao.AirlineDaoImpl;
import knh.model.Airline;

@WebServlet(name="CustomerController", 
urlPatterns= {"/reserveAirlineCheck", "/reserveAirline", "/addAirline"
		, "/goAddAirline", "/updateAirline", "/showAirline", "/updateSetAirline"
		, "/deleteFromAirline"})
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
		}
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}

}
