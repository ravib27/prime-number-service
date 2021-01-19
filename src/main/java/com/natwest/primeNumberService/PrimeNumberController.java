package com.natwest.primeNumberService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeNumberController {

	@GetMapping("/primes/{initial}")
	public PrimeNumber greeting(@PathVariable Long initial) {
		
		/*int i =0;
	    int num =0;
	    //Empty String
	    List  primeNumbers = new ArrayList();
	    System.out.println("Enter the value of n:");
	    
	    for (i = 1; i <= initial; i++)  	   
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
	    	   //Appended the Prime number to the String
	    	   primeNumbers.add(i);
	       }	
	    }	
	    
	    System.out.println("Prime numbers from 1 to " + initial + " are :");
	    System.out.println(primeNumbers);*/
		
		List primeNumbers = primeNumbersTill(initial);
		
		return new PrimeNumber(initial, primeNumbers);
	}
	
	public static List primeNumbersTill(Long n) {
	    return LongStream.rangeClosed(2, n)
	      .filter(x -> isPrime(x)).boxed()
	      .collect(Collectors.toList());
	}
	
	/*private static boolean isPrime(Long number) {
		return LongStream.rangeClosed(2, (long) (Math.sqrt(number)))
	      .allMatch(n -> x % n != 0);
	}*/
	
	public static boolean isPrime(long number) {
	    return number>1 && LongStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
	}
}
