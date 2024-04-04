package com.Akash.HibernateInheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DaoClass {
	public static void main(String[] args) {
		
		StandardServiceRegistry ssr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		   SessionFactory  factory=meta.getSessionFactoryBuilder().build();
		       Session  session =factory.openSession();
		       Transaction t=session.beginTransaction();
		       
		       Employee e1=new Employee();
		       e1.setName("Akash");
		       RegularEmployee reg= new RegularEmployee();
		       reg.setName("Raihan");
		       reg.setSalary(50000.0f);
		       reg.setBonus(10000);
		       reg.setDept("HR");
		       
		       ContractEmp cmp=new ContractEmp();
		       
		       cmp.setName("Avinash");
		       cmp.setPayPerHour(1500.0f);
		       cmp.setDept("Accounting");
		       cmp.setContractDuration("10 Days");
		       
		       session.persist(e1);
		       session.persist(reg);
		       session.persist(cmp);
		       
		       t.commit();
		       session.close();
		       factory.close();
		       System.out.println("Success");
		
	}

}
