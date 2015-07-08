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
 * Home object for domain model class BhlList.
 * @see gov.customs.jm.data.BhlList
 * @author Hibernate Tools
 */
public class BhlListHome {

	private static final Log log = LogFactory.getLog(BhlListHome.class);

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

	public void persist(BhlList transientInstance) {
		log.debug("persisting BhlList instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(BhlList instance) {
		log.debug("attaching dirty BhlList instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BhlList instance) {
		log.debug("attaching clean BhlList instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(BhlList persistentInstance) {
		log.debug("deleting BhlList instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BhlList merge(BhlList detachedInstance) {
		log.debug("merging BhlList instance");
		try {
			BhlList result = (BhlList) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BhlList findById(gov.customs.jm.data.BhlListId id) {
		log.debug("getting BhlList instance with id: " + id);
		try {
			BhlList instance = (BhlList) sessionFactory.getCurrentSession()
					.get("gov.customs.jm.data.BhlList", id);
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

	public List<BhlList> findByExample(BhlList instance) {
		log.debug("finding BhlList instance by example");
		try {
			List<BhlList> results = (List<BhlList>) sessionFactory
					.getCurrentSession()
					.createCriteria("gov.customs.jm.data.BhlList")
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
