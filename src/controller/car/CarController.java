package controller.car;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.car.CarDao;
import dao.car.CarDaoImpl;
import form.car.CarForm;
import formerror.CarError;
import model.Car;
import model.Carhoroscope;
import validator.memo.CarValidator;

@WebServlet(name="CarController" , urlPatterns= {"/car_input","/car_save","/car_search","/car_detail","/car_update","/car_delete","/car_select"})
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
			String car_img = req.getParameter("car_img");
			
			CarForm carForm = new CarForm(car_name,car_type,car_price,capacity,car_fuel,car_loc,car_img);	
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
				car.setCar_img(carForm.getCar_img());
				CarDao cardao = new CarDaoImpl();
				
				cardao.insert(car);
				req.setAttribute("message", "잘 저장 되었습니다.");	
			}else {
				req.setAttribute("carError",carError);//오류 보내기			
				req.setAttribute("carForm", carForm);
			}				
			
		}else if(action.equals("car_search")) {
			CarDao dao = new CarDaoImpl();
			List<Car> carList = dao.CarselectAll();
			
			req.setAttribute("carList", carList);			
			
			
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
			String car_img = req.getParameter("car_img");			
			
			CarForm carForm = new CarForm(car_name,car_type,car_price,capacity,car_fuel,car_loc,car_img);
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
				car.setCar_img(carForm.getCar_img());
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
	    	String date1 = req.getParameter("date1");
	    	String date2 = req.getParameter("date2");
	    	System.out.println(date1);
	    	String borrow_car = req.getParameter("borrow_car");
			String return_car = req.getParameter("return_car");
	    	
	    	CarDao dao = new CarDaoImpl();
	    	List<Carhoroscope> carhoroscopeList = dao.Carhoroscope();
	    	    	
			List<Car> carList = dao.CarselectAll();
									
			req.setAttribute("carList", carList);
			req.setAttribute("carhoroscopeList", carhoroscopeList);	
			req.setAttribute("borrow_car", borrow_car);
			req.setAttribute("return_car", return_car);
	    }
		String dispatcherUrl = null;
	
		if(action.equals("car_input")) {			
			dispatcherUrl = "car/carinsert.jsp";  	
			
		}else if(action.equals("car_save")) {			
			dispatcherUrl = "/car/carinsert.jsp";
			
		}else if(action.equals("car_search")) {
			dispatcherUrl = "car/carselect.jsp";				
			
		}else if(action.equals("car_detail")) {
			dispatcherUrl = "car/cardetail.jsp";	
			
		}else if(action.equals("car_update")) {
			dispatcherUrl = "car/cardetail.jsp";	
			
		}else if(action.equals("car_delete")) {
			dispatcherUrl = "car_search";	
			
	    }else if(action.equals("car_select")) {
	    	dispatcherUrl = "carlist.jsp";
	    }
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
