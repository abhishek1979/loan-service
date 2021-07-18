/**
 * 
 */
package com.eazybytes.loans.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.loans.config.LoansServiceConfig;
import com.eazybytes.loans.model.Loans;
import com.eazybytes.loans.repository.LoansRepository;

/**
 * @author Eazy Bytes
 *
 */

@RestController
public class LoansController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoansController.class);

	@Autowired
	private LoansRepository loansRepository;

	@Autowired
	LoansServiceConfig loansConfig;

	@GetMapping("/myLoans/{customerId}")
	public List<Loans> getLoansDetails(@PathVariable Integer customerId) {
		logger.info("getLoansDetails() method started");
		List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customerId);
		logger.info("getLoansDetails() method ended");
		if (loans != null) {
			return loans;
		} else {
			return null;
		}

	}
/**
	@GetMapping("/loans/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(loansConfig.getMsg(), loansConfig.getBuildVersion(),
				loansConfig.getMailDetails(), loansConfig.getActiveBranches());
		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
	}
*/
}
