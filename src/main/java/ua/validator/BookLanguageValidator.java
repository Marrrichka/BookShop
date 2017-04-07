package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.BookLanguage;
import ua.service.BookLanguageService;

public class BookLanguageValidator implements Validator{
	private final BookLanguageService blService;

	public BookLanguageValidator(BookLanguageService blService) {
		super();
		this.blService = blService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return BookLanguage.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BookLanguage bl = (BookLanguage)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "language","","Can`t be empty");
		if(blService.findOne(bl.getLanguage())!=null){
			errors.rejectValue("language", "", "Already exist");
		}
		
	}
	

}
