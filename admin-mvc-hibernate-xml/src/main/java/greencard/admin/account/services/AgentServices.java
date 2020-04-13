package greencard.admin.account.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import greencard.admin.account.model.Agent;

public interface AgentServices {
	
	boolean signedIn(HttpServletRequest request, HttpServletResponse response, HttpSession sessoin);

	boolean isRegisteredUser(String email);
	
	//boolean authenticate(String emailId, String password);
	boolean authenticate(Agent agent);
	
	void saveDetails(Agent user);
	
	Agent getUserDetails(String emailId);
	
	void clearSession(HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session);

}
