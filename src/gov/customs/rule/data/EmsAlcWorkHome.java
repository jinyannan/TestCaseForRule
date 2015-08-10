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
 * Home object for domain model class EmsAlcWork.
 * @see gov.customs.rule.data.EmsAlcWork
 * @author Hibernate Tools
 */
public class EmsAlcWorkHome {

	private static final Log log = LogFactory.getLog(EmsAlcWorkHome.class);

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

	public void persist(EmsAlcWork transientInstance) {
		log.debug("persisting EmsAlcWork instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(EmsAlcWork instance) {
		log.debug("attaching dirty EmsAlcWork instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EmsAlcWork instance) {
		log.debug("attaching clean EmsAlcWork instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EmsAlcWork persistentInstance) {
		log.debug("deleting EmsAlcWork instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EmsAlcWork merge(EmsAlcWork detachedInstance) {
		log.debug("merging EmsAlcWork instance");
		try {
			EmsAlcWork result = (EmsAlcWork) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EmsAlcWork findById(gov.customs.rule.data.EmsAlcWorkId id) {
		log.debug("getting EmsAlcWork instance with id: " + id);
		try {
			EmsAlcWork instance = (EmsAlcWork) sessionFactory
					.getCurrentSession().get(
							"gov.customs.rule.data.EmsAlcWork", id);
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

	public List<EmsAlcWork> findByExample(EmsAlcWork instance) {
		log.debug("finding EmsAlcWork instance by example");
		try {
			List<EmsAlcWork> results = (List<EmsAlcWork>) sessionFactory
					.getCurrentSession()
					.createCriteria("gov.customs.rule.data.EmsAlcWork")
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
