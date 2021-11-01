package validator.lodging;

import java.util.ArrayList;
import java.util.List;

import form.lodging.LodgingForm;
import formerror.lodging.LodgingError;

public class Lodgingvalidator {
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
	public LodgingError validate(LodgingForm lodgingForm){
		LodgingError lodgingError = new LodgingError();
		
		String lodging_name = lodgingForm.getLodging_name();		
		//trim은 빈공간 ->스페이스바누른거 (빈공간지우고 널인지 체크)
		if(lodging_name==null || lodging_name.trim().isEmpty()) {
			lodgingError.setLodging_nameErr("[숙소 이름을 입력해주세요]");
			lodgingError.setResult(true); //에러가 있는지 체크
		}
		
		String lodging_loc = lodgingForm.getLodging_loc();		
		//trim은 빈공간 ->스페이스바누른거 (빈공간지우고 널인지 체크)
		if(lodging_loc==null || lodging_loc.trim().isEmpty()) {
			lodgingError.setLodging_locErr("[숙소 위치를 입력해주세요]");
			lodgingError.setResult(true); //에러가 있는지 체크
		}
		
		String lodging_phone = lodgingForm.getLodging_phone();
		if(lodging_phone==null || lodging_phone.trim().isEmpty()) {
			lodgingError.setLodging_phoneErr("[숙소 전화번호를 입력해주세요]");
			lodgingError.setResult(true);
		}
		
		String lodging_price = lodgingForm.getLodging_price();
        if(lodging_price==null || lodging_price.trim().isEmpty()) {
        	lodgingError.setLodging_priceErr("[가격을 입력해주세요]");
        	lodgingError.setResult(true);
        }else {  //숫자인거까지 체크해줘야된다.
            try {
                Integer.parseInt(lodging_price);  //숫자로 변환
            } catch (NumberFormatException nfe) {
            	lodgingError.setLodging_priceErr("[가격에 숫자를 입력해주세요]");
            	lodgingError.setResult(true);
            }
        }
		
		/*String lodging_price = lodgingForm.getLodging_price();
		if(lodging_price==null || lodging_price.trim().isEmpty()) {
			lodgingError.setLodging_priceErr("[가격을 입력해주세요]");
			lodgingError.setResult(true);
		}else {  //숫자인거까지 체크해줘야된다.						
			try {
				Integer.parseInt(lodging_price);  //숫자로 변환
			} catch (NumberFormatException nfe) {
				lodgingError.setLodging_priceErr("[가격에 숫자를 입력해 주세요.]");
				lodgingError.setResult(true);
			}			
		}*/
		
		String lodging_image = lodgingForm.getLodging_image();
		if(lodging_image==null || lodging_image.trim().isEmpty()) {
			lodgingError.setLodging_imageErr("[이미지를 입력해주세요]");
			lodgingError.setResult(true);
		}
		
		return lodgingError;
	}
	
}
