package com.natwest.primeService;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.natwest.primeNumberService.PrimeNumber;
import com.natwest.primeNumberService.controller.PrimeNumberController;
import com.natwest.primeNumberService.service.PrimeNumberService;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = PrimeNumberController.class)
@WebMvcTest
public class PrimeNumberControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PrimeNumberService primeNumberService;
	
	PrimeNumber mockPrimeNumber = new PrimeNumber(10, Arrays.asList(2, 3, 5, 7));
	
	Logger logger = LoggerFactory.getLogger(PrimeNumberControllerUnitTest.class);

	@Test
	public void fetchPrimeNumbersWithoutRequestParamJSON() throws Exception {

		Mockito.when(
				primeNumberService.sieveOfEratosthenes(10)).thenReturn(Arrays.asList(2, 3, 5, 7));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/primes/10")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		//logger.info(result.getResponse().toString());
		String expected = "{\"initial\":10,\"primes\":[2,3,5,7]}";
		logger.info("result.getResponse() ::> " + result.getResponse().getContentAsString() + " // Context Over");
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void fetchPrimeNumbersWithoutRequestParamXML() throws Exception {

		Mockito.when(
				primeNumberService.sieveOfEratosthenes(10)).thenReturn(Arrays.asList(2, 3, 5, 7));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/primes/10")
				.accept(MediaType.APPLICATION_XML);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		//logger.info(result.getResponse());
		String expected = "<PrimeNumber><initial>10</initial><primes><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></primes></PrimeNumber>";
		//logger.info("result.getResponse() ::> " + result.getResponse().getContentAsString() + " // Context Over");
		assertEquals(expected, result.getResponse().getContentAsString());
	}
	
	@Test
	public void fetchPrimeNumbersUsingSieveOfEratosthenesJSON() throws Exception {

		Mockito.when(
				primeNumberService.sieveOfEratosthenes(10)).thenReturn(Arrays.asList(2, 3, 5, 7));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/primes/10?algorithm=sieveOfEratosthenes")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		//logger.info(result.getResponse().toString());
		String expected = "{\"initial\":10,\"primes\":[2,3,5,7]}";
		logger.info("result.getResponse() ::> " + result.getResponse().getContentAsString() + " // Context Over");
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void fetchPrimeNumbersUsingSieveOfEratosthenesXML() throws Exception {

		Mockito.when(
				primeNumberService.sieveOfEratosthenes(10)).thenReturn(Arrays.asList(2, 3, 5, 7));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/primes/10?algorithm=sieveOfEratosthenes")
				.accept(MediaType.APPLICATION_XML);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		//logger.info(result.getResponse());
		String expected = "<PrimeNumber><initial>10</initial><primes><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></primes></PrimeNumber>";
		//logger.info("result.getResponse() ::> " + result.getResponse().getContentAsString() + " // Context Over");
		assertEquals(expected, result.getResponse().getContentAsString());
	}
	
	@Test
	public void fetchPrimeNumbersUsingPrimeNumbersBruteForceJSON() throws Exception {

		Mockito.when(
				primeNumberService.primeNumbersBruteForce(10)).thenReturn(Arrays.asList(2, 3, 5, 7));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/primes/10?algorithm=primeNumbersBruteForce")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		//logger.info(result.getResponse().toString());
		String expected = "{\"initial\":10,\"primes\":[2,3,5,7]}";
		logger.info("result.getResponse() ::> " + result.getResponse().getContentAsString() + " // Context Over");
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void fetchPrimeNumbersUsingPrimeNumbersBruteForceXML() throws Exception {

		Mockito.when(
				primeNumberService.primeNumbersBruteForce(10)).thenReturn(Arrays.asList(2, 3, 5, 7));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/primes/10?algorithm=primeNumbersBruteForce")
				.accept(MediaType.APPLICATION_XML);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		//logger.info(result.getResponse());
		String expected = "<PrimeNumber><initial>10</initial><primes><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></primes></PrimeNumber>";
		//logger.info("result.getResponse() ::> " + result.getResponse().getContentAsString() + " // Context Over");
		assertEquals(expected, result.getResponse().getContentAsString());
	}
	
	@Test
	public void fetchPrimeNumbersUsingBasicPrimeAlgoJava7JSON() throws Exception {

		Mockito.when(
				primeNumberService.primeNumbersBasicAlgo(10,"java7")).thenReturn(Arrays.asList(2, 3, 5, 7));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/primes/10?algorithm=basicPrimeAlgo&javaVer=java7")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		//logger.info(result.getResponse().toString());
		String expected = "{\"initial\":10,\"primes\":[2,3,5,7]}";
		logger.info("result.getResponse() ::> " + result.getResponse().getContentAsString() + " // Context Over");
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void fetchPrimeNumbersUsingBasicPrimeAlgoJava7XML() throws Exception {

		Mockito.when(
				primeNumberService.primeNumbersBasicAlgo(10,"java7")).thenReturn(Arrays.asList(2, 3, 5, 7));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/primes/10?algorithm=basicPrimeAlgo&javaVer=java7")
				.accept(MediaType.APPLICATION_XML);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		//logger.info(result.getResponse());
		String expected = "<PrimeNumber><initial>10</initial><primes><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></primes></PrimeNumber>";
		//logger.info("result.getResponse() ::> " + result.getResponse().getContentAsString() + " // Context Over");
		assertEquals(expected, result.getResponse().getContentAsString());
	}
	
	@Test
	public void fetchPrimeNumbersUsingBasicPrimeAlgoJava8JSON() throws Exception {

		Mockito.when(
				primeNumberService.primeNumbersBasicAlgo(10,"java8")).thenReturn(Arrays.asList(2, 3, 5, 7));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/primes/10?algorithm=basicPrimeAlgo&javaVer=java8")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		//logger.info(result.getResponse().toString());
		String expected = "{\"initial\":10,\"primes\":[2,3,5,7]}";
		logger.info("result.getResponse() ::> " + result.getResponse().getContentAsString() + " // Context Over");
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void fetchPrimeNumbersUsingBasicPrimeAlgoJava8XML() throws Exception {

		Mockito.when(
				primeNumberService.primeNumbersBasicAlgo(10,"java8")).thenReturn(Arrays.asList(2, 3, 5, 7));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/primes/10?algorithm=basicPrimeAlgo&javaVer=java8")
				.accept(MediaType.APPLICATION_XML);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		//logger.info(result.getResponse());
		String expected = "<PrimeNumber><initial>10</initial><primes><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></primes></PrimeNumber>";
		//logger.info("result.getResponse() ::> " + result.getResponse().getContentAsString() + " // Context Over");
		assertEquals(expected, result.getResponse().getContentAsString());
	}
	
	@Test
	public void fetchPrimeNumbersUsingUsingBigIntegerJSON() throws Exception {

		Mockito.when(
				primeNumberService.primeNumbersBigInteger(10)).thenReturn(Arrays.asList(2, 3, 5, 7));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/primes/10?algorithm=usingBigInteger")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		//logger.info(result.getResponse().toString());
		String expected = "{\"initial\":10,\"primes\":[2,3,5,7]}";
		logger.info("result.getResponse() ::> " + result.getResponse().getContentAsString() + " // Context Over");
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void fetchPrimeNumbersUsingUsingBigIntegerXML() throws Exception {

		Mockito.when(
				primeNumberService.primeNumbersBigInteger(10)).thenReturn(Arrays.asList(2, 3, 5, 7));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/primes/10?algorithm=usingBigInteger")
				.accept(MediaType.APPLICATION_XML);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		int status = result.getResponse().getStatus();
		assertEquals(200, status);

		//logger.info(result.getResponse());
		String expected = "<PrimeNumber><initial>10</initial><primes><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></primes></PrimeNumber>";
		//logger.info("result.getResponse() ::> " + result.getResponse().getContentAsString() + " // Context Over");
		assertEquals(expected, result.getResponse().getContentAsString());
	}
}
