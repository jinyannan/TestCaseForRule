package org.antlr.ext.TestCase;

import gov.customs.jm.data.BhlHead;
import gov.customs.jm.data.BhlList;
import gov.customs.jm.data.PreBhlHead;
import gov.customs.jm.data.PreBhlList;

import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilTools {
	public static Object propareTestData() {
		HashMap<String, Object> hmdata = new HashMap<String, Object>();
		
		String sql1 = "select * from PRE_BHL_HEAD where BHL_NO = 'S80121400006'";
		Query query1 = getSessionFactory().createSQLQuery(sql1).addEntity(PreBhlHead.class);
		List<PreBhlHead> list1 = query1.list();
		hmdata.put("preBhlHead", (Object)list1.get(0));

		String sql2 = "select * from PRE_BHL_LIST where BHL_NO = 'S80121400006'";
		Query query2 = getSessionFactory().createSQLQuery(sql2).addEntity(PreBhlList.class);
		List<PreBhlList> list2 = query2.list();
		hmdata.put("preBhlListCol", (Object)list2);
		
		String sql3 = "select * from BHL_HEAD where BHL_NO = 'S80121400006'";
		Query query3 = getSessionFactory().createSQLQuery(sql3).addEntity(BhlHead.class);
		List<BhlHead> list3 = query3.list();
		hmdata.put("bhlHead", (Object)list3.get(0));
		
		String sql4 = "select * from BHL_LIST where BHL_NO = 'S80121400006'";
		Query query4 = getSessionFactory().createSQLQuery(sql4).addEntity(BhlList.class);
		List<BhlList> list4 = query4.list();
		hmdata.put("bhlList", (Object)list4);

		return (Object) hmdata;
	}
	
	public static Session getSessionFactory() {
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return sessionFactory.openSession();
	}
}
