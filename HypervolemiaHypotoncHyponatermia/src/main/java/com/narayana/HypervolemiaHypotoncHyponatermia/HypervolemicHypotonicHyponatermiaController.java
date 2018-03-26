package com.narayana.HypervolemiaHypotoncHyponatermia;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HypervolemicHypotonicHyponatermiaController {
	
	protected Logger logger = Logger
			.getLogger(HypervolemicHypotonicHyponatermiaController.class.getName());
	
	@Autowired
	HypervolemicHypotonicHyponatermiaRepository hypervolemicHypotonicHyponatermiaRepository;
	
	@RequestMapping("/HypervolemicHypotonicHyponatermia/{SerumSodium}/{SerumOsmol}/{hypervolemicSystems}")
	public String HypotonicHyponatermia(@PathVariable("SerumSodium") String SerumSodium,@PathVariable("SerumOsmol") String SerumOsmol,@PathVariable("hypervolemicSystems") String hypervolemicSystems) {
		logger.info("accounts-changed byId() invoked: " + SerumOsmol);
		String retVal = hypervolemicHypotonicHyponatermiaRepository.gethypervolemichypotonicHyponatermia(SerumSodium,SerumOsmol,hypervolemicSystems);
		logger.info("accounts-microservice byId() found: " + retVal);
		return retVal;
	}

}
