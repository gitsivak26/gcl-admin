package greencard.admin.account.repository;

import javax.transaction.Transactional;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import greencard.admin.account.model.Applicant;
import greencard.admin.account.model.CustomerApplication;
import greencard.admin.account.model.CustomerContact;
import greencard.admin.account.model.CustomerPayment;
import greencard.admin.account.model.CustomerPhotograph;
import greencard.admin.account.model.CustomerRegistration;
import greencard.admin.account.model.SkipSubmission;

@Repository
public class CustomerServiceDAOImpl implements CustomerServiceDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public CustomerRegistration getRegistration(String accountId) {
		
		int userId = Integer.parseInt(accountId);
		
		Query query = sessionFactory.getCurrentSession()
		.createQuery("from CustomerRegistration where userId = :accountId")
		.setInteger("accountId", userId);
		
		if (query.list().size() > 0) {
			return (CustomerRegistration) query.list().get(0);
		} else {
			return null;
		}
	}
	
	@Override
	@Transactional
	public CustomerApplication getApplication(String accountId) {
		
		int userId = Integer.parseInt(accountId);
		
		Query query = sessionFactory.getCurrentSession()
		.createQuery("from CustomerApplication where userId = :accountId")
		.setInteger("accountId", userId);
		
		if (query.list().size() > 0) {
			return (CustomerApplication) query.list().get(0);
		} else {
			return null;
		}
	}
	
	@Override
	@Transactional
	public CustomerPayment getPayment(String accountId) {
		
		int userId = Integer.parseInt(accountId);
		
		Query query = sessionFactory.getCurrentSession()
		.createQuery("from CustomerPayment where userId = :accountId")
		.setInteger("accountId", userId);
		
		if (query.list().size() > 0) {
			return (CustomerPayment) query.list().get(0);
		} else {
			return null;
		}
	}
	
	@Override
	@Transactional
	public int deleteByAccountId(String customerId, String emailId) {
		
		int userId = Integer.parseInt(customerId);
		
		Query query = sessionFactory.getCurrentSession()
		.createQuery("update CustomerRegistration set email = :emailId where userId = :accountId")
		.setString("emailId", emailId)
		.setInteger("accountId", userId);
		
		return query.executeUpdate();
	}
	
	@Override
	@Transactional
	public SkipSubmission verifySkipStatus(int userId) {
		
		Query query = sessionFactory.getCurrentSession()
		.createQuery("from SkipSubmission where userId = :accountId")
		.setInteger("accountId", userId);
		
		if (query.list().size() > 0) {
			return (SkipSubmission) query.list().get(0);
		} else {
			return null;
		}
	}
	
	@Override
	@Transactional
	public int skipAccount(SkipSubmission skipSubmission) { 
		return (int) sessionFactory.getCurrentSession().save(skipSubmission);
	}
	
	@Override
	@Transactional
	public void addToSubmission(SkipSubmission skipSubmission) {
		sessionFactory.getCurrentSession().delete(skipSubmission);
	}
	
	@Override
	@Transactional
	public CustomerContact getContact(String accountId) {
		
		int userId = Integer.parseInt(accountId);
		
		Query query = sessionFactory.getCurrentSession()
		.createQuery("from CustomerContact where userId = :accountId")
		.setInteger("accountId", userId);
		
		if (query.list().size() > 0) {
			return (CustomerContact) query.list().get(0);
		} else {
			return null;
		}
	}
	
	@Override
	@Transactional
	public Applicant getApplicant(int applicationId) {
		
		Query query = sessionFactory.getCurrentSession()
		.createQuery("from Applicant where applicationId = :applicationId")
		.setInteger("applicationId", applicationId);
		
		if (query.list().size() > 0) {
			return (Applicant) query.list().get(0);
		} else {
			return null;
		}
	}
	
	@Override
	@Transactional
	public CustomerPhotograph getPhotograph(int userId) {
		
		Query query = sessionFactory.getCurrentSession()
		.createQuery("from CustomerPhotograph where userId = :accountId")
		.setInteger("accountId", userId);
		
		if (query.list().size() > 0) {
			return (CustomerPhotograph) query.list().get(0);
		} else {
			return null;
		}
	}
	
	@Override
	@Transactional
	public int updateCustomerRegistration(String customerId, String customerEmail, String customerName,
			String customerPassword, String customerPhone, String customerMobile) {
		
		int userId = Integer.parseInt(customerId);
		
		Query query = sessionFactory.getCurrentSession()
		.createQuery("update CustomerRegistration set email = :emailId, firstName = :name, password = :password, telephone = :phone, mobile = :mobile where userId = :customerId")
		.setString("emailId", customerEmail)
		.setString("name", customerName)
		.setString("password", customerPassword)
		.setString("phone", customerPhone)
		.setString("mobile", customerMobile)
		.setInteger("customerId", userId);
		
		return query.executeUpdate();
	}
}
