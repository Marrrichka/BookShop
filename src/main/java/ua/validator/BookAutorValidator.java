package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.BookAutor;
import ua.service.BookAutorService;

public class BookAutorValidator implements Validator{

	private final BookAutorService baService;

	public BookAutorValidator(BookAutorService baService) {
		super();
		this.baService = baService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return BookAutor.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BookAutor ba= (BookAutor)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "autor", "","Can`t be empty");
		if(baService.findOne(ba.getAutor())!=null){
			errors.rejectValue("autor", "", "Already exist");
		}
		
	}
	
	
}
