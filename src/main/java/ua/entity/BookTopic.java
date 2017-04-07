package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="topic")
public class BookTopic extends AbstractEntity{
	@Column(name="topic")
	private String topic;

	@OneToMany(mappedBy="topic")
	private List<BookTopicPidCat> btpc = new ArrayList<>();

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<BookTopicPidCat> getBtpc() {
		return btpc;
	}

	public void setBtpc(List<BookTopicPidCat> btpc) {
		this.btpc = btpc;
	}

	public BookTopic() {
		super();
	}

	@Override
	public String toString() {
		return topic;
	}
	
	
	
	
	

}
