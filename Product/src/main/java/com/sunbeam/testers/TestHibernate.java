package com.sunbeam.testers;

import org.hibernate.SessionFactory;

import com.sunbeam.utils.HibernateUtil;

public class TestHibernate {

	public static void main(String[] args) {
		
		try
		{
			
			SessionFactory session = HibernateUtil.getSessionFactory();
			
			System.out.println("Hibernate up and running !!");
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
