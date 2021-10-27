package controller.Lodging;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Lodgingadmin.LodgingDao;
import dao.Lodgingadmin.LodgingDaoImpl;
import model.Lodging.Lodgingadmin;

@WebServlet (name="LodgingControlleruser", urlPatterns= {"/lodging_list_user", "/main_lodging"})
public class LodgingControlleruser extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
	    process(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setCharacterEncoding("utf-8");
	    process(req,resp);
	      
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri =req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		//로직
		if(action.equals("lodging_list")) {
			System.out.println("list 도착하였습니다.");
			
			LodgingDao lodgingDao = new LodgingDaoImpl();
			List<Lodgingadmin> lodgingList = lodgingDao.selectAll();
			req.setAttribute("lodgingList", lodgingList);
		}
		
		
		//화면구성
		String dispatcherUrl = null;
		
		if(action.equals("lodging_list_user")) {
			dispatcherUrl = "/jsp/lodging_user/lodginglistuser.jsp";
		}else if(action.equals("main_lodging")) {
			dispatcherUrl = "/jsp/main/lodging.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
	    dispatcher.forward(req, resp);
	}
	
}
