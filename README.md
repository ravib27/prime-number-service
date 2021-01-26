# prime-number-service
This is a RESTful service which calculates and returns all the prime numbers up to and including a number provided.

Example:

The REST call would look something like http://localhost:8080/primes/10 and would return JSON content: 

{

  "Initial":  10,

  "Primes": [2,3,5,7]

}

 

Project Features:

The project is written in Java 7 and 8.

The project uses Maven to build, test and run.

The project has unit and integration tests.

The project is runnable using SpringBoot.

The project supports varying return content types such as XML and JSON based, that is configurable using the requested media type in Accept Header.

The project has caching implemented to improve performance.

The project supports multiple algorithms that can be switched based on optional parameters (implemented using Request Params). For example, to run the prime number service using Sieve Of Eratosthenes alogorithm, the url would be : http://localhost:8080/primes/10?algorithm=sieveOfEratosthenes whereas to run it using Brute Force algorithm, the url would be : http://localhost:8080/primes/10?algorithm=primeNumbersBruteForce . The default value of algorithm has been kept to sieveOfEratosthenes as thats found the most efficient.


Optional Extensions:

Deploy the solution to a chosen platform that we can access.
