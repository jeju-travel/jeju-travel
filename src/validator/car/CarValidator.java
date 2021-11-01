package validator.car;

import java.util.ArrayList;
import java.util.List;

import form.car.CarForm;
import formerror.car.CarError;

public class CarValidator {
	/*
	//save_v1 버전
	public List<String> validate(MemoForm memoForm){
		List<String> errors = new ArrayList<>(); 
		String name = memoForm.getName();		
		//trim은 빈공간 ->스페이스바누른거 (빈공간지우고 널인지 체크)
		if(name==null || name.trim().isEmpty()) {
			errors.add("이름을 입력하세요");
		}
		String age = memoForm.getAge();
		if(age==null || name.trim().isEmpty()) {
			errors.add("나이를 입력하세요");
		}else {  //숫자인거까지 체크해줘야된다.						
			try {
				Integer.parseInt(age); //숫자로 변환
			} catch (NumberFormatException nfe) {
				errors.add("나이에 숫자를 넣어주세요");
			}			
		}
		
		return errors;		
	}*/
	
	//save_v2 버전
	public CarError validate(CarForm carForm){
		CarError carError = new CarError();
		
		String car_name = carForm.getCar_name();		
		//trim은 빈공간 ->스페이스바누른거 (빈공간지우고 널인지 체크)
		if(car_name==null || car_name.trim().isEmpty()) {
			carError.setCar_nameErr("[차이름을 입력해주세요]");
			carError.setResult(true); //에러가 있는지 체크
		}
		
		String car_type = carForm.getCar_type();		
		//trim은 빈공간 ->스페이스바누른거 (빈공간지우고 널인지 체크)
		if(car_type==null || car_type.trim().isEmpty()) {
			carError.setCar_typeErr("[차종을 입력해주세요]");
			carError.setResult(true); //에러가 있는지 체크
		}
		
		String car_price = carForm.getCar_price();
		if(car_price==null || car_price.trim().isEmpty()) {
			carError.setCar_priceErr("[가격을 입력해주세요]");
			carError.setResult(true);
		}else {  //숫자인거까지 체크해줘야된다.						
			try {
				Integer.parseInt(car_price);  //숫자로 변환
			} catch (NumberFormatException nfe) {
				carError.setCar_priceErr("[가격에 숫자를 입력해주세요]");
				carError.setResult(true);
			}			
		}
		
		String capacity = carForm.getCapacity();
		if(capacity==null || capacity.trim().isEmpty()) {
			carError.setCapacityErr("[인원수를 입력해주세요]");
			carError.setResult(true);
		}else {  //숫자인거까지 체크해줘야된다.						
			try {
				Integer.parseInt(capacity);  //숫자로 변환
			} catch (NumberFormatException nfe) {
				carError.setCapacityErr("[인원수에 숫자를 입력해주세요]");
				carError.setResult(true);
			}			
		}
		
		String car_fuel = carForm.getCar_fuel();		
		//trim은 빈공간 ->스페이스바누른거 (빈공간지우고 널인지 체크)
		if(car_fuel==null || car_fuel.trim().isEmpty()) {
			carError.setCar_fuelErr("[연료를 입력해주세요]");
			carError.setResult(true); //에러가 있는지 체크
		}
		
		String car_loc = carForm.getCar_loc();		
		//trim은 빈공간 ->스페이스바누른거 (빈공간지우고 널인지 체크)
		if(car_loc==null || car_loc.trim().isEmpty()) {
			carError.setCar_locErr("[위치를 입력해주세요]");
			carError.setResult(true); //에러가 있는지 체크
		}
		
		String car_image = carForm.getCar_image();		
		//trim은 빈공간 ->스페이스바누른거 (빈공간지우고 널인지 체크)
		if(car_image==null || car_image.trim().isEmpty()) {
			carError.setCar_imgErr("[이미지를 입력해주세요]");
			carError.setResult(true); //에러가 있는지 체크
		}
		return carError;
	}
	
}
