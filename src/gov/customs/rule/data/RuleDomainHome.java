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
 * Home object for domain model class RuleDomain.
 * @see gov.customs.rule.data.RuleDomain
 * @author Hibernate Tools
 */
public class RuleDomainHome {

	private static final Log log = LogFactory.getLog(RuleDomainHome.class);

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

	public void persist(RuleDomain transientInstance) {
		log.debug("persisting RuleDomain instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RuleDomain instance) {
		log.debug("attaching dirty RuleDomain instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RuleDomain instance) {
		log.debug("attaching clean RuleDomain instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RuleDomain persistentInstance) {
		log.debug("deleting RuleDomain instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RuleDomain merge(RuleDomain detachedInstance) {
		log.debug("merging RuleDomain instance");
		try {
			RuleDomain result = (RuleDomain) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RuleDomain findById(long id) {
		log.debug("getting RuleDomain instance with id: " + id);
		try {
			RuleDomain instance = (RuleDomain) sessionFactory
					.getCurrentSession().get(
							"gov.customs.rule.data.RuleDomain", id);
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

	public List<RuleDomain> findByExample(RuleDomain instance) {
		log.debug("finding RuleDomain instance by example");
		try {
			List<RuleDomain> results = (List<RuleDomain>) sessionFactory
					.getCurrentSession()
					.createCriteria("gov.customs.rule.data.RuleDomain")
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
