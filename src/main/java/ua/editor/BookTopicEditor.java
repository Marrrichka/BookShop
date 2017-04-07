package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.BookTopic;
import ua.service.BookTopicService;

public class BookTopicEditor extends PropertyEditorSupport {
	private final BookTopicService booktopicService;

	public BookTopicEditor(BookTopicService booktopicService) {
		super();
		this.booktopicService = booktopicService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		BookTopic bt = booktopicService.findOne(Integer.valueOf(text));
		setValue(bt);
	}

}
