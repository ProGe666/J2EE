package com.mercury.daos;

public class EmpDao {
	
	private int x;
	private int y;

	public EmpDao() {
		System.out.println("Creating EmpDao..." + this);
	}
	
//	public EmpDao(int x) {
//		System.out.println("Creating EmpDao: " + x + " ... " + this);
//		this.x = x;
//	}
	
	public EmpDao(int x, int y) {
		System.out.println("Creating EmpDao: x:" + x + " y:" + y + " ... " + this);
		this.x = x;
		this.y = y;
	}
	
	public EmpDao(String x, String y) {
		System.out.println("Creating EmpDao(String): x:" + x + " y:" + y + " ... " + this);
	}
}
