package org.ohmage.query;

import org.ohmage.exception.DataAccessException;

public interface ICampaignSurveyResponseQueries {

	/**
	 * Retrieves the total number of survey responses for a campaign.
	 * 
	 * @param campaignId The unique identifier for the campaign.
	 * 
	 * @return The total number of survey responses for a campaign. If the
	 * 		   campaign doesn't exist, 0 is returned.
	 * 
	 * @throws DataAccessException Thrown if there is an error.
	 */
	long getNumberOfSurveyResponsesForCampaign(String campaignId)
			throws DataAccessException;

	/**
	 * Retrieves the total number of prompt responses for a campaign.
	 * 
	 * @param campaignId The unique identifier for the campaign.
	 * 
	 * @return The total number of prompt responses for a campaign. If the 
	 * 		   campaign doesn't exist, 0 is returned.
	 * 
	 * @throws DataAccessException Thrown if there is an error.
	 */
	long getNumberOfPromptResposnesForCampaign(String campaignId)
			throws DataAccessException;

	/**
	 * Retrieves the campaign ID for the campaign to which a survey belongs 
	 * given a survey response.
	 * 
	 * @param surveyResponseId The survey response's unique identifier.
	 * 
	 * @return The campaign's unique identifier or null if the survey response
	 *		   doesn't exist.
	 *
	 * @throws DataAccessException Thrown if there is an error.
	 */
	String getCampaignIdFromSurveyId(Long surveyResponseId)
			throws DataAccessException;

}