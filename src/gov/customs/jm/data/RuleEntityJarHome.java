package gov.customs.jm.data;

// Generated Jul 8, 2015 9:23:16 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class RuleEntityJar.
 * @see gov.customs.jm.data.RuleEntityJar
 * @author Hibernate Tools
 */
public class RuleEntityJarHome {

	private static final Log log = LogFactory.getLog(RuleEntityJarHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(RuleEntityJar transientInstance) {
		log.debug("persisting RuleEntityJar instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RuleEntityJar instance) {
		log.debug("attaching dirty RuleEntityJar instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RuleEntityJar instance) {
		log.debug("attaching clean RuleEntityJar instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RuleEntityJar persistentInstance) {
		log.debug("deleting RuleEntityJar instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RuleEntityJar merge(RuleEntityJar detachedInstance) {
		log.debug("merging RuleEntityJar instance");
		try {
			RuleEntityJar result = (RuleEntityJar) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RuleEntityJar findById(long id) {
		log.debug("getting RuleEntityJar instance with id: " + id);
		try {
			RuleEntityJar instance = (RuleEntityJar) sessionFactory
					.getCurrentSession().get(
							"gov.customs.jm.data.RuleEntityJar", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<RuleEntityJar> findByExample(RuleEntityJar instance) {
		log.debug("finding RuleEntityJar instance by example");
		try {
			List<RuleEntityJar> results = (List<RuleEntityJar>) sessionFactory
					.getCurrentSession()
					.createCriteria("gov.customs.jm.data.RuleEntityJar")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
