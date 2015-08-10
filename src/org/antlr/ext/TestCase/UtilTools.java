package org.antlr.ext.TestCase;

import gov.customs.rule.data.BhlHead;
import gov.customs.rule.data.BhlList;
import gov.customs.rule.data.EmsAlcWork;
import gov.customs.rule.data.EmsHead;
import gov.customs.rule.data.EmsList;
import gov.customs.rule.data.PreBhlHead;
import gov.customs.rule.data.PreBhlList;

import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

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
		hmdata.put("bhlListCol", (Object)list4);
		
		String sql5 = "select * from EMS_HEAD where EMS_NO = 'H80122070001'";
		Query query5 = getSessionFactory().createSQLQuery(sql5).addEntity(EmsHead.class);
		List<EmsHead> list5 = query5.list();
		hmdata.put("bhlImEmsHead", (Object)list5.get(0));
		
		String sql6 = "select * from EMS_ALC_WORK where EMS_NO = 'S80121400006'";
		Query query6 = getSessionFactory().createSQLQuery(sql6).addEntity(EmsAlcWork.class);
		List<EmsAlcWork> list6 = query6.list();
		hmdata.put("emsAlcWork", (Object)list6.get(0));
		
		String sql7 = "select * from EMS_HEAD where EMS_NO = 'H80122070001'";
		Query query7 = getSessionFactory().createSQLQuery(sql7).addEntity(EmsHead.class);
		List<EmsHead> list7 = query7.list();
		hmdata.put("bhlExEmsHead", (Object)list7.get(0));
		
		String sql8 = "select * from EMS_LIST where EMS_NO = 'H80122070001' and G_TYPE = 'I'";
		Query query8 = getSessionFactory().createSQLQuery(sql8).addEntity(EmsList.class);
		List<EmsList> list8 = query8.list();
		hmdata.put("bhlImEmsListCol", (Object)list8);
		
		String sql9 = "select * from PRE_BHL_LIST where BHL_NO = 'S80121400006' and G_TYPE = 'I'";
		Query query9 = getSessionFactory().createSQLQuery(sql9).addEntity(PreBhlList.class);
		List<PreBhlList> list9 = query9.list();
		hmdata.put("preBhlListIm", (Object)list9.get(0));
		
		String sql10 = "select * from PRE_BHL_LIST where BHL_NO = 'S80121400006' and G_TYPE = 'I'";
		Query query10 = getSessionFactory().createSQLQuery(sql10).addEntity(PreBhlList.class);
		List<PreBhlList> list10 = query10.list();
		hmdata.put("preBhlListImCol", (Object)list10);
		
		String sql11 = "select * from EMS_LIST where EMS_NO = 'H80122070001' and G_TYPE = 'E'";
		Query query11 = getSessionFactory().createSQLQuery(sql11).addEntity(EmsList.class);
		List<EmsList> list11 = query11.list();
		hmdata.put("bhlExEmsListCol", (Object)list11);
		
		String sql12 = "select * from PRE_BHL_LIST where BHL_NO = 'S80121400006' and G_TYPE = 'E'";
		Query query12 = getSessionFactory().createSQLQuery(sql12).addEntity(PreBhlList.class);
		List<PreBhlList> list12 = query12.list();
		hmdata.put("preBhlListEx", (Object)list12.get(0));
		
		String sql13 = "select * from BHL_LIST where BHL_NO = 'S80121400006'  and G_TYPE = 'I'";
		Query query13 = getSessionFactory().createSQLQuery(sql13).addEntity(BhlList.class);
		List<BhlList> list13 = query13.list();
		hmdata.put("bhlListImCol", (Object)list13);
		
		String sql14 = "select * from BHL_LIST where BHL_NO = 'S80121400006'  and G_TYPE = 'E'";
		Query query14 = getSessionFactory().createSQLQuery(sql14).addEntity(BhlList.class);
		List<BhlList> list14 = query14.list();
		hmdata.put("bhlListExCol", (Object)list14);
		
		
		
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
	
	public static Session buildSession(){
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		return factory.openSession();
	}
}
