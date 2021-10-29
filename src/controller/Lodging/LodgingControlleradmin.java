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

@WebServlet(name="LodgingControlleradmin", urlPatterns= {"/lodging_input","/lodging_save","/lodging_list","/lodging_detail","/lodging_update","/lodging_delete"})
public class LodgingControlleradmin extends HttpServlet{
	
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
		//����
		if(action.equals("lodging_input")) {
			
		}else if(action.equals("lodging_save")) {
			System.out.println("save �����Ͽ����ϴ�.");
			
			//getParameter�Ҷ� jsp�� name�̶� �������� �� Ȯ��
			String lodging_name = req.getParameter("lodgingname");
			String lodging_loc = req.getParameter("lodgingloc");
			String lodging_phone = req.getParameter("lodgingphone");
			int lodging_price = Integer.parseInt(req.getParameter("lodging_price")); 
			String lodging_image = req.getParameter("lodgingimage");
			
			Lodgingadmin lodging = new Lodgingadmin(lodging_name,lodging_loc,lodging_phone,lodging_price,lodging_image);
			
			LodgingDao lodgingDao = new LodgingDaoImpl();
			lodgingDao.insert(lodging);
			System.out.println("��ϵǾ����ϴ�.");
			req.setAttribute("message","��ϵǾ����ϴ�.");
			
		}else if(action.equals("lodging_list")) {
			System.out.println("list �����Ͽ����ϴ�.");
			
			LodgingDao lodgingDao = new LodgingDaoImpl();
			List<Lodgingadmin> lodgingList = lodgingDao.selectAll();
			req.setAttribute("lodgingList", lodgingList);
			
		}else if(action.equals("lodging_detail")) {
	        int lodging_no = Integer.parseInt(req.getParameter("lodging_no"));
	        LodgingDao lodgingDao = new LodgingDaoImpl();
	        Lodgingadmin lodging = lodgingDao.selectBylodging_no(lodging_no);
	        System.out.println(lodging);
	        req.setAttribute("lodging", lodging);
	    }else if(action.equals("lodging_update")) {
			System.out.println("update �����Ͽ����ϴ�.");
			
			//getParameter�Ҷ� jsp�� name�̶� �������� �� Ȯ��
			int lodging_no = Integer.parseInt(req.getParameter("lodging_no"));
			String lodging_name = req.getParameter("lodging_name");
			String lodging_loc = req.getParameter("lodging_loc");
			String lodging_phone = req.getParameter("lodging_phone");
			int lodging_price = Integer.parseInt(req.getParameter("lodging_price"));
			String lodging_image = req.getParameter("lodging_image");
			
			Lodgingadmin lodging = new Lodgingadmin(lodging_no,lodging_name,lodging_loc,lodging_phone,lodging_price,lodging_image);
			LodgingDao lodgingDao = new LodgingDaoImpl();
			lodgingDao.update(lodging);
			
			req.setAttribute("message", "�� �����Ǿ����ϴ�.");
			
		}else if(action.equals("lodging_delete")) {
			int lodging_no = Integer.parseInt(req.getParameter("lodging_no"));
			
			LodgingDao lodgingDao = new LodgingDaoImpl();
			lodgingDao.delete(lodging_no);
			
			req.setAttribute("message", "�����Ǿ����ϴ�.");
		}
		
		//ȭ�鱸��
		String dispatcherUrl = null;
		
		if(action.equals("lodging_input")) {
			dispatcherUrl = "/jsp/lodging_admin/lodgingsave.jsp";
		}else if(action.equals("lodging_save")) {
			dispatcherUrl = "/jsp/lodging_admin/result.jsp";
		}else if(action.equals("lodging_list")) {
			dispatcherUrl = "/jsp/lodging_admin/lodginglist.jsp";
		}else if(action.equals("lodging_detail")) {
			dispatcherUrl = "/jsp/lodging_admin/lodgingdetail.jsp";
		}else if(action.equals("lodging_update")) {
			dispatcherUrl = "/jsp/lodging_admin/result.jsp";
		}else if(action.equals("lodging_delete")) {
			dispatcherUrl = "/jsp/lodging_admin/result.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
	    dispatcher.forward(req, resp);
	}
}
