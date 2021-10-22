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
urlPatterns= {"/reserveAirlineCheck", "/reserveAirline"})
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
			
			HttpSession session = req.getSession();
			/*session.removeAttribute("sDay");
			session.removeAttribute("eDay");*/
		}
		
		
		String dispatcherUrl = null;
		
		if(action.equals("reserveAirlineCheck")) {
			dispatcherUrl = "/air/airReserveCheck.jsp";
		}else if(action.equals("reserveAirline")) {
			dispatcherUrl = "/air/airReserveList.jsp";
		}
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}

}
