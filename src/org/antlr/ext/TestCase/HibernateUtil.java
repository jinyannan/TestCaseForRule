package org.antlr.ext.TestCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	  private static SessionFactory sessionFactory;
	  
	  private static Logger logger = LogManager.getLogger("TestLog.TestLog");
	  //private static final Logger logger = LogManager.getLogger("TestLog.TestLog");

	  private static SessionFactory buildSessionFactory() {
	    try {
	      // Create the SessionFactory from hibernate.cfg.xml
	      Configuration configuration = new Configuration();
	      configuration.configure("hibernate.cfg.xml");
	      logger.info("Hibernate Configuration loaded");
	      
	      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	      logger.info("Hibernate serviceRegistry created");
	      SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	      return sessionFactory;
	    }
	    catch (Throwable ex) {
	      logger.error("Initial SessionFactory creation failed." + ex);
	      ex.printStackTrace();
	      throw new ExceptionInInitializerError(ex);
	    }
	  }
	  
	  public static SessionFactory getSessionFactory() {
	    if(sessionFactory == null) sessionFactory = buildSessionFactory();
	    return sessionFactory;
	  }
}
