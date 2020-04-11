package greencard.admin.account.repository;

import org.hibernate.Criteria;
//import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import greencard.admin.account.model.Agent;

@Repository
public class AgentDAOImpl implements AgentDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
//	public AgentDAOImpl(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	
	@Override
	@Transactional
	public void saveAgent(Agent user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
	@Override
	@Transactional
	public Agent findByUserID(int agclid) {
		System.out.println("********** Find By UserId in DAO ***********");
		
		return (Agent) sessionFactory.getCurrentSession().get(Agent.class, agclid);
	}
	
	@Override
	@Transactional
	public Agent findByEmailID(String email) {
		
		System.out.println("DB .................... " + email);
		
		// Way 1
//		Query query = sessionFactory.getCurrentSession().createQuery("from Admin where email = :email");
//		query.setString("email", email);
		
//		if (query.list().size() > 0) {
//			return (Agent) query.list().get(0);
//		} else {
//			return null;
//		}
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Agent.class);
		criteria.add(Restrictions.eq("email", email));
		
		if (criteria.list().size() > 0) {
			return (Agent) criteria.list().get(0);
		} else {
			return null;
		}
	}
}
