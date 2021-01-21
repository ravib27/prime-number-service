package com.natwest.primeNumberService;

import java.util.List;

public interface PrimeNumberService {

	public List<Integer> sieveOfEratosthenes(int n);
	
	public List<Integer> primeNumbersBruteForce(int n);
	
	public List<Integer> primeNumbersBasicAlgo(int n, String javaVer);
	
	public List<Integer> primeNumbersBigInteger(int n);
}
