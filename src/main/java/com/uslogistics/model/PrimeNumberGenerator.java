package com.uslogistics.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.Pattern;


/**
 * PrimeNumberGenerator 
 *    Spring bean for primenumber_generator.jsp form
 *       - generates primes numbers based on input of
 *         ranges of pairs of numbers
 *         
 *       Example:
 *       	Input : { [0,10] , [50,61] }
 *			Output: 2,3,5,7,53,59,61
    
 * @author angelareaves
 *
 */

public class PrimeNumberGenerator {
	
	private final int MAX_RANGE_SIZE = 2;
	
	private String numberPairInput;
	private boolean omitZeroAndOne;
	private int[][] pairsOfNumbers;
	private List<Integer> listOfAllPrimes;
	private List<PairOfInts> pairsOfIntegers;
	
	public PrimeNumberGenerator() {
		super();
	}
	
	PrimeNumberGenerator(String numberPairInput) {
		this.numberPairInput = numberPairInput;
		this.pairsOfIntegers = this.convertInputToPairsOfNumbers(numberPairInput);
		this.pairsOfNumbers = this.convertPairsToIntTable(this.pairsOfIntegers);
		this.omitZeroAndOne = true;
	}
	
	PrimeNumberGenerator(int[][] pairsOfNumbers) {
		listOfAllPrimes = new ArrayList<Integer>();
		this.pairsOfNumbers = pairsOfNumbers;
		this.omitZeroAndOne = true;
	}
	
	/**
	 * Getters and Setters 
	 * 
	 */
	
	
	//@RegExp(value="", message="input must be in the form [0,10], [50,61]");
	@Pattern(regexp="[ *\\\\s*\\\\{+\\\\[ \\\\d +\\\\,\\\\d+\\\\] +\\\\, *\\\\{+\\\\[ \\\\d +\\\\,\\\\d+\\\\] *\\\\} ]")
	public String getNumberPairInput() {
		return numberPairInput;
	}

	public void setNumberPairInput(String numberPairInput) {
		this.numberPairInput = numberPairInput;
		
	}
	
	public int[][] getPairsOfNumbers() {
		return pairsOfNumbers;
	}

	public void setPairsOfNumbers(int[][] pairsOfNumbers) {
		this.pairsOfNumbers = pairsOfNumbers;
	}
	
	public List<Integer> getListOfAllPrimes() {
		return listOfAllPrimes;
	}

	public void setListOfAllPrimes(List<Integer> listOfAllPrimes) {
		this.listOfAllPrimes = listOfAllPrimes;
	}
	public boolean isOmitZeroAndOne() {
		return omitZeroAndOne;
	}

	public void setOmitZeroAndOne(boolean omitZeroAndOne) {
		this.omitZeroAndOne = omitZeroAndOne;
	}
	
	public List<PairOfInts> getPairsOfIntegers() {
		return pairsOfIntegers;
	}

	public void setPairsOfIntegers(List<PairOfInts> pairsOfIntegers) {
		this.pairsOfIntegers = pairsOfIntegers;
	}
	
	@Override
    public String toString() {
		StringBuilder buildPrimes = new StringBuilder("Prime Numbers: ");
		
		if(listOfAllPrimes != null) {
			for(Integer prime : listOfAllPrimes) {
				buildPrimes.append(prime.toString());
				buildPrimes.append(" ");
			}
		}
        return buildPrimes.toString();
    }
	
	/**
	 * convertPairsToIntTable
	 *   method to convert List<PairOfInts> to int[][]
	 * @param pairList
	 * @return
	 */
	public int[][] convertPairsToIntTable(List<PairOfInts> pairList) {
		int tableSize = 0;
		if(pairList != null) tableSize = pairList.size();
		
		int[][] tableOfPairs = new int[tableSize][MAX_RANGE_SIZE];
		int count = 0;
		
		for(PairOfInts pair : pairList) {
			if(pair != null) {
				tableOfPairs[count][0] = pair.getNumber1();
				tableOfPairs[count][1] = pair.getNumber2();
			}
			count++;
		}
		return tableOfPairs;
	}
	
	/**
	 * convertInputToPairsOfNumbers
	 *   method to convert String input to List<PairOfInts>
	 * @param String input
	 * @return List<PairOfInts>
	 */
	public List<PairOfInts> convertInputToPairsOfNumbers(String input) {
		List<PairOfInts> pairsOfIntsList = new ArrayList<PairOfInts>();
		if(input != null) {
			List<String> list = Stream.of(input
					.split("]"))
					.map(line -> line.replace("{", ""))
					.map(line -> line.replace("[", ""))
					.map(line -> line.replace("]", ""))
					.map(line -> line.replace("}", ""))
					.map(line -> line.replace(", ", ""))
					.map(line -> line.trim())
					.collect(Collectors.toList());
		
			for(String s : list) {
				String[] numberPair = s.split(",");
				if((numberPair != null) && (!numberPair[0].equals(""))) {
					PairOfInts pairOfInts = new PairOfInts();
					pairOfInts.setNumber1(Integer.parseInt(numberPair[0]));
					pairOfInts.setNumber2(Integer.parseInt(numberPair[1]));
					pairsOfIntsList.add(pairOfInts);
				}
			}
		}
		return pairsOfIntsList;
	}
	
	/** 
	 * getRangeOfPrimesInPairs
	 *    method to gather all of the primes determined from each range
	 * @param int[][] pairsOfNumbers
	 */
	public void getRangeOfPrimesInPairs(int[][] pairsOfNumbers) {
		if(pairsOfNumbers != null) {
			List<Integer> primeList = new ArrayList<Integer>();
			for(int i=0; i < pairsOfNumbers.length; i++) {
				primeList.addAll(getRangeOfPrimesInPair(pairsOfNumbers[i][0], pairsOfNumbers[i][1]));
			
			}
			if(primeList != null) {
				setListOfAllPrimes(primeList);
			}
		} 
	}
	
	/** 
	 * getRangeOfPrimesInPair
	 *    method to determine the prime numbers in the given range
	 * @param int low
	 * @param int high
	 * @return List<Integer> 
	 */
	public List<Integer> getRangeOfPrimesInPair(int low, int high) {
		
		List<Integer> listOfPrimes = new ArrayList<Integer>();
		while (low <= high) {
	        boolean isPrime = true;

	        for(int i = 2; i <= low/2; i++) {
	            // condition for non-prime number
	            if(low % i == 0) {
	                isPrime = false;
	                break;
	            }
	        }

	        if (isPrime) {
	        	if(low == 0 || low == 1) {
	        		if(!omitZeroAndOne) {
	        			listOfPrimes.add(low);
	        		}
	        	} else {
	        		listOfPrimes.add(low);
	        	}
	        }

	        low++;
	    }
		return listOfPrimes;
	}
	
	
	/**
	 * PairOfInts class to hold a pair of ints
	 * @author angelareaves
	 *
	 */
	class PairOfInts {

		private int number1;
		private int number2;
		
		public int getNumber1() {
			return number1;
		}
		public void setNumber1(int number1) {
			this.number1 = number1;
		}
		public int getNumber2() {
			return number2;
		}
		public void setNumber2(int number2) {
			this.number2 = number2;
		}
		
		@Override
	    public String toString() {
			return "[" + this.number1 + ", " + this.number2 + "]";
		}
	}
}
