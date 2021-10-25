package controller.Lodging;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Lodging.LodgingDao;
import dao.Lodging.LodgingDaoImpl;
import model.Lodging;

@WebServlet(name="LodgingController", urlPatterns= {"/lodging_input","/lodging_save","/lodging_list","/lodging_detail","/lodging_update","/lodging_delete"})
public class LodgingController extends HttpServlet{
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
		if(action.equals("lodging_input")) {
			
		}else if(action.equals("lodging_save")) {
			System.out.println("save 도착하였습니다.");
			
			//getParameter할때 jsp의 name이랑 동일한지 꼭 확인
			String lodging_name = req.getParameter("lodgingname");
			String lodging_loc = req.getParameter("lodgingloc");
			String lodging_phone = req.getParameter("lodgingphone");
			String lodging_image = req.getParameter("lodgingimage");
			
			Lodging lodging = new Lodging(lodging_name,lodging_loc,lodging_phone,lodging_image);
			
			LodgingDao lodgingDao = new LodgingDaoImpl();
			lodgingDao.insert(lodging);
			System.out.println("등록되었습니다.");
			req.setAttribute("message","등록되었습니다.");
			
		}else if(action.equals("lodging_list")) {
			System.out.println("list 도착하였습니다.");
			
			LodgingDao lodgingDao = new LodgingDaoImpl();
			List<Lodging> lodgingList = lodgingDao.selectAll();
			req.setAttribute("lodgingList", lodgingList);
			
		}else if(action.equals("lodging_detail")) {
			int lodging_no = Integer.parseInt(req.getParameter("lodging_no"));
			LodgingDao lodgingDao = new LodgingDaoImpl();
			Lodging lodging = lodgingDao.selectBylodging_no(lodging_no);
			System.out.println(lodging);
			req.setAttribute("lodging", lodging);	
		
		}else if(action.equals("lodging_update")) {
			System.out.println("update 도착하였습니다.");
			
			//getParameter할때 jsp의 name이랑 동일한지 꼭 확인
			int lodging_no = Integer.parseInt(req.getParameter("lodging_no"));
			String lodging_name = req.getParameter("lodging_name");
			String lodging_loc = req.getParameter("lodging_loc");
			String lodging_phone = req.getParameter("lodging_phone");
			String lodging_image = req.getParameter("lodging_image");
			
			Lodging lodging = new Lodging(lodging_no,lodging_name,lodging_loc,lodging_phone,lodging_image);
			LodgingDao lodgingDao = new LodgingDaoImpl();
			lodgingDao.update(lodging);
			
			req.setAttribute("message", "잘 수정되었습니다.");
			
		}else if(action.equals("lodging_delete")) {
			int lodging_no = Integer.parseInt(req.getParameter("lodging_no"));
			
			LodgingDao lodgingDao = new LodgingDaoImpl();
			lodgingDao.delete(lodging_no);
			
			req.setAttribute("message", "삭제되었습니다.");
		}
		
		//커밋 테스트
		
		//화면구성
		String dispatcherUrl = null;
		
		if(action.equals("lodging_input")) {
			dispatcherUrl = "/lodging_admin/lodgingsave.jsp";
		}else if(action.equals("lodging_save")) {
			dispatcherUrl = "/lodging_admin/result.jsp";
		}else if(action.equals("lodging_list")) {
			dispatcherUrl = "/lodging_admin/lodginglist.jsp";
		}else if(action.equals("lodging_detail")) {
			dispatcherUrl = "/lodging_admin/lodgingdetail.jsp";
		}else if(action.equals("lodging_update")) {
			dispatcherUrl = "/lodging_admin/result.jsp";
		}else if(action.equals("lodging_delete")) {
			dispatcherUrl = "/lodging_admin/result.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
	    dispatcher.forward(req, resp);
	}
}
