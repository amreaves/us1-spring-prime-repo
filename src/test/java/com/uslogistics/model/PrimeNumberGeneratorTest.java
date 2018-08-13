package com.uslogistics.model;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;








class PrimeNumberGeneratorTest {
	
	protected PrimeNumberGenerator pmg;

	@Test
	void testConvertPairsToIntTable() {
		//converts List<PairOfInts>  to int[][]
		//method to convert String input to List<PairOfInts>
		String inputData = "{ [0,10], [50,61] }";
		pmg = new PrimeNumberGenerator(inputData);
		
		Assert.assertEquals(0,  pmg.getPairsOfNumbers()[0][0]);
		Assert.assertEquals(10,  pmg.getPairsOfNumbers()[0][1]);
		Assert.assertEquals(50,  pmg.getPairsOfNumbers()[1][0]);
		Assert.assertEquals(61,  pmg.getPairsOfNumbers()[1][1]);
		
	}

	@Test
	void testConvertInputToPairsOfNumbers() {
		
		//method to convert String input to List<PairOfInts>
		String inputData = "{ [0,10], [50,61] }";
		pmg = new PrimeNumberGenerator(inputData);
		
		Assert.assertEquals(0, pmg.getPairsOfIntegers().get(0).getNumber1());
		Assert.assertEquals(10, pmg.getPairsOfIntegers().get(0).getNumber2());
		Assert.assertEquals(50, pmg.getPairsOfIntegers().get(1).getNumber1());
		Assert.assertEquals(61, pmg.getPairsOfIntegers().get(1).getNumber2());
		
	}

	@Test
	void testGetRangeOfPrimesInPairs() {
		//method to gather all of the primes determined from each range
		String inputData = "{ [0,10], [50,61] }";
		pmg = new PrimeNumberGenerator(inputData);
		pmg.getRangeOfPrimesInPairs(pmg.getPairsOfNumbers());
		
		
		Assert.assertEquals(2, pmg.getListOfAllPrimes().get(0).intValue());
		Assert.assertEquals(3, pmg.getListOfAllPrimes().get(1).intValue());
		Assert.assertEquals(5, pmg.getListOfAllPrimes().get(2).intValue());
		Assert.assertEquals(7, pmg.getListOfAllPrimes().get(3).intValue());
		Assert.assertEquals(53, pmg.getListOfAllPrimes().get(4).intValue());
		Assert.assertEquals(59, pmg.getListOfAllPrimes().get(5).intValue());
		Assert.assertEquals(61, pmg.getListOfAllPrimes().get(6).intValue());
		
	}

	@Test
	void testGetRangeOfPrimesInPair() {
		//method to determine the prime numbers in the given range
		String inputData = "{ [0,10], [50,61] }";
		pmg = new PrimeNumberGenerator(inputData);
		List<Integer> primeList = pmg.getRangeOfPrimesInPair(0, 10);
		Assert.assertEquals(2, primeList.get(0).intValue());
		Assert.assertEquals(3, primeList.get(1).intValue());
		Assert.assertEquals(5, primeList.get(2).intValue());
		Assert.assertEquals(7, primeList.get(3).intValue());
	}

}
