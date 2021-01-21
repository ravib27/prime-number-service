package com.natwest.primeNumberService;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeNumberController {

	@Autowired
    private PrimeNumberService primeNumberService;
	
	@GetMapping("/primes/{initial}/{algorithm}/{javaVer}")
	public PrimeNumber fetchPrimeNumbers(@PathVariable Integer initial, @PathVariable String algorithm, @PathVariable String javaVer) {
		
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
		System.out.println("Total Prime Numbers from 1 to " + initial + " using " + algorithm + " are : " + primeNumbers.size() + ". Fetching Time : " + fetchingTime.substring(2, fetchingTime.length()-1) + " seconds.");
	    		
		return new PrimeNumber(initial, primeNumbers);
	}
	
	
}
