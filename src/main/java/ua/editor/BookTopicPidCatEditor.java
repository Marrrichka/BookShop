package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.BookTopicPidCat;
import ua.service.BookTPCService;

public class BookTopicPidCatEditor extends PropertyEditorSupport {

	private final BookTPCService btpcService;

	public BookTopicPidCatEditor(BookTPCService btpcService) {
		super();
		this.btpcService = btpcService;
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		BookTopicPidCat btpc = btpcService.findOne(Integer.valueOf(text));
		setValue(btpc);
	}
}
