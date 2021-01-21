package com.natwest.primeNumberService;

import java.util.List;


public class PrimeNumber {

	private final Integer initial;
	private final List primes;
	
	public PrimeNumber(Integer initial, List primes) {
		this.initial = initial;
		this.primes = primes;
	}
	public Integer getInitial() {
		return initial;
	}
	public List getPrimes() {
		return primes;
	}
	
	
}
