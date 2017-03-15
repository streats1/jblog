package com.bit2017.jblog.vo;

public class CategoryVo {

	private Long no;
	private String name;
	private String content;
	private String regDate;
	private String blogId;
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", content=" + content + ", regDate=" + regDate + ", blogId="
				+ blogId + "]";
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	
	
}
