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
 * Home object for domain model class PreBhlHead.
 * @see gov.customs.rule.data.PreBhlHead
 * @author Hibernate Tools
 */
public class PreBhlHeadHome {

	private static final Log log = LogFactory.getLog(PreBhlHeadHome.class);

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

	public void persist(PreBhlHead transientInstance) {
		log.debug("persisting PreBhlHead instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PreBhlHead instance) {
		log.debug("attaching dirty PreBhlHead instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PreBhlHead instance) {
		log.debug("attaching clean PreBhlHead instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PreBhlHead persistentInstance) {
		log.debug("deleting PreBhlHead instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PreBhlHead merge(PreBhlHead detachedInstance) {
		log.debug("merging PreBhlHead instance");
		try {
			PreBhlHead result = (PreBhlHead) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PreBhlHead findById(java.lang.String id) {
		log.debug("getting PreBhlHead instance with id: " + id);
		try {
			PreBhlHead instance = (PreBhlHead) sessionFactory
					.getCurrentSession().get(
							"gov.customs.rule.data.PreBhlHead", id);
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

	public List<PreBhlHead> findByExample(PreBhlHead instance) {
		log.debug("finding PreBhlHead instance by example");
		try {
			List<PreBhlHead> results = (List<PreBhlHead>) sessionFactory
					.getCurrentSession()
					.createCriteria("gov.customs.rule.data.PreBhlHead")
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
