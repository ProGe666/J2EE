package com.mercury.daos;

public class OfficeDao {

	private int x;
	private String y;
	public void OfficeDao(){
		System.out.println("Creating EmpDao..." + this);
	}
	public OfficeDao(int x, String y) {
		super();
		this.x = x;
		this.y = y;
	}
	public OfficeDao() {
		super();
		// TODO Auto-generated constructor stub
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
