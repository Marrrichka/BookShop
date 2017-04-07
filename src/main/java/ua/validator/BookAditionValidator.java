package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.BookAdition;
import ua.service.BookAditionService;

public class BookAditionValidator implements Validator {
	private final BookAditionService baddService;

	public BookAditionValidator(BookAditionService baddService) {
		super();
		this.baddService = baddService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return BookAdition.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	BookAdition badd= (BookAdition)target;
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adition","","Can`t be empty");
		if(baddService.findOne(badd.getAdition())!=null){
			errors.rejectValue("adition","","Already exist");
		}
	}
	
	

}
