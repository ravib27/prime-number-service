package com.natwest.primeNumberService.controller;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.primeNumberService.PrimeNumber;
import com.natwest.primeNumberService.service.PrimeNumberService;

@RestController
public class PrimeNumberController {

	@Autowired
    private PrimeNumberService primeNumberService;
	
	@GetMapping(value = "/primes/{initial}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PrimeNumber fetchPrimeNumbers(@PathVariable Integer initial, 
			@RequestParam(defaultValue="sieveOfEratosthenes") String algorithm, 
			@RequestParam(defaultValue="java7") String javaVer) {
		
		Logger logger = LoggerFactory.getLogger(PrimeNumberController.class);
		
		Instant start = Instant.now();
		
		List primeNumbers = new ArrayList();
		
		if(algorithm != null && algorithm.equals("basicPrimeAlgo")) {
			primeNumbers = primeNumberService.primeNumbersBasicAlgo(initial, javaVer);
		}
		else if(algorithm != null && algorithm.equals("sieveOfEratosthenes")) {
			primeNumbers = primeNumberService.sieveOfEratosthenes(initial);
		}
		else if(algorithm != null && algorithm.equals("primeNumbersBruteForce")) {
			primeNumbers = primeNumberService.primeNumbersBruteForce(initial);
		}
		else if(algorithm != null && algorithm.equals("usingBigInteger")) {
			primeNumbers = primeNumberService.primeNumbersBigInteger(initial);
		}
		
		Instant end = Instant.now();
		
		String fetchingTime = Duration.between(start, end).toString();
		logger.info("Total Prime Numbers from 1 to " + initial + " using " + algorithm + " are : " + primeNumbers.size() + ". Fetching Time : " + fetchingTime.substring(2, fetchingTime.length()-1) + " seconds.");
	    		
		return new PrimeNumber(initial, primeNumbers);
	}
	
	
}
