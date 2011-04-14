package edu.ucla.cens.awserver.jee.servlet.glue;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.NDC;

import edu.ucla.cens.awserver.request.AwRequest;
import edu.ucla.cens.awserver.request.RetrieveCampaignAwRequest;

/**
 * @author selsky
 */
public class RetrieveCampaignAwRequestCreator implements AwRequestCreator {

	public RetrieveCampaignAwRequestCreator() {
		
	}
	
	public AwRequest createFrom(HttpServletRequest request) {
		// required
		String client = request.getParameter("client");
		String userToken = request.getParameter("auth_token");
		String outputFormat = request.getParameter("output_format");
		
		// optional
		String campaignUrnListAsString = request.getParameter("campaign_urn_list");
		String startDate = request.getParameter("start_date");
		String endDate = request.getParameter("end_date");
		String privacyState = request.getParameter("privacy_state");
		String runningState = request.getParameter("running_state");
		String userRole = request.getParameter("user_role");
		String classListAsString = request.getParameter("class_list");
		 
		NDC.push("client=" + client); // push the client string into the Log4J NDC for the currently executing thread - this means that it
		                              // will be in every log message for the thread
		
		RetrieveCampaignAwRequest awRequest = new RetrieveCampaignAwRequest();
		awRequest.setClient(client);
		awRequest.setUserToken(userToken);
		awRequest.setOutputFormat(outputFormat);
		awRequest.setCampaignUrnListAsString(campaignUrnListAsString);
		awRequest.setStartDate(startDate);
		awRequest.setEndDate(endDate);
		awRequest.setPrivacyState(privacyState);
		awRequest.setRunningState(runningState);
		awRequest.setUserRole(userRole);
		awRequest.setClassUrnListAsString(classListAsString);
				
		return awRequest;
	}
}
