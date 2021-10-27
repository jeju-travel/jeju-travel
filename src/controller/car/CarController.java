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
import formerror.car.CarError;

import model.car.Car;
import model.car.CarReserve;
import model.car.Carhoroscope;
import page.car.PageDao;
import page.car.PageDaoImpl;
import page.car.PageGroupResult;
import page.car.PageManager;
import page.car.PageSql;
import validator.car.CarValidator;

@WebServlet(name="CarController" , urlPatterns= {"/car_input","/car_save","/car_search","/car_detail","/car_update","/car_delete","/jsp/car/car_select","/jsp/car/car_reserve"})
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
		int lastIndex = uri.lastIndexOf("/"); // �������� �ִ� /���� ���ڸ� ���ش�. 7		
		String action = uri.substring(lastIndex+1); // �������ִ�/+1��° ��ġ���� �������� uri���ڿ��� �����´�.
	
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
			//���⼭ üũ�ؼ� ��ȿ�� �˻�
			CarValidator validator = new CarValidator();
			CarError carError = validator.validate(carForm);
			
			if(!carError.isResult()) { //(!������ ������)
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
				req.setAttribute("message", "�� ���� �Ǿ����ϴ�.");	
			}else {
				req.setAttribute("carError",carError);//���� ������			
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
			String car_img = req.getParameter("car_img");			
			
			CarForm carForm = new CarForm(car_name,car_type,car_price,capacity,car_fuel,car_loc,car_img);
			CarValidator validator = new CarValidator();
			CarError carError = validator.validate(carForm);
			
			if(!carError.isResult()) { //(!������ ������)
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
				req.setAttribute("message", "�� ���� �Ǿ����ϴ�.");	
			}else {
				int car_no = Integer.parseInt(req.getParameter("car_no"));
				
				CarDao dao = new CarDaoImpl();
				Car car = dao.selectByCarno(car_no);
				
				List<Car> carList = dao.CarselectAll();
				
				req.setAttribute("car", car);	
				req.setAttribute("carList", carList);
				
				req.setAttribute("carError",carError);//���� ������			
				req.setAttribute("carForm", carForm);
			}		
					
			
		}else if(action.equals("car_delete")) {
	         int car_no = Integer.parseInt(req.getParameter("car_no"));
	         
	         CarDao dao = new CarDaoImpl();
	         dao.Cardelete(car_no);
	        
	          	       
	    }else if(action.equals("car_select")) {	    	
	    	String start_day = req.getParameter("start_day");
	    	String end_day = req.getParameter("end_day");	
	    	
	    	String borrow_car = req.getParameter("borrow_car");
			String return_car = req.getParameter("return_car");
	    	String car_type= req.getParameter("car_type");
	    	String car_fuel= req.getParameter("car_fuel");
	    	CarDao dao = new CarDaoImpl();
	    	
	    	int cha =dao.cha(end_day,start_day);	    	
	    	List<Carhoroscope> carhoroscopeList = dao.Carhoroscope();
	    	
	    	if(car_type.equals("��ü") && car_fuel.equals("��ü")) {	    		
	    		List<Car> carList = dao.CarselectAllprice();
	    		req.setAttribute("carList", carList);
	    	}else if(car_type.equals("��ü")) {
	    		List<Car> carList = dao.Carfuel(car_fuel);	    		
	    		req.setAttribute("carList", carList);
	    	}else if(car_fuel.equals("��ü")) {
	    		List<Car> carList = dao.Cartype(car_type);
	    		req.setAttribute("carList", carList);
	    	}else {
	    		List<Car> carList = dao.Cartypefuel(car_type,car_fuel);
	    		req.setAttribute("carList", carList);
	    	}
			
			req.setAttribute("carhoroscopeList", carhoroscopeList);	
			req.setAttribute("borrow_car", borrow_car);
			req.setAttribute("return_car", return_car);
			req.setAttribute("cha", cha);
	    }else if(action.equals("car_reserve")) {	    		
			String borrow_car = req.getParameter("borrow_car");	
			String return_car = req.getParameter("return_car");	
			int car_no = Integer.parseInt(req.getParameter("car_no"));
			
			CarReserve carReserve = new CarReserve(borrow_car,return_car,car_no);			
			
			CarDao dao = new CarDaoImpl();
			dao.CarReserve(carReserve);
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
			
	    }else if(action.equals("car_select")) {
	    	dispatcherUrl = "carlist.jsp";
	    	
	    }else if(action.equals("car_reserve")) {
	    	dispatcherUrl = "carlist.jsp"; //���߿� ������������ �Ѿ�ߵ�.
	    }
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
