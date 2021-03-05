# prime-number-service
This is a RESTful service which calculates and returns all the prime numbers up to and including a number provided.

Example:

The REST call would look something like http://localhost:8080/primes/10 and would return JSON content: 

{

  "Initial":  10,

  "Primes": [2,3,5,7]

}

 

Project Features:

The project is written in Java.

The project uses Maven to build, test and run.

The project has unit and integration tests.

The project is runnable using SpringBoot.

The project supports varying return content types such as XML and JSON based, that is configurable using the requested media type in Accept Header.

The project has caching implemented to improve performance.

The solution supports multiple algorithms that can be switched based on optional parameters (implemented using Request Params). For example, to run the prime number service using Sieve Of Eratosthenes algorithm, the url would be : http://localhost:8080/primes/10?algorithm=sieveOfEratosthenes whereas to run it using Brute Force algorithm, the url would be : http://localhost:8080/primes/10?algorithm=primeNumbersBruteForce. There are also implementations using very basic algorithm (setting algorithm=basicPrimeAlgo) for finding Prime Numbers and also one to find using BigInteger (setting algorithm=usingBigInteger) for large integer values. The default value of the algorithm has been kept to sieveOfEratosthenes as that's found the most efficient.


The solution has also been deployed Google Could Platform (GCP) and can be access with following url : https://primenumberservice.ew.r.appspot.com/primes/10
