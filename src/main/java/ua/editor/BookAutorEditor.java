package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.BookAutor;
import ua.service.BookAutorService;

public class BookAutorEditor extends PropertyEditorSupport{

	private final BookAutorService bookautorService;

	public BookAutorEditor(BookAutorService bookautorService) {
		super();
		this.bookautorService = bookautorService;
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		BookAutor ba = bookautorService.findOne(Integer.valueOf(text));
		setValue(ba);
	}
	
}
