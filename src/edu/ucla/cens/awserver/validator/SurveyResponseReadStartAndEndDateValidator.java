package edu.ucla.cens.awserver.validator;

import org.apache.log4j.Logger;

import edu.ucla.cens.awserver.request.AwRequest;

/**
 * Validator that checks that both start date and end date exist. (If one exists, they both must).
 * 
 * @author selsky
 */
public class SurveyResponseReadStartAndEndDateValidator extends AbstractAnnotatingValidator {
	private static Logger _logger = Logger.getLogger(SurveyResponseReadStartAndEndDateValidator.class);
	
	public SurveyResponseReadStartAndEndDateValidator(AwRequestAnnotator awRequestAnnotator) {
		super(awRequestAnnotator);
	}
	
	/**
	 * 
	 */
	public boolean validate(AwRequest awRequest) {
		_logger.info("Validating that the start and end date both exist or both don't exist");
		
		String startDate = awRequest.getStartDate();
		String endDate = awRequest.getEndDate();
		
		return (null != startDate && null != endDate) || (null == startDate && null == endDate);
	}
}
