package com.sds;

public class Geo{
	private String name;
	private String x;
	private String y;
	
	public Geo() {
		super();
	}

	public Geo(String name, String x, String y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Geo [name=" + name + ", x=" + x + ", y=" + y + "]";
	}
	
	
}
