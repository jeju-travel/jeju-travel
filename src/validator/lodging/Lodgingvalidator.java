package validator.lodging;

import java.util.ArrayList;
import java.util.List;

import form.lodging.LodgingForm;
import formerror.lodging.LodgingError;

public class Lodgingvalidator {
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
	public LodgingError validate(LodgingForm lodgingForm){
		LodgingError lodgingError = new LodgingError();
		
		String lodging_name = lodgingForm.getLodging_name();		
		//trim�� ����� ->�����̽��ٴ����� (���������� ������ üũ)
		if(lodging_name==null || lodging_name.trim().isEmpty()) {
			lodgingError.setLodging_nameErr("[���� �̸��� �Է����ּ���]");
			lodgingError.setResult(true); //������ �ִ��� üũ
		}
		
		String lodging_loc = lodgingForm.getLodging_loc();		
		//trim�� ����� ->�����̽��ٴ����� (���������� ������ üũ)
		if(lodging_loc==null || lodging_loc.trim().isEmpty()) {
			lodgingError.setLodging_locErr("[���� ��ġ�� �Է����ּ���]");
			lodgingError.setResult(true); //������ �ִ��� üũ
		}
		
		String lodging_phone = lodgingForm.getLodging_phone();
		if(lodging_phone==null || lodging_phone.trim().isEmpty()) {
			lodgingError.setLodging_phoneErr("[���� ��ȭ��ȣ�� �Է����ּ���]");
			lodgingError.setResult(true);
		}
		
		String lodging_price = lodgingForm.getLodging_price();
        if(lodging_price==null || lodging_price.trim().isEmpty()) {
        	lodgingError.setLodging_priceErr("[������ �Է����ּ���]");
        	lodgingError.setResult(true);
        }else {  //�����ΰű��� üũ����ߵȴ�.
            try {
                Integer.parseInt(lodging_price);  //���ڷ� ��ȯ
            } catch (NumberFormatException nfe) {
            	lodgingError.setLodging_priceErr("[���ݿ� ���ڸ� �Է����ּ���]");
            	lodgingError.setResult(true);
            }
        }
		
		/*String lodging_price = lodgingForm.getLodging_price();
		if(lodging_price==null || lodging_price.trim().isEmpty()) {
			lodgingError.setLodging_priceErr("[������ �Է����ּ���]");
			lodgingError.setResult(true);
		}else {  //�����ΰű��� üũ����ߵȴ�.						
			try {
				Integer.parseInt(lodging_price);  //���ڷ� ��ȯ
			} catch (NumberFormatException nfe) {
				lodgingError.setLodging_priceErr("[���ݿ� ���ڸ� �Է��� �ּ���.]");
				lodgingError.setResult(true);
			}			
		}*/
		
		String lodging_image = lodgingForm.getLodging_image();
		if(lodging_image==null || lodging_image.trim().isEmpty()) {
			lodgingError.setLodging_imageErr("[�̹����� �Է����ּ���]");
			lodgingError.setResult(true);
		}
		
		return lodgingError;
	}
	
}
