package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.BookCover;
import ua.service.BookCoverService;

public class BookCoverValidator implements Validator{
	private final BookCoverService bookcoverService;
	

	public BookCoverValidator(BookCoverService bookcoverService) {
		super();
		this.bookcoverService = bookcoverService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return BookCover.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BookCover bc= (BookCover)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cover","", "Can`t be empty");
		if(bookcoverService.findOne(bc.getCover())!=null){
			errors.rejectValue("cover", "", "Already exist");
		}
	}

}
