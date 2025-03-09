package com.spring.hibernate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.model.Address;
import com.spring.hibernate.model.BlobExample;
import com.spring.hibernate.model.Customer;
import com.spring.hibernate.model.Employee;
import com.spring.hibernate.model.MyItems;

public class HibernateAppRun {

	public static void main(String[] args) {
		final Configuration configuration = new Configuration().configure();
		final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		final SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		MyItems items = new MyItems();
		items.setId(2);
		items.setItemName("Item-22");
		items.setPrice(200);
		//Transit state -> items
		session.saveOrUpdate(items);  // <- persistent 		
		//System.out.println(count);
		
		MyItems myItems = (MyItems) session.get(MyItems.class, 2);
		System.out.println(myItems);
		
		List<MyItems> list= session.createCriteria(MyItems.class).list();
		System.out.println(list);
		
		t.commit();
		
		//Detached state-> items
		session.close(); 
		factory.close();
	}

	/*
	One to One ->  C -> A
	One to Many -> C -> [A1, A2, A3]
	Many to One -> [C1, C2] -> A
	Many to Many -> [C1, C2] -> [(C1 :A1, A2) (C2 : A1, A3)]
	*/
}
  
		