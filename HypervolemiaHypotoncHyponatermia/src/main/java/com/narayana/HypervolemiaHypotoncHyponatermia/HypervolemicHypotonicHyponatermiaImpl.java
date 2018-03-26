package com.narayana.HypervolemiaHypotoncHyponatermia;

import java.util.Arrays;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Repository
public class HypervolemicHypotonicHyponatermiaImpl implements HypervolemicHypotonicHyponatermiaRepository {

	public static final String HYPOTONIC_HYPONATERMIA_SERVICE_URL = "http://HYPOTONICHYPONATERMIA";
	public static final String HYPOVOLEMIA_SERVICE_URL = "http://HYPOVOLEMIA";
	protected RestTemplate restTemplate;

	

	@Override
	public String gethypervolemichypotonicHyponatermia(String serumSodium, String serumOsmol,
			String hypervolemicSystems) {
		String hyponatermia = restTemplate.getForObject(HYPOTONIC_HYPONATERMIA_SERVICE_URL+"/HypotonicHyponatermia/{serumSodium}/{SerumOsmol}",String.class);
		if(hyponatermia.equalsIgnoreCase("hypotonichyponatermia")) {
			String hypertonicity = restTemplate.getForObject(HYPOVOLEMIA_SERVICE_URL+"/hypovolemia/{hypovolemicSymptoms}",String.class);
			if(hypertonicity.equalsIgnoreCase("hypovolemia")) {
				return "HypervolemicHypotropiccHyponatremia";
			}
			else {
				return "notHypervolemicHypotropiccHyponatremia";
			}
		}
		else {
			return "notHypervolemicHypotropiccHyponatremia";
		}
	}

	

}
