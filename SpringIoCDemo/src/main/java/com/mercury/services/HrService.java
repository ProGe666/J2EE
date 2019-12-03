package com.mercury.services;

import com.mercury.daos.EmpDao;
import com.mercury.daos.OfficeDao;

public class HrService {

	private EmpDao ed;
	private OfficeDao od;
	
	public HrService() {
		System.out.println("Creating HrService: " + this);
	}
	
	public HrService(EmpDao ed, OfficeDao od) {
		System.out.println("Creating HrService: " + this + " with ed: " + ed + " and od:" + od);
		this.ed = ed;
		this.od = od;
	}
	
	public EmpDao getEd() {
		return ed;
	}
	public void setEd(EmpDao ed) {
		this.ed = ed;
	}
	public OfficeDao getOd() {
		return od;
	}
	public void setOd(OfficeDao od) {
		this.od = od;
	}
	
	@Override
	public String toString() {
		return "HrService [ed=" + ed + ", od=" + od + "]";
	}
}
