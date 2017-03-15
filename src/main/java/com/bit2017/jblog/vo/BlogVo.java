package com.bit2017.jblog.vo;

public class BlogVo {

	private String blogId;
	private String title;
	private String logo;
	/*private String saveFileName;
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}*/
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "BlogVo [blogId=" + blogId + ", title=" + title + ", logo=" + logo + /*", saveFileName=" +*/ /*saveFileName*/
				 "]";
	}
}
