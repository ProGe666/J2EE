package com.mercury.daos;

public class OfficeDao {
	private int x;
	private String y;
	
	public OfficeDao() {
		System.out.println("Creating OfficeDao..." + this);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
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
		return "OfficeDao [x=" + x + ", y=" + y + "]";
	}
}
