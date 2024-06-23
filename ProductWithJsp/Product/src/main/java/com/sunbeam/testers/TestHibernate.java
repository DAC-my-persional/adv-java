package com.sunbeam.testers;


import org.hibernate.SessionFactory;

import com.sunbeam.utils.HibernateUtil;

public class TestHibernate {
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		System.out.println("Hibenrate running !!");
	}

}
