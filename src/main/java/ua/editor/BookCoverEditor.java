package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.BookCover;
import ua.service.BookCoverService;

public class BookCoverEditor extends PropertyEditorSupport{

	private final BookCoverService bookcoverService;

	public BookCoverEditor(BookCoverService bookcoverService) {
		super();
		this.bookcoverService = bookcoverService;
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		BookCover bc = bookcoverService.findOne(Integer.valueOf(text));
		setValue(bc);
}
}
