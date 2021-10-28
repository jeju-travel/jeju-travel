package controller.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Review.ReivewDao;
import dao.Review.ReviewDaoImple;
import dao.air.AirReserveDaoImpl;
import dao.air.AirReviewDao;
import dao.air.AirReviewDaoImpl;
import dao.car.CarDao;
import dao.car.CarDaoImpl;
import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import dao.reserve.ReserveDao;
import dao.reserve.ReserveDaoImpl;
import model.Lodging.Lodging_review;
import model.Lodging.Lodgingadmin;
import model.air.AirReview;
import model.air.Airline;
import model.car.Car;
import model.car.CarReview;
import model.manager.Admin;
import model.manager.Member;
import util.JDBCUtil;


@WebServlet(name = "ReviewConroller", urlPatterns = { "/review", "/review_insert"})
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
		if (action.equals("review_insert")) {
			
			//아이디 내용 별점 비행기번호 받아오기
			HttpSession session = req.getSession();
			
			String id = (String) session.getAttribute("member");

			try {
				String airContent = req.getParameter("airContent");
				double airStar = Double.parseDouble(req.getParameter("air_star"));
				int airNo = Integer.parseInt(req.getParameter("airNo"));

				if (airNo != 0) {

					AirReview airRe = new AirReview();
					airRe.setAirContent(airContent);
					airRe.setAirHoroscope(airStar);
					airRe.setAirNo(airNo);
					airRe.setWriter(id);

					AirReviewDao airDao = new AirReviewDaoImpl();
					airDao.insert(id, airContent, airStar, airNo);
					System.out.println("항공 리뷰 : 저장 O");
				}

			} catch (NullPointerException ne) {
				System.out.println("항공 리뷰 :저장 X");
			}catch (NumberFormatException nfe) {
				System.out.println("항공 리뷰 :저장 X");
			}	

			try {
				double roomStar = Double.parseDouble(req.getParameter("room_star"));
				int roomNo = Integer.parseInt(req.getParameter("roomNo"));
				String roomContent = req.getParameter("roomContent");

				if (roomNo != 0) {

					Lodging_review roomRe = new Lodging_review();
					roomRe.setLodging_content(roomContent);
					roomRe.setLodging_horoscope(roomStar);
					roomRe.setWriter(id);
					roomRe.setlodging_no(roomNo);

					ReivewDao reDao = new ReviewDaoImple();
					reDao.insertLoadingReview(roomRe);
					System.out.println("숙소 리뷰 :저장 O");
				}
			} catch (NullPointerException ne) {
				System.out.println("숙소 리뷰 :저장 X");

			}catch (NumberFormatException nfe) {
				System.out.println("숙소 리뷰 :저장 X");
			}	

			try {
				int carNo = Integer.parseInt(req.getParameter("carNo"));
				double carStar = Double.parseDouble(req.getParameter("car_star"));
				String carrContent = req.getParameter("carContent");

				if (carNo != 0) {
					CarReview carRe = new CarReview();
					carRe.setCar_content(carrContent);
					carRe.setCar_horoscope(carStar);
					carRe.setCar_no(carNo);
					carRe.setWriter(id);

					CarDao carDao = new CarDaoImpl();
					carDao.CarReview(carRe);
					System.out.println("렌트카 리뷰 :저장 O");
				}

			} catch (NullPointerException ne) {

				System.out.println("렌트카 리뷰 :저장 X");
			} catch (NumberFormatException nfe) {
				System.out.println("렌트카 리뷰 :저장 X");
			}	

		} else if (action.equals("review")) {
			///-------------
		
			
			int airResNo = Integer.parseInt(req.getParameter("air"));
			int carResNo = Integer.parseInt(req.getParameter("car"));
			int roomResNo = Integer.parseInt(req.getParameter("lodging"));

			System.out.println("resNo: " + roomResNo);

			ReserveDao dao = new ReserveDaoImpl();
			Airline air = dao.selectAirByResNo(airResNo);
			Car car = dao.selectCarByResNo(carResNo);
			Lodgingadmin room = dao.selectRoomByResNo(roomResNo);
			//System.out.println("room: " + room.toString());

			req.setAttribute("air", air);
			req.setAttribute("car", car);
			req.setAttribute("lodging", room);
		}
		

		// 주소 이동
		String dispatchUrl = null;
		if (action.equals("review_insert")) {
			dispatchUrl = "mypage";
		}else if(action.equals("review")) {
			dispatchUrl = "/jsp/reserve/review.jsp";
		} 
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatchUrl);
		dispatcher.forward(req, resp);
	}
}
