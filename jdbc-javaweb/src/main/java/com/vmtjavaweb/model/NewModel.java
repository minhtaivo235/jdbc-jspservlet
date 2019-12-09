package com.vmtjavaweb.model;

public class NewModel extends AbstractModel<NewModel> {
	private String title;
	private String thumbnail;
	private Long categoryId;
	private String shortDescription;
	private String content;
	private String categoryCode;
	
	
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
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
}
