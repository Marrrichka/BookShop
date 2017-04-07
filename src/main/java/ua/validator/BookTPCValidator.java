package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.BookTopicPidCat;
import ua.service.BookTPCService;

public class BookTPCValidator implements Validator{
	private final BookTPCService btpcService;

	public BookTPCValidator(BookTPCService btpcService) {
		super();
		this.btpcService = btpcService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return BookTopicPidCat.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BookTopicPidCat btpc = (BookTopicPidCat) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "booktpc","", "Can`t be empty");
		if(btpc.getTopic()==null){
			errors.rejectValue("topic", "", "Select topic");
		}
		if(btpcService.findOne(btpc.getBooktpc())!=null){
			errors.rejectValue("booktpc", "", "Already exist");
		}
		
		
	}

	

}
