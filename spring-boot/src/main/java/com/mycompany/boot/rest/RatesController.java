/**
 * 
 */
package com.mycompany.boot.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NishantS
 *
 */

@RestController
@EnableAutoConfiguration
public class RatesController extends BaseService {

	static Logger logger = LoggerFactory.getLogger(RatesController.class);

	@RequestMapping(path = "/", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public String getRate() {
		logger.info("Inside GET METHOD");
		return "{}";
	}

	@RequestMapping(path = "/", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public String postRate() {
		logger.info("Inside POST METHOD");
		return "{}";
	}

	@RequestMapping(path = "/", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	@ResponseBody
	public String putRate() {
		logger.info("Inside PUT METHOD");
		return "{}";
	}

}
