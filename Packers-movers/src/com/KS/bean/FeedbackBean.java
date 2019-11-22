package com.KS.bean;

public class FeedbackBean {
	private String feedId,name,description;
	
	public FeedbackBean()
	{}
	
	public FeedbackBean(String feedId,String name,String description)
	{
		this.feedId=feedId;
		this.name=name;
		this.description=description;
	}
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFeedId() {
		return feedId;
	}

	public void setFeedId(String feedId) {
		this.feedId = feedId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return feedId+" "+name+" "+description;	
	}
}