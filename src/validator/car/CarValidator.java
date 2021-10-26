package validator.car;

import java.util.ArrayList;
import java.util.List;

import form.car.CarForm;
import formerror.car.CarError;

public class CarValidator {
	/*
	//save_v1 ����
	public List<String> validate(MemoForm memoForm){
		List<String> errors = new ArrayList<>(); 
		String name = memoForm.getName();		
		//trim�� ����� ->�����̽��ٴ����� (���������� ������ üũ)
		if(name==null || name.trim().isEmpty()) {
			errors.add("�̸��� �Է��ϼ���");
		}
		String age = memoForm.getAge();
		if(age==null || name.trim().isEmpty()) {
			errors.add("���̸� �Է��ϼ���");
		}else {  //�����ΰű��� üũ����ߵȴ�.						
			try {
				Integer.parseInt(age); //���ڷ� ��ȯ
			} catch (NumberFormatException nfe) {
				errors.add("���̿� ���ڸ� �־��ּ���");
			}			
		}
		
		return errors;		
	}*/
	
	//save_v2 ����
	public CarError validate(CarForm carForm){
		CarError carError = new CarError();
		
		String car_name = carForm.getCar_name();		
		//trim�� ����� ->�����̽��ٴ����� (���������� ������ üũ)
		if(car_name==null || car_name.trim().isEmpty()) {
			carError.setCar_nameErr("[���̸��� �Է����ּ���]");
			carError.setResult(true); //������ �ִ��� üũ
		}
		
		String car_type = carForm.getCar_type();		
		//trim�� ����� ->�����̽��ٴ����� (���������� ������ üũ)
		if(car_type==null || car_type.trim().isEmpty()) {
			carError.setCar_typeErr("[������ �Է����ּ���]");
			carError.setResult(true); //������ �ִ��� üũ
		}
		
		String car_price = carForm.getCar_price();
		if(car_price==null || car_price.trim().isEmpty()) {
			carError.setCar_priceErr("[������ �Է����ּ���]");
			carError.setResult(true);
		}else {  //�����ΰű��� üũ����ߵȴ�.						
			try {
				Integer.parseInt(car_price);  //���ڷ� ��ȯ
			} catch (NumberFormatException nfe) {
				carError.setCar_priceErr("[���ݿ� ���ڸ� �Է����ּ���]");
				carError.setResult(true);
			}			
		}
		
		String capacity = carForm.getCapacity();
		if(capacity==null || capacity.trim().isEmpty()) {
			carError.setCapacityErr("[�ο����� �Է����ּ���]");
			carError.setResult(true);
		}else {  //�����ΰű��� üũ����ߵȴ�.						
			try {
				Integer.parseInt(capacity);  //���ڷ� ��ȯ
			} catch (NumberFormatException nfe) {
				carError.setCapacityErr("[�ο����� ���ڸ� �Է����ּ���]");
				carError.setResult(true);
			}			
		}
		
		String car_fuel = carForm.getCar_fuel();		
		//trim�� ����� ->�����̽��ٴ����� (���������� ������ üũ)
		if(car_fuel==null || car_fuel.trim().isEmpty()) {
			carError.setCar_fuelErr("[���Ḧ �Է����ּ���]");
			carError.setResult(true); //������ �ִ��� üũ
		}
		
		String car_loc = carForm.getCar_loc();		
		//trim�� ����� ->�����̽��ٴ����� (���������� ������ üũ)
		if(car_loc==null || car_loc.trim().isEmpty()) {
			carError.setCar_locErr("[��ġ�� �Է����ּ���]");
			carError.setResult(true); //������ �ִ��� üũ
		}
		
		return carError;
	}
	
}
