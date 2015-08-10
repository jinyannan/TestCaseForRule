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
 * Home object for domain model class PreBhlList.
 * @see gov.customs.rule.data.PreBhlList
 * @author Hibernate Tools
 */
public class PreBhlListHome {

	private static final Log log = LogFactory.getLog(PreBhlListHome.class);

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

	public void persist(PreBhlList transientInstance) {
		log.debug("persisting PreBhlList instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PreBhlList instance) {
		log.debug("attaching dirty PreBhlList instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PreBhlList instance) {
		log.debug("attaching clean PreBhlList instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PreBhlList persistentInstance) {
		log.debug("deleting PreBhlList instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PreBhlList merge(PreBhlList detachedInstance) {
		log.debug("merging PreBhlList instance");
		try {
			PreBhlList result = (PreBhlList) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PreBhlList findById(gov.customs.rule.data.PreBhlListId id) {
		log.debug("getting PreBhlList instance with id: " + id);
		try {
			PreBhlList instance = (PreBhlList) sessionFactory
					.getCurrentSession().get(
							"gov.customs.rule.data.PreBhlList", id);
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

	public List<PreBhlList> findByExample(PreBhlList instance) {
		log.debug("finding PreBhlList instance by example");
		try {
			List<PreBhlList> results = (List<PreBhlList>) sessionFactory
					.getCurrentSession()
					.createCriteria("gov.customs.rule.data.PreBhlList")
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
