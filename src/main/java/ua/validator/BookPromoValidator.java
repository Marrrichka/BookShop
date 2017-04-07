package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.BookPromo;
import ua.service.BookPromoService;

public class BookPromoValidator implements Validator{
	private final BookPromoService bpService;

	public BookPromoValidator(BookPromoService bpService) {
		super();
		this.bpService = bpService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return BookPromo.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BookPromo bp = (BookPromo)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "promo","", "Can`t be empty");
		if(bpService.findOne(bp.getPromo())!=null){
			errors.rejectValue("promo","", "Already exist");
		}
		
	}
	

}
