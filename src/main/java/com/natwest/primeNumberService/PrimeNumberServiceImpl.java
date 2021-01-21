package com.natwest.primeNumberService;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {

	public List<Integer> sieveOfEratosthenes(int n) {
	    boolean prime[] = new boolean[n + 1];
	    Arrays.fill(prime, true);
	    for (int p = 2; p * p <= n; p++) {
	        if (prime[p]) {
	            for (int i = p * 2; i <= n; i += p) {
	                prime[i] = false;
	            }
	        }
	    }
	    List<Integer> primeNumbers = new LinkedList<>();
	    for (int i = 2; i <= n; i++) {
	        if (prime[i]) {
	            primeNumbers.add(i);
	        }
	    }
	    return primeNumbers;
	}
	
	
	public List<Integer> primeNumbersBruteForce(int n) {
	    List<Integer> primeNumbers = new LinkedList<>();
	    if (n >= 2) {
	        primeNumbers.add(2);
	    }
	    for (int i = 3; i <= n; i += 2) {
	        if (isPrimeBruteForce(i)) {
	            primeNumbers.add(i);
	        }
	    }
	    return primeNumbers;
	}
	
	private boolean isPrimeBruteForce(int number) {
	    for (int i = 2; i*i <= number; i++) {
	        if (number % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public List<Integer> primeNumbersBasicAlgo(int n, String javaVer) {
		List<Integer> primeNumbers = new LinkedList<>();
		if(javaVer != null && javaVer.equals("java7")) {
			int i =0;
		    int num =0;
		    
		    //primeNumbers = new ArrayList();
		    
		    for (i = 1; i <= n; i++)  	   
		    { 		 		  
		       int counter=0; 		  
		       for(num =i; num>=1; num--)
		       {
		    	   if(i%num==0)
		    	   {
		    		   counter = counter + 1;
		    	   }
		       }
		       if (counter ==2)
		       {
		    	   primeNumbers.add(i);
		       }	
		    }	
		}
		else if(javaVer != null && javaVer.equals("java8")) {
			primeNumbers = primeNumbersTill(n);
		}
		return primeNumbers;
	}
	
	private List primeNumbersTill(int n) {
	    return IntStream.rangeClosed(2, n)
	      .filter(x -> isPrime(x)).boxed()
	      .collect(Collectors.toList());
	}
	
	/*private boolean isPrime(Long number) {
		return LongStream.rangeClosed(2, (long) (Math.sqrt(number)))
	      .allMatch(n -> x % n != 0);
	}*/
	
	private boolean isPrime(int number) {
	    return number>1 && IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
	}
	
	public List<Integer> primeNumbersBigInteger(int n) {
		List<Integer> primeNumbers = new LinkedList<>();
		int val = 0;
		//System.out.println("Prime Numbers...");
	    while (true) {
	     if (val > n) {
	        break;
	     }
	     if (val > 1) {
	        if (new BigInteger(val+"").isProbablePrime(val / 2)) {
	        	primeNumbers.add(val);
	        	//System.out.println(val);
	        }
	     }
	     val++;
	    }
	    return primeNumbers;
	}
}
