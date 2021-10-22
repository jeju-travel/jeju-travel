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
import validator.memo.CarValidator;

@WebServlet(name="CarController" , urlPatterns= {"/car_input","/car_save","/car_search","/car_detail","/memo_update","/memo_delete"})
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
			//car img�ϸ� �߰� ����.  �ؿ��� �߰�, carForm���� img�߰�	,err���� �߰�	
			CarForm carForm = new CarForm(car_name,car_type,car_price,capacity,car_fuel,car_loc);	
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
				//car img
				CarDao cardao = new CarDaoImpl();
				
				cardao.insert(car);
				req.setAttribute("message", "�� ���� �Ǿ����ϴ�.");	
			}else {
				req.setAttribute("carError",carError);//���� ������			
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
			
			req.setAttribute("car", car);			
			
		}/*else if(action.equals("memo_update")) {
			int memoid = Integer.parseInt(req.getParameter("memoid"));
			String name= req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age"));
			
			Memo memo = new Memo(memoid,name,age);
			MemoDao dao = new MemoDaoImpl();
			dao.update(memo);
			req.setAttribute("message", "�߼����Ǿ����ϴ�");			
			
		}else if(action.equals("memo_delete")) {
	         int memoid = Integer.parseInt(req.getParameter("memoid"));
	         
	         MemoDao dao = new MemoDaoImpl();
	         dao.delete(memoid);
	         
	         req.setAttribute("message", "�� �����Ǿ����ϴ�.");
	         	       
	    }*/
		String dispatcherUrl = null;
		//String dispatcherUrl = "jsp/memo/"; �ϰ� dispatcherUrl+"memsave.jsp"; ������
		if(action.equals("car_input")) {			
			dispatcherUrl = "car/carinsert.jsp";  	
			
		}else if(action.equals("car_save")) {			
			dispatcherUrl = "car/carinsert.jsp";
			
		}else if(action.equals("car_search")) {
			dispatcherUrl = "car/carselect.jsp";				
			
		}else if(action.equals("car_detail")) {
			dispatcherUrl = "car/carupde.jsp";	
			
		}/*else if(action.equals("memo_update")) {
			dispatcherUrl = "/jsp/memo/result.jsp";	
			
		}else if(action.equals("memo_delete")) {
			dispatcherUrl = "/jsp/memo/result.jsp";
	        
	    }*/
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
