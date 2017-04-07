package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.BookPromo;
import ua.service.BookPromoService;

public class BookPromoEditor extends PropertyEditorSupport{
	private final BookPromoService bookpromoService;

	public BookPromoEditor(BookPromoService bookpromoService) {
		super();
		this.bookpromoService = bookpromoService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		BookPromo bp = bookpromoService.findOne(Integer.valueOf(text));
		setValue(bp);
	}


}
