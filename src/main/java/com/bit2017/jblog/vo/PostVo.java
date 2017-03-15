package com.bit2017.jblog.vo;

public class PostVo 
{
private int postNo;
private String title;
private String content;
private String regDate;
private int no;
@Override
public String toString() {
	return "PostVo [postNo=" + postNo + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", no="
			+ no + "]";
}
public int getPostNo() {
	return postNo;
}
public void setPostNo(int postNo) {
	this.postNo = postNo;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
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
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}

}
