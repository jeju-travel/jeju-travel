package controller.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import model.Lodging.Lodging_review;
import model.Lodging.Lodgingadmin;
import model.air.AirReview;
import model.car.CarReview;
import model.manager.Admin;
import model.manager.Member;
import util.JDBCUtil;


@WebServlet(name = "ReviewConroller", urlPatterns = { "/re_insert"})
public class ReviewController extends HttpServlet {

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
		if (action.equals("re_insert")) {
			
			//아이디 내용 별점 비행기번호 받아오기
			HttpSession session = req.getSession();
			String id = (String)session.getAttribute("member");
			
			String airContent = req.getParameter("airContent");
			String carrContent = req.getParameter("carContent");
			String roomContent = req.getParameter("roomContent");
			
			int airStar = Integer.parseInt(req.getParameter("air_star"));
			int carStar = Integer.parseInt(req.getParameter("car_star"));
			int roomStar = Integer.parseInt(req.getParameter("room_star"));
		
			int airNo = Integer.parseInt(req.getParameter("airNo"));
			int carNo = Integer.parseInt(req.getParameter("carNo"));
			int roomNo = Integer.parseInt(req.getParameter("roomNo"));
	
			//reivew 만들기
			AirReview airRe = new AirReview();
			airRe.setAirContent(airContent);
			airRe.setAirHoroscope(airStar);
			//변경하기airRe.setAirReserveNo(airReserveNo);
			//추가하기 아이디
			
			CarReview carRe = new CarReview();
			carRe.setCar_content(carrContent);
			carRe.setCar_horoscope(carStar);
			//변경하기airRe.setAirReserveNo(airReserveNo);
			//추가하기 아이디
			
			Lodging_review roomRe = new Lodging_review();
			roomRe.setLodging_content(roomContent);
			roomRe.setLodging_horoscope(roomStar);
			//변경하기airRe.setAirReserveNo(airReserveNo);
			//추가하기 아이디
		} 
		

		// 주소 이동
		String dispatchUrl = null;
		if (action.equals("re_insert")) {
			dispatchUrl = "/jsp/member/login.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatchUrl);
		dispatcher.forward(req, resp);
	}
}
