package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.BookAdition;
import ua.service.BookAditionService;

public class BookAditionEditor extends PropertyEditorSupport {

	private final BookAditionService bookaditionService;

	public BookAditionEditor(BookAditionService bookaditionService) {
		super();
		this.bookaditionService = bookaditionService;
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		BookAdition badd = bookaditionService.findOne(Integer.valueOf(text));
		setValue(badd);
	}
}
