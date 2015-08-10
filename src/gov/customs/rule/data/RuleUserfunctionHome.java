package gov.customs.rule.data;

// Generated Aug 6, 2015 1:59:26 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class RuleUserfunction.
 * @see gov.customs.rule.data.RuleUserfunction
 * @author Hibernate Tools
 */
public class RuleUserfunctionHome {

	private static final Log log = LogFactory
			.getLog(RuleUserfunctionHome.class);

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

	public void persist(RuleUserfunction transientInstance) {
		log.debug("persisting RuleUserfunction instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RuleUserfunction instance) {
		log.debug("attaching dirty RuleUserfunction instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RuleUserfunction instance) {
		log.debug("attaching clean RuleUserfunction instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RuleUserfunction persistentInstance) {
		log.debug("deleting RuleUserfunction instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RuleUserfunction merge(RuleUserfunction detachedInstance) {
		log.debug("merging RuleUserfunction instance");
		try {
			RuleUserfunction result = (RuleUserfunction) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RuleUserfunction findById(java.math.BigDecimal id) {
		log.debug("getting RuleUserfunction instance with id: " + id);
		try {
			RuleUserfunction instance = (RuleUserfunction) sessionFactory
					.getCurrentSession().get(
							"gov.customs.rule.data.RuleUserfunction", id);
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

	public List<RuleUserfunction> findByExample(RuleUserfunction instance) {
		log.debug("finding RuleUserfunction instance by example");
		try {
			List<RuleUserfunction> results = (List<RuleUserfunction>) sessionFactory
					.getCurrentSession()
					.createCriteria("gov.customs.rule.data.RuleUserfunction")
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
