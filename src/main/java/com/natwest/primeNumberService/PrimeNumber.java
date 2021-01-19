package com.natwest.primeNumberService;

import java.util.List;



public class PrimeNumber {

	private final Long initial;
	private final List primes;
	
	public PrimeNumber(Long initial, List primes) {
		this.initial = initial;
		this.primes = primes;
	}
	public Long getInitial() {
		return initial;
	}
	public List getPrimes() {
		return primes;
	}
	
	
}
