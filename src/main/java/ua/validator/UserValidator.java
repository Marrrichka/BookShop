package ua.validator;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import form.UserForm;
import ua.service.UserService;



public class UserValidator implements Validator{
	private final UserService userService;
	

	public UserValidator(UserService userService) {
		super();
		this.userService = userService;
	}

	private static final Pattern pattern = Pattern.compile("^[0][0-9]{9}+$");

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(UserForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
	UserForm u=(UserForm)target;
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "", "Can`t be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Can`t be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "Can`t be empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number", "", "Can`t be empty");
	if(!pattern.matcher(u.getNumber()).matches()){
		errors.rejectValue("number", "", "Wrong format");
	}
	if(userService.findByUsername(u.getUsername())!=null){
		errors.rejectValue("username","","Already exist");
	}

	if(!isValidEmailAddress(u.getEmail())){
		errors.rejectValue("email", "", "Email doesn`t exist");
	}
	else if(userService.findByEmail(u.getUsername())!=null){
		errors.rejectValue("email", "", "Already exist");
	} 
	
	if(u.getPassword().length()<6){
		errors.rejectValue("password", "", "Should be more than six symbol");
	}
	}
	public static boolean isValidEmailAddress(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}
	
}
