package org.antlr.ext.TestCase;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.xml.DOMConfigurator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.w3c.dom.DOMConfiguration;
//import com.journaldev.hibernate.model.Employee;
import org.antlr.ext.TestCase.HibernateUtil;



public class HibernateLog4jExample {
	private static Logger logger = LogManager.getLogger("TestLog.TestLog");
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    //Session session = sessionFactory.getCurrentSession();
	    
	    //Get All Employees
	    //Transaction tx = session.beginTransaction();
	    //Query query = session.createQuery("from Employee");
//	    List<Employee> empList = query.list();
//	    for(Employee emp : empList){
//	      logger.info("List of Employees::"+emp.getId()+","+emp.getAddress().getCity());
//	    }
	    
	    //tx.commit();
	    sessionFactory.close();
	    logger.debug("DONE");
	}
}
