package filter;

import java.util.ArrayList;
import java.util.List;

public class BookTPCFilter {
	private String search= "";
	private List<Integer> topicIds= new ArrayList<>();
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public List<Integer> getTopicIds() {
		return topicIds;
	}
	public void setTopicIds(List<Integer> topicIds) {
		this.topicIds = topicIds;
	}
	

}
