package com.vmtjavaweb.model;

public class NewModel extends AbstractModel<NewModel> {
	private String title;
	private String thumbnail;
	private Long categoryId;
	private String shortDesciption;
	private String content;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryid) {
		this.categoryId = categoryid;
	}
	public String getShortDesciption() {
		return shortDesciption;
	}
	public void setShortDesciption(String shortDesciption) {
		this.shortDesciption = shortDesciption;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
