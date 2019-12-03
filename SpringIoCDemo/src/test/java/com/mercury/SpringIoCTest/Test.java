package com.mercury.SpringIoCTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.mercury.daos.EmpDao;
import com.mercury.daos.FacilityDao;
import com.mercury.daos.OfficeDao;
import com.mercury.services.HrService;

public class Test {

	public static void main(String[] args) {
		System.out.println("*********");
		// create spring container from the config file
		ApplicationContext actx = new FileSystemXmlApplicationContext("/resources/spring-ioc-config.xml");
		
		System.out.println("***************");
		
		EmpDao ed = (EmpDao)actx.getBean("ed");
		EmpDao ed2 = (EmpDao)actx.getBean("ed2");
		
		System.out.println(ed == ed2);
		System.out.println(ed);
		System.out.println(ed2);
		
		System.out.println("************");
		OfficeDao od = (OfficeDao)actx.getBean("od");
		System.out.println(od);
		
		System.out.println("************");
		HrService hs = (HrService)actx.getBean("hs");
		System.out.println(hs);
		
		System.out.println("**********");
		FacilityDao fd = (FacilityDao)actx.getBean("fd");
		FacilityDao fd2 = (FacilityDao)actx.getBean("fd");
		System.out.println(fd);
		System.out.println(fd2);
		
	}

}
