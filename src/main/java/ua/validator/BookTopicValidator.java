package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.BookTopic;
import ua.service.BookTopicService;

public class BookTopicValidator implements Validator {
	private final BookTopicService btService;

	public BookTopicValidator(BookTopicService btService) {
		super();
		this.btService = btService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return BookTopic.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BookTopic bt=(BookTopic)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "topic","","Can`t be empty");
		if(btService.findOne(bt.getTopic())!=null){
			errors.rejectValue("topic", "", "Already exist");
		}
	}
	

}
