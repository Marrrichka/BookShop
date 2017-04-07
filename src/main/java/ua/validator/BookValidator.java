package ua.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import form.BookForm;

public class BookValidator implements Validator{
	
	private final static Pattern PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})$");
	private static final Pattern p = Pattern.compile("[0-9]+");
	
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(BookForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BookForm b=(BookForm)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookname", "", "Can`t be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookPages", "", "Can`t be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookYear", "", "Can`t be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookPrice", "", "Can`t be empty");
				
		if(!p.matcher(b.getBookPages()).matches()){
			errors.rejectValue("bookPages", "", "Wrong format");
		}
		if(!p.matcher(b.getBookYear()).matches()){
			errors.rejectValue("bookYear", "", "Wrong format");
		}
		if(!PATTERN.matcher(b.getBookPrice()).matches()){
			errors.rejectValue("bookPrice", "", "Wrong format, only 2 digits after separator");
		}
	}

	
}
