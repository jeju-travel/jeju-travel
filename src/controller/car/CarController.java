package controller.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.car.CarDao;
import dao.car.CarDaoImpl;
import dao.car.Sql;
import dao.reserve.ReserveDao;
import dao.reserve.ReserveDaoImpl;
import form.car.CarForm;
import formerror.car.CarError;
import model.Lodging.Lodging_reserve;
import model.car.Car;
import model.car.CarReserve;
import model.car.Carhoroscope;
import page.car.PageDao;
import page.car.PageDaoImpl;
import page.car.PageGroupResult;
import page.car.PageManager;
import page.car.PageSql;
import validator.car.CarValidator;

@WebServlet(name="CarController" , urlPatterns= {"/car_input","/car_save","/car_search","/car_detail","/car_update","/car_delete","/car_select","/car_reserve","/main_car", "/carlist"})
public class CarController extends HttpServlet {
	
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
		int lastIndex = uri.lastIndexOf("/"); // 마지막에 있는 /까지 숫자를 세준다. 7		
		String action = uri.substring(lastIndex+1); // 마지막있는/+1번째 위치부터 끝까지의 uri문자열을 가져온다.
	
		if(action.equals("car_input")) {
			
		}else if(action.equals("car_save")) {	
			String car_name = req.getParameter("car_name");
			String car_type = req.getParameter("car_type");
			String car_price =req.getParameter("car_price");
			String capacity = req.getParameter("capacity");
			String car_fuel = req.getParameter("car_fuel");
			String car_loc = req.getParameter("car_loc");
			String car_image = req.getParameter("car_image");
			
			CarForm carForm = new CarForm(car_name,car_type,car_price,capacity,car_fuel,car_loc,car_image);	
			//여기서 체크해서 유효성 검사
			CarValidator validator = new CarValidator();
			CarError carError = validator.validate(carForm);
			
			if(!carError.isResult()) { //(!오류가 없으면)
				Car car=new Car();
				car.setCar_name(carForm.getCar_name());
				car.setCar_type(carForm.getCar_type());
				car.setCar_price(Integer.parseInt(carForm.getCar_price()));
				car.setCapacity(Integer.parseInt(carForm.getCapacity()));
				car.setCar_fuel(carForm.getCar_fuel());
				car.setCar_loc(carForm.getCar_loc());
				car.setCar_image(carForm.getCar_image());
				CarDao cardao = new CarDaoImpl();
				
				cardao.insert(car);
				req.setAttribute("message", "잘 저장 되었습니다.");	
			}else {
				req.setAttribute("carError",carError);//오류 보내기			
				req.setAttribute("carForm", carForm);
			}				
			
		}else if(action.equals("car_search")) {
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			CarDao dao = new CarDaoImpl();			
			List<Car> carList = dao.selectAll(requestPage);
    		PageDao pageDao = new PageDaoImpl();
			
    		int cnt = pageDao.getCount(PageSql.CAR_COUNT_SQL);
			
			PageManager pm =new PageManager(requestPage);
			PageGroupResult pgr = pm.getPageGroupResult(cnt);
    		
    		req.setAttribute("carList", carList);
    		req.setAttribute("pageGroupResult", pgr);
			
		}else if(action.equals("car_detail")) {
			
			int car_no = Integer.parseInt(req.getParameter("car_no"));
		
			CarDao dao = new CarDaoImpl();
			Car car = dao.selectByCarno(car_no);
			List<Car> carList = dao.CarselectAll();
			
			req.setAttribute("car", car);	
			req.setAttribute("carList", carList);
			
		}else if(action.equals("car_update")) {			
			String car_name = req.getParameter("car_name");
			String car_type = req.getParameter("car_type");
			String car_price =req.getParameter("car_price");
			String capacity = req.getParameter("capacity");
			String car_fuel = req.getParameter("car_fuel");
			String car_loc = req.getParameter("car_loc");
			String car_image = req.getParameter("car_image");			
			
			CarForm carForm = new CarForm(car_name,car_type,car_price,capacity,car_fuel,car_loc,car_image);
			CarValidator validator = new CarValidator();
			CarError carError = validator.validate(carForm);
			
			if(!carError.isResult()) { //(!오류가 없으면)
				Car car=new Car();
				int car_no = Integer.parseInt(req.getParameter("car_no"));
				
				car.setCar_name(carForm.getCar_name());
				car.setCar_type(carForm.getCar_type());
				car.setCar_price(Integer.parseInt(carForm.getCar_price()));
				car.setCapacity(Integer.parseInt(carForm.getCapacity()));
				car.setCar_fuel(carForm.getCar_fuel());
				car.setCar_loc(carForm.getCar_loc());
				car.setCar_image(carForm.getCar_image());
				car.setCar_no(car_no);
				CarDao cardao = new CarDaoImpl();
				
				cardao.Carupdate(car);
				req.setAttribute("message", "잘 수정 되었습니다.");	
			}else {
				int car_no = Integer.parseInt(req.getParameter("car_no"));
				
				CarDao dao = new CarDaoImpl();
				Car car = dao.selectByCarno(car_no);
				
				List<Car> carList = dao.CarselectAll();
				
				req.setAttribute("car", car);	
				req.setAttribute("carList", carList);
				
				req.setAttribute("carError",carError);//오류 보내기			
				req.setAttribute("carForm", carForm);
			}		
					
			
		}else if(action.equals("car_delete")) {
	         int car_no = Integer.parseInt(req.getParameter("car_no"));
	         
	         CarDao dao = new CarDaoImpl();
	         dao.Cardelete(car_no);
	        
	          	       
	    }else if(action.equals("car_select")) {	
	    	int requestPage = Integer.parseInt(req.getParameter("reqPage"));
	    	String start_day = req.getParameter("start_day");
	    	String end_day = req.getParameter("end_day");	
	    	
	    	String borrow_car = req.getParameter("borrow_car");
			String return_car = req.getParameter("return_car");
	    	String car_type= req.getParameter("car_type");
	    	String car_fuel= req.getParameter("car_fuel");
	    	CarDao dao = new CarDaoImpl();
	    	
	    	HttpSession session = req.getSession();
	    	int rental_day =dao.cha(end_day,start_day);
	    	session.setAttribute("rental_day", rental_day);
	    	List<Carhoroscope> carhoroscopeList = dao.Carhoroscope();
	    	
	    	if(car_type.equals("전체") && car_fuel.equals("전체")) {	    		
	    		List<Car> carList = dao.selectAll(requestPage);
	    		PageDao pageDao = new PageDaoImpl();
				
	    		int cnt = pageDao.getCount(PageSql.CAR_COUNT_SQL);
				
				PageManager pm =new PageManager(requestPage);
				PageGroupResult pgr = pm.getPageGroupResult(cnt);
	    		
	    		req.setAttribute("carList", carList);
	    		req.setAttribute("pageGroupResult", pgr);
	    		req.setAttribute("check", "check");
	    	}else if(car_type.equals("전체")) {
	    		List<Car> carList = dao.Carfuel(car_fuel);	    		
	    		req.setAttribute("carList", carList);
	    	}else if(car_fuel.equals("전체")) {
	    		List<Car> carList = dao.Cartype(car_type);
	    		req.setAttribute("carList", carList);
	    	}else {
	    		List<Car> carList = dao.Cartypefuel(car_type,car_fuel);
	    		req.setAttribute("carList", carList);
	    	}
			
			req.setAttribute("carhoroscopeList", carhoroscopeList);	
			req.setAttribute("borrow_car", borrow_car);
			req.setAttribute("return_car", return_car);
			req.setAttribute("rental_day", rental_day);			
	    }else if(action.equals("car_reserve")) {	
	    	HttpSession session = req.getSession();
			String borrow_car = req.getParameter("borrow_car");	
			String return_car = req.getParameter("return_car");	
			int rental_day = (int) session.getAttribute("rental_day");			
			int car_no = Integer.parseInt(req.getParameter("car_no"));
			CarReserve carRes = new CarReserve(borrow_car,return_car,rental_day,car_no);			
			session.setAttribute("carReserve",carRes);			
			
			//여기부터 테스트(화면출력할때 session.받아와서 req.set어트리뷰트로 화면에 뿌려준다)
			CarReserve carReserve=  (CarReserve) session.getAttribute("carReserve");
			
			req.setAttribute("carReserve", carReserve);  //이걸로 ReserveController에서 화면에 뿌려준다.	
			
			//if(세션 != null) 일때	
			/*if(session.getAttribute("carReserve")!=null) {
				HttpSession session = req.getSession();
				
				CarReserve car=  (CarReserve) session.getAttribute("carReserve");
				dao.CarReserve(car);  //CAR_RESERVE에 예약 
				int num = car.getCar_no();
				int resNo = (int)session.getAttribute("resNo"); //예약번호를 알아내서			
				dao.resNo(num, resNo);	//예약번호에 맞게 렌트카 자동차 시퀀스를 업데이트
			}*/
				
			
			
	    }else if(action.equals("main_car")) {
	    	String check = req.getParameter("check");
	    	if(check.equals("1")) {
		    	HttpSession session = req.getSession();
		    	String checkIn = req.getParameter("checkIn");
		    	String checkOut = req.getParameter("checkOut");
		    	int roomNo = Integer.parseInt(req.getParameter("roomNo"));
		    	System.out.println(roomNo);
		    	Lodging_reserve room = new Lodging_reserve(checkIn,checkOut,roomNo);
		    	session.setAttribute("lodgingReserve",room);
	    	}
	    	/*HttpSession session = req.getSession();
	    	
	    	int resNo = (int)session.getAttribute("resNo");
	   
	    	int roomNo = Integer.parseInt(req.getParameter("roomNo"));
	    	
	    	String checkIn = req.getParameter("checkIn");
	    	String checkOut = req.getParameter("checkOut");
	    
	    	ReserveDao dao = new ReserveDaoImpl();
	    	
	    	Lodging_reserve room = new Lodging_reserve();
	    	room.setCheck_in(checkIn);
	    	room.setCheck_out(checkOut);
	    	room.setLodging_no(roomNo);
	    	
	    	dao.insertRoomRes(room);
	    	int lodgingResNo = dao.selectByNo();
	    	System.out.println("룸번호: " + lodgingResNo);
	    	
	    	//roomResNo, resNo
	    	dao.updateRoomResNo(lodgingResNo, resNo);
	    	*/
	    }
		
		String dispatcherUrl = null;
	
		if(action.equals("car_input")) {			
			dispatcherUrl = "jsp/car/carinsert.jsp";  	
			
		}else if(action.equals("car_save")) {			
			dispatcherUrl = "jsp/car/carinsert.jsp";
			
		}else if(action.equals("car_search")) {
			dispatcherUrl = "jsp/car/carselect.jsp";				
			
		}else if(action.equals("car_detail")) {
			dispatcherUrl = "jsp/car/cardetail.jsp";	
			
		}else if(action.equals("car_update")) {
			dispatcherUrl = "jsp/car/cardetail.jsp";	
			
		}else if(action.equals("car_delete")) {
			dispatcherUrl = "car_search";	
			
	    }else if(action.equals("main_car")) {	    	
	    	dispatcherUrl = "/jsp/main/car.jsp";
	    	
	    }else if(action.equals("carlist")) {
	    	HttpSession session = req.getSession();	    		
	    	String check = req.getParameter("check");
	    	
	    	if (session.getAttribute("airRes") ==null && session.getAttribute("lodgingReserve") ==null && check.equals("0")) {	    		
	    		req.setAttribute("message", "아무것도 예약하지 않았습니다");
	    		dispatcherUrl = "index.jsp";
	    	}else if(check.equals("1")) {
	    		dispatcherUrl = "/jsp/car/carlist.jsp";
	    	}else {
	    		dispatcherUrl = "shopping_cart";
	    	}	    	
	    	
	    }else if(action.equals("car_select")) {
	    	dispatcherUrl = "jsp/car/carlist.jsp";
	    	
	    }else if(action.equals("car_reserve")) {
	    	dispatcherUrl = "shopping_cart"; 
	    	
	    }		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
