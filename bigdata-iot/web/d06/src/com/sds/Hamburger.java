package com.sds;

public class Hamburger{
	private String id;
	private String cnt;
	private String name;
	public Hamburger() {
	}
	public Hamburger(String id, String cnt, String name) {
		this.id = id;
		this.cnt = cnt;
		this.name = name;
	}
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", cnt=" + cnt + ", name=" + name + "]";
	}
	
}
