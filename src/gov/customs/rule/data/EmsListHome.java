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
 * Home object for domain model class EmsList.
 * @see gov.customs.rule.data.EmsList
 * @author Hibernate Tools
 */
public class EmsListHome {

	private static final Log log = LogFactory.getLog(EmsListHome.class);

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

	public void persist(EmsList transientInstance) {
		log.debug("persisting EmsList instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(EmsList instance) {
		log.debug("attaching dirty EmsList instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EmsList instance) {
		log.debug("attaching clean EmsList instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EmsList persistentInstance) {
		log.debug("deleting EmsList instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EmsList merge(EmsList detachedInstance) {
		log.debug("merging EmsList instance");
		try {
			EmsList result = (EmsList) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EmsList findById(gov.customs.rule.data.EmsListId id) {
		log.debug("getting EmsList instance with id: " + id);
		try {
			EmsList instance = (EmsList) sessionFactory.getCurrentSession()
					.get("gov.customs.rule.data.EmsList", id);
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

	public List<EmsList> findByExample(EmsList instance) {
		log.debug("finding EmsList instance by example");
		try {
			List<EmsList> results = (List<EmsList>) sessionFactory
					.getCurrentSession()
					.createCriteria("gov.customs.rule.data.EmsList")
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
