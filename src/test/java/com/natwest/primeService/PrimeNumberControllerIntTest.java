package com.natwest.primeService;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.natwest.primeNumberService.PrimeNumberServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PrimeNumberServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PrimeNumberControllerIntTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void fetchPrimeNumbersWithoutRequestParamJSON() throws JSONException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
	     
		final String baseUrl = createURLWithPort("/primes/10");
		URI uri = new URI(baseUrl);
		     
		HttpHeaders headers = new HttpHeaders();
		List mediaTypeLst = new ArrayList();
		mediaTypeLst.add(MediaType.APPLICATION_JSON);
		headers.setAccept(mediaTypeLst);
		 
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		     
		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		
		//Verify result body matches the expected output
		String expected = "{\"initial\":10,\"primes\":[2,3,5,7]}";
		JSONAssert.assertEquals(expected, result.getBody(), false);
	}
	
	@Test
	public void fetchPrimeNumbersWithoutRequestParamXML() throws JSONException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
	     
		final String baseUrl = createURLWithPort("/primes/10");
		URI uri = new URI(baseUrl);
		     
		HttpHeaders headers = new HttpHeaders();
		List mediaTypeLst = new ArrayList();
		mediaTypeLst.add(MediaType.APPLICATION_XML);
		headers.setAccept(mediaTypeLst);
		 
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		     
		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		
		//Verify result body matches the expected output
		String expected = "<PrimeNumber><initial>10</initial><primes><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></primes></PrimeNumber>";
		assertEquals(expected, result.getBody());
	}
	
	@Test
	public void fetchPrimeNumbersUsingSieveOfEratosthenesJSON() throws JSONException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
	     
		final String baseUrl = createURLWithPort("/primes/10?algorithm=sieveOfEratosthenes");
		URI uri = new URI(baseUrl);
		     
		HttpHeaders headers = new HttpHeaders();
		List mediaTypeLst = new ArrayList();
		mediaTypeLst.add(MediaType.APPLICATION_JSON);
		headers.setAccept(mediaTypeLst);
		 
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		     
		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		
		//Verify result body matches the expected output
		String expected = "{\"initial\":10,\"primes\":[2,3,5,7]}";
		JSONAssert.assertEquals(expected, result.getBody(), false);
	}
	
	@Test
	public void fetchPrimeNumbersUsingSieveOfEratosthenesXML() throws JSONException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
	     
		final String baseUrl = createURLWithPort("/primes/10?algorithm=sieveOfEratosthenes");
		URI uri = new URI(baseUrl);
		     
		HttpHeaders headers = new HttpHeaders();
		List mediaTypeLst = new ArrayList();
		mediaTypeLst.add(MediaType.APPLICATION_XML);
		headers.setAccept(mediaTypeLst);
		 
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		     
		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		
		//Verify result body matches the expected output
		String expected = "<PrimeNumber><initial>10</initial><primes><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></primes></PrimeNumber>";
		assertEquals(expected, result.getBody());
	}
	
	@Test
	public void fetchPrimeNumbersUsingPrimeNumbersBruteForceJSON() throws JSONException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
	     
		final String baseUrl = createURLWithPort("/primes/10?algorithm=primeNumbersBruteForce");
		URI uri = new URI(baseUrl);
		     
		HttpHeaders headers = new HttpHeaders();
		List mediaTypeLst = new ArrayList();
		mediaTypeLst.add(MediaType.APPLICATION_JSON);
		headers.setAccept(mediaTypeLst);
		 
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		     
		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		
		//Verify result body matches the expected output
		String expected = "{\"initial\":10,\"primes\":[2,3,5,7]}";
		JSONAssert.assertEquals(expected, result.getBody(), false);
	}
	
	@Test
	public void fetchPrimeNumbersUsingPrimeNumbersBruteForceXML() throws JSONException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
	     
		final String baseUrl = createURLWithPort("/primes/10?algorithm=primeNumbersBruteForce");
		URI uri = new URI(baseUrl);
		     
		HttpHeaders headers = new HttpHeaders();
		List mediaTypeLst = new ArrayList();
		mediaTypeLst.add(MediaType.APPLICATION_XML);
		headers.setAccept(mediaTypeLst);
		 
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		     
		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		
		//Verify result body matches the expected output
		String expected = "<PrimeNumber><initial>10</initial><primes><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></primes></PrimeNumber>";
		assertEquals(expected, result.getBody());
	}
	
	@Test
	public void fetchPrimeNumbersUsingBigIntegerJSON() throws JSONException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
	     
		final String baseUrl = createURLWithPort("/primes/10?algorithm=usingBigInteger");
		URI uri = new URI(baseUrl);
		     
		HttpHeaders headers = new HttpHeaders();
		List mediaTypeLst = new ArrayList();
		mediaTypeLst.add(MediaType.APPLICATION_JSON);
		headers.setAccept(mediaTypeLst);
		 
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		     
		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		
		//Verify result body matches the expected output
		String expected = "{\"initial\":10,\"primes\":[2,3,5,7]}";
		JSONAssert.assertEquals(expected, result.getBody(), false);
	}
	
	@Test
	public void fetchPrimeNumbersUsingBigIntegerXML() throws JSONException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
	     
		final String baseUrl = createURLWithPort("/primes/10?algorithm=usingBigInteger");
		URI uri = new URI(baseUrl);
		     
		HttpHeaders headers = new HttpHeaders();
		List mediaTypeLst = new ArrayList();
		mediaTypeLst.add(MediaType.APPLICATION_XML);
		headers.setAccept(mediaTypeLst);
		 
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		     
		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		
		//Verify result body matches the expected output
		String expected = "<PrimeNumber><initial>10</initial><primes><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></primes></PrimeNumber>";
		assertEquals(expected, result.getBody());
	}
	
	@Test
	public void fetchPrimeNumbersUsingBasicPrimeAlgoJava7JSON() throws JSONException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
	     
		final String baseUrl = createURLWithPort("/primes/10?algorithm=basicPrimeAlgo");
		URI uri = new URI(baseUrl);
		     
		HttpHeaders headers = new HttpHeaders();
		List mediaTypeLst = new ArrayList();
		mediaTypeLst.add(MediaType.APPLICATION_JSON);
		headers.setAccept(mediaTypeLst);
		 
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		     
		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		
		//Verify result body matches the expected output
		String expected = "{\"initial\":10,\"primes\":[2,3,5,7]}";
		JSONAssert.assertEquals(expected, result.getBody(), false);
	}
	
	@Test
	public void fetchPrimeNumbersUsingBasicPrimeAlgoJava7XML() throws JSONException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
	     
		final String baseUrl = createURLWithPort("/primes/10?algorithm=basicPrimeAlgo");
		URI uri = new URI(baseUrl);
		     
		HttpHeaders headers = new HttpHeaders();
		List mediaTypeLst = new ArrayList();
		mediaTypeLst.add(MediaType.APPLICATION_XML);
		headers.setAccept(mediaTypeLst);
		 
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		     
		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		
		//Verify result body matches the expected output
		String expected = "<PrimeNumber><initial>10</initial><primes><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></primes></PrimeNumber>";
		assertEquals(expected, result.getBody());
	}
	
	@Test
	public void fetchPrimeNumbersUsingBasicPrimeAlgoJava8JSON() throws JSONException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
	     
		final String baseUrl = createURLWithPort("/primes/10?algorithm=basicPrimeAlgo&javaVer=java8");
		URI uri = new URI(baseUrl);
		     
		HttpHeaders headers = new HttpHeaders();
		List mediaTypeLst = new ArrayList();
		mediaTypeLst.add(MediaType.APPLICATION_JSON);
		headers.setAccept(mediaTypeLst);
		 
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		     
		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		
		//Verify result body matches the expected output
		String expected = "{\"initial\":10,\"primes\":[2,3,5,7]}";
		JSONAssert.assertEquals(expected, result.getBody(), false);
	}
	
	@Test
	public void fetchPrimeNumbersUsingBasicPrimeAlgoJava8XML() throws JSONException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
	     
		final String baseUrl = createURLWithPort("/primes/10?algorithm=basicPrimeAlgo&javaVer=java8");
		URI uri = new URI(baseUrl);
		     
		HttpHeaders headers = new HttpHeaders();
		List mediaTypeLst = new ArrayList();
		mediaTypeLst.add(MediaType.APPLICATION_XML);
		headers.setAccept(mediaTypeLst);
		 
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		     
		//Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		
		//Verify result body matches the expected output
		String expected = "<PrimeNumber><initial>10</initial><primes><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></primes></PrimeNumber>";
		assertEquals(expected, result.getBody());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
