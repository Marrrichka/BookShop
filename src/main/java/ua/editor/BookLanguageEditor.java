package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.BookLanguage;
import ua.service.BookLanguageService;

public class BookLanguageEditor extends PropertyEditorSupport {

	private final BookLanguageService booklanguageService;

	public BookLanguageEditor(BookLanguageService booklanguageService) {
		super();
		this.booklanguageService = booklanguageService;
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		BookLanguage bl = booklanguageService.findOne(Integer.valueOf(text));
		setValue(bl);
	}

}
