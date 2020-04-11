package greencard.admin.account.repository;

import javax.transaction.Transactional;

//import java.util.Iterator;
//import java.util.List;

import org.hibernate.Query;
//import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import greencard.admin.account.model.Applicant;
import greencard.admin.account.model.CustomerApplication;
import greencard.admin.account.model.CustomerContact;
import greencard.admin.account.model.CustomerPayment;
import greencard.admin.account.model.CustomerPhotograph;
import greencard.admin.account.model.CustomerRegistration;
import greencard.admin.account.model.SkipSubmission;
import greencard.admin.account.utils.DBSession;

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
		
//		Session session = null;
//		Transaction transaction;
//		
//		try {
//			
//			session = dbSession.getSession();
//			transaction = session.beginTransaction();
//			int userId = Integer.parseInt(accountId);
//			
//			Query query = session.getNamedQuery("findByAccountId");
//			query.setInteger("accountId", userId);
//			
//			List list = query.list();
//			Iterator iterator = list.iterator();
//			
//			while (iterator.hasNext()) {
//				customerRegistration = (CustomerRegistration) iterator.next();
//			}
//			transaction.commit();
//			
//		} catch (Exception e) {
//			e.getMessage();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		return customerRegistration;
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
		
//		System.out.println("DAO - Get Application called...");
//		
//		Session session = null;
//		Transaction transaction;
//		
//		try {
//			session = dbSession.getSession();
//			transaction = session.beginTransaction();
//			
//			int userId = Integer.parseInt(accountId);
//			
//			Query query = session.getNamedQuery("application_findByAccountId");
//			query.setInteger("accountId", userId);
//			
//			List list = query.list();
//			Iterator iterator = list.iterator();
//			
//			while (iterator.hasNext()) {
//				customerApplication = (CustomerApplication) iterator.next();	
//			}
//			
//			transaction.commit();
//			} catch (Exception e) {
//				System.out.println("Error while connecting Database...");
//				e.printStackTrace();
//			} finally {
//				if (session != null) {
//					session.close();
//				}
//			}
//		System.out.println(customerApplication.getApplicationTakenBy());
//		return customerApplication;
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
		
//		System.out.println("DAO for payment ...");
//		
//		Session session = null;
//		Transaction transaction;
//		
//		int userId = Integer.parseInt(accountId);
//		
//		try {
//			
//			session = dbSession.getSession();
//			transaction = session.beginTransaction();
//			
//			Query query = session.getNamedQuery("payment_findByAccountId");
//			query.setInteger("accountId", userId);
//			
//			List list = query.list();
//			Iterator iterator = list.iterator();
//			
//			while(iterator.hasNext()) {
//				customerPayment = (CustomerPayment) iterator.next();
//			}
//			
//			transaction.commit();
//			
//		} catch (Exception e) {
//			System.out.println("Error while connecting Database...");
//			e.printStackTrace();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		
//		
//		return customerPayment;
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
		
//		System.out.println("Database - Deleting...");
//		int status = 0;
//		
//		Session session = null;
//		Transaction transaction;
//		
//		try {
//			
//			session = dbSession.getSession();
//			transaction = session.beginTransaction();
//			int userId = Integer.parseInt(customerId);
//			
//			Query query = session.getNamedQuery("deleteByAccountId");
//			query.setString("emailId", emailId);
//			query.setInteger("accountId", userId);
//			
//			status = query.executeUpdate();
//			System.out.println("Status is = " + status);
//			
//			transaction.commit();
//			System.out.println("Status is 1 = " + status);
//			
//		} catch (Exception e) {
//			e.getMessage();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		return status;
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
		
//		System.out.println("Checking account skiped or not ...");
//		
//		skipSubmission = null;
//		Session session = null;
//		Transaction transaction;
//		
//		try {
//			session = dbSession.getSession();
//			transaction = session.beginTransaction();
//			
//			Query query = session.getNamedQuery("verifySkipByUserId");
//			query.setInteger("userId", userId);
//			
//			List list = query.list();
//			
//			Iterator iterator = list.iterator();
//			
//			while (iterator.hasNext()) {
//				System.out.println("===== > Already in skip list ..............");
//				skipSubmission = (SkipSubmission) iterator.next();
//			}
//			transaction.commit();
//		} catch (Exception e) {
//			System.out.println("Database error ...");
//			e.getMessage();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		
//		return skipSubmission;
	}
	
	@Override
	public int skipAccount(SkipSubmission skipSubmission) {
		
		return (int) sessionFactory.getCurrentSession().save(skipSubmission);
		
//		System.out.println("Database - Skiping...");
//		int skippedAccount = 0;
//		Session session = null;
//		Transaction transaction;
//		
//		try {
//			session = dbSession.getSession();
//			transaction = session.beginTransaction();
//			
//			skippedAccount = (int) session.save(skipSubmission);
//			transaction.commit();
//			
//		} catch (Exception e) {
//			e.getMessage();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		return skippedAccount;
	}
	
	@Override
	public void addToSubmission(SkipSubmission skipSubmission) {

		sessionFactory.getCurrentSession().delete(skipSubmission);
		
//		System.out.println("Deleting customer from SkipList ");
//		
//		Session session = null;
//		Transaction transaction;
//		
//		try {
//			
//			session = dbSession.getSession();
//			transaction = session.beginTransaction();
//			
//			session.delete(skipSubmission);
//			
//			transaction.commit();
//			
//		} catch (Exception e) {
//			System.out.println("Database error ...");
//			e.getMessage();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
	}
	
	@Override
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
		
		
//		Session session = null;
//		Transaction transaction;
//		int userId = 0;
//		
//		try {
//			System.out.println("Contact DAO Called ...");
//			
//			session = dbSession.getSession();
//			
//			transaction = session.beginTransaction();
//			
//			userId = Integer.parseInt(accountId);
//			System.out.println("UserId =" + userId);
//			
//			Query query = session.getNamedQuery("findByuserId");
//			query.setInteger("accountId", userId);
//			
//			List list = query.list();
//			
//			Iterator iterator = list.iterator();
//			
//			while (iterator.hasNext()) {
//				customerContact = (CustomerContact) iterator.next();
//			}
//			
//			transaction.commit();
//		} catch (Exception e) {
//			System.out.println("Error contact with database ...");
//			e.getMessage();
//			
//		} finally {
//			session.close();
//		}
//		return customerContact;
	}
	
	@Override
	public Applicant getApplicant(int applicationId) {
		
		Query query = sessionFactory.getCurrentSession()
		.createQuery("from Applicant where applicationId = :applicationId")
		.setInteger("applicationId", applicationId);
		
		if (query.list().size() > 0) {
			return (Applicant) query.list().get(0);
		} else {
			return null;
		}
		
//		Session session = null;
//		Transaction transaction;
//		
//		try {
//			System.out.println("Applicant DAO Called ...");
//			
//			session = dbSession.getSession();
//			
//			transaction = session.beginTransaction();
//			
//			Query query = session.getNamedQuery("findByApplicationId");
//			query.setInteger("applicationId", applicationId);
//			
//			List list = query.list();
//			
//			Iterator iterator = list.iterator();
//			
//			while (iterator.hasNext()) {
//				applicant = (Applicant) iterator.next();
//				
//			}
//			
//			transaction.commit();
//		} catch (Exception e) {
//			System.out.println("Error contact with database ...");
//			e.getMessage();
//			e.printStackTrace();
//			
//		} finally {
//			session.close();
//		}
//		return applicant;
	}
	
	@Override
	public CustomerPhotograph getPhotograph(int userId) {
		
		Query query = sessionFactory.getCurrentSession()
		.createQuery("from CustomerPhotograph where userId = :accountId")
		.setInteger("accountId", userId);
		
		if (query.list().size() > 0) {
			return (CustomerPhotograph) query.list().get(0);
		} else {
			return null;
		}
		
//		System.out.println("PhotoGraphs details ...");
//		
//		Session session = null;
//		Transaction transaction;
//		
//		try {
//			session = dbSession.getSession();
//			transaction = session.beginTransaction();
//			
//			Query query = session.getNamedQuery("Photo_findByAccountId");
//			query.setInteger("userId", userId);
//			
//			List list = query.list();
//			Iterator iterator = list.iterator();
//			
//			while (iterator.hasNext()) {
//				customerPhotograph = (CustomerPhotograph) iterator.next();
//			}
//			
//			transaction.commit();
//			
//		} catch (Exception e) {
//			System.out.println("Database error ...");
//			e.getMessage();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		
//		return customerPhotograph;
	}
	
	@Override
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
		
//		System.out.println("Edit Applicaiton Repository...");
//		
//		int updateStatus = 0;
//		int userId = Integer.parseInt(customerId);
//		
//		Session session = null;
//		Transaction transaction;
//		
//		try {
//			
//			session = dbSession.getSession();
//			transaction = session.beginTransaction();
//			
//			Query query = session.getNamedQuery("update_registration");
//			query.setString("emailId", customerEmail);
//			query.setString("name", customerName);
//			query.setString("password", customerPassword);
//			query.setString("phone", customerPhone);
//			query.setString("mobile", customerMobile);
//			query.setInteger("customerId", userId);
//			
//			updateStatus = query.executeUpdate();
//			
//			transaction.commit();
//			
//		} catch (Exception e) {
//			System.out.println("Database Error...");
//			e.getMessage();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		
//		return updateStatus;
	}

}
