package com.bridgelabz.utility;

import java.io.*;
import java.util.*;


/**
 * 
 * @author: Bikash Mohanty at BridgeLabz Solutions
 * @Date: 14th Nov, 2019 
 * @version 1.0
 * @purpose: Putting Commonly used function in single file.
 *  
 */

public class Utility 
{
	private static Scanner scanner = new Scanner(System.in);
	private static BufferedReader bufferReader;

	private Utility()
	{
		//not called
	}

	//To take Integer input
	public static int inputInteger()
	{
		return scanner.nextInt();
	}
	public static long inputLong()
	{
		return scanner.nextLong();
	}
	public static boolean checkNext()
	{
		return scanner.hasNext();
	}
	//To take Double input
	public static double inputDouble()
	{
		return scanner.nextDouble();
	}
	//To take Float input
	public static float inputFloat()
	{
		return scanner.nextFloat();
	}
	//To take String input
	public static String inputString()
	{
		return scanner.next();
	}
	//To take String input
	public static String inputStringLine()
	{
		return scanner.nextLine();
	}

	//To Check Whether the String has at least 3 characters or not
	public static boolean stringCheck(String str)
	{
		return (str.matches(".*[a-zA-Z]+.*"));
	}
	//Calculate Random Numbers
	public static double randomNumber()
	{
		return Math.random();
	}

	/**
	 * Purpose: Check positive number or not
	 * @param number --> type integer
	 * @return count --> type integer
	 */

	public static boolean isPositive(int number)
	{
		return (number > 0);
	}

	//To count number of Digits in a number
	public static int countDigits(int number)
	{
		//int num =number;
		int count;

		for (count = 0; number != 0; )
		{
			number = number/ 10; //number will be divided with 10 until the result becomes 0
			count++;
		}
		return count;
	}
	
	//To count number of Digits(long) in a number
	public static long countDigits(long number)
	{
		//int num =number;
		int count;

		for (count = 0; number != 0; )
		{
			number = number/ 10; //number will be divided with 10 until the result becomes 0
			count++;
		}
		return count;
	}


	/***********************************LepYear******************************************/


	/**
	 * Purpose: To check Leap a Year is Leap Year or not
	 * @param year --> type integer
	 * @return --> boolean
	 */
	public static  boolean isLeapYear(int year)
	{
		/**
		 * A leap year is exactly divisible by 4 except for century years (years ending with 00). 
		 * The century year is a leap year only if it is perfectly divisible by 400
		 */
		boolean leapYear = false;
		if((year % 4 == 0 && year % 100 != 0) || year % 400 ==0)
		{
			leapYear = true;
			return leapYear;
		}

		else
		{
			leapYear = false;
			return leapYear;
		}

	}

	//Power of Two
	public static int powerOfTwo(int number, int digit)
	{
		return ((int) Math.pow(2, digit));
	}

	/***********************************BinaryNumber******************************************/

	public static String checkBinary(int decimal, long x) 
	{
		int remainder;
		StringBuilder binary = new StringBuilder();
		//To generate the binary number from the decimal number until decimal is equal to 0
		for (; decimal != 0; decimal/=2) 
		{
			remainder= decimal % 2;	//storing the binary number in an Array
			binary.append(remainder);
		}
				
		binary.reverse();
		return binary.toString();
	}
	


	/**
	 * Data Structure and Algorithm Section Begins Here
	 */




	// 1. Binary Search
	public static int binarySearch(List<Integer> list, int firstIndex, int lastIndex, int searchValue)
	{
		if (lastIndex >= firstIndex )
		{
			int mid = firstIndex + (lastIndex - firstIndex)/2;

			if(list.get(mid) == searchValue)
				return mid;

			if(list.get(mid) >= searchValue)
				return binarySearch(list, firstIndex, mid - 1, searchValue); 

			return binarySearch(list, mid + 1, lastIndex, searchValue); 
		}
		return -1;
	}
	//TwoDimensional Array Creation
	public static void arrayTwoDimensional(int [][] array, int row, int col)
	{

		for (int i = 0; i < row; i++) 
		{
			for (int j = 0; j < col; j++) 
			{
				System.out.print(array[i][j] + " ");
			}
			System.out.println();

		}

	}


	/***********************************Palindrome******************************************/

	/**
	 * 
	 * @param number --> integer type
	 * @return --> Boolean Value
	 * 
	 */


	public static boolean isPallindrome(int number)
	{
		int num = number;
		int pallindrome = 0;
		while(number > 0)
		{
			int remainder = number % 10;
			pallindrome = pallindrome*10 + remainder;
			number/=10;
		}

		if(num == pallindrome)
			return true;
		else
			return false;
	}


	/***********************************Anagram (Taking String Vlaues) ******************************************/

	/**
	 * 
	 * @param str1 --> String
	 * @param str2 --> String
	 * @return --> Boolean
	 * 
	 */


	public static boolean isAnagram(String str1, String str2)
	{
		char[] array1 = str1.toCharArray();
		char[] array2 = str2.toCharArray();

		//Sorting Both character Arrays
		Arrays.sort(array1);
		Arrays.sort(array2);

		//if both the arrays are equal after sorting then they are Anagram else not
		if (Arrays.equals(array1, array2)) //condition will check the return value is true or not
			return true;
		else
			return false;

	}
	
	/***********************************Anagram (Taking Integer Values) ******************************************/
	
	/**
	 * 
	 * @param number1 --> Integer
	 * @param number2 --> Integer
	 * @return --> Boolean
	 */
	
	public static boolean isAnagram(int number1, int number2) 
	{
		int length1 = countDigits(number1);
		int length2 = countDigits(number2);
		if (length1 != length2)
			return false;

		int i = 0;
		int j = 0;
		int[] array1 = new int[length1];
		int[] array2 = new int[length2];
		while (number1 != 0) 
		{
			int rem = number1 % 10;
			array1[i] = rem;				//Storing the numbers in reversed order in array1
			number1 = number1 / 10;
			i++;
		}
		while (number2 != 0) 
		{
			int rem = number2 % 10;
			array2[j] = rem;				//Storing the numbers in reversed order in array2
			number2 = number2 / 10;
			j++;
		}
		
		//Sorting both the arrays
		
		Arrays.sort(array1);
		Arrays.sort(array2);

		if (Arrays.equals(array1, array2)) //Checking if both the arrays are equal
			return true;
		else
			return false;

	}
	
	
	
	/***********************************Creating and Writing into File******************************************/
	
	/**
	 * 
	 * @param filename --> String type
	 * @param data --> String Type
	 * @return --> boolean
	 */
	
	public static boolean writeToFile(String filename, String data) 
	{
		File file = new File(filename);
		BufferedWriter bw = null;
		if (!file.exists()) 
		{
			try
			{
				if(file.createNewFile())
					System.out.println("File Created Succcessfully");
				else
					System.out.println("File Already Exists");
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

		try 
		{
			bw = new BufferedWriter(new FileWriter(new File(filename)));
			bw.write(data);
			bw.flush();
			bw.close();

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return true;
	}
	
	
	/***********************************Read From File******************************************/
	
	
	/**
	 * 
	 * @param filename --> String type
	 * @return --> String
	 */
	
	public static String readFromFile(String filename) 
	{

		try
		{

			bufferReader = new BufferedReader(new FileReader(filename));

		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error in Loading Reader"+e.getMessage());
		}

		StringBuilder sb = new StringBuilder();

		try 
		{
			String line;
			while ((line = bufferReader.readLine()) != null) //append until file pointer reaches to null
				sb.append(line);

		}
		catch (IOException e) 
		{
			System.out.println("File is Empty:  " + e.getMessage());
		} 
		finally 
		{
			try 
			{
				bufferReader.close();
			} 
			catch (IOException e) 
			{
				System.out.println(e.getStackTrace());
			}

		}

		return sb.toString();

	}
	
	
	/***********************************Bubble Sort******************************************/
	
	/**
	 * 
	 * @param arr --> Integer type Array
	 * @param arrLength --> Integer
	 * @return --> Integer array
	 */
	
	
	public static int[] bubbleSort(int[] arr, int arrLength) 
	{
		System.out.println("Before Sorting");
		//prints the array before sorting
		for(int i = 0; i < arrLength; i++)
			System.out.print(arr[i]+ " ");
		
		System.out.println("\nAfter Sorting\n____________________________________\n");
		for(int i = 0; i < arrLength-1; i++)
		{
			/**
			 * this loop will execute i-1 times as the last index will be stored in 'i'
			 * we compare 'jth index' with the next index for sorting
			 */
			for(int j = 0; j < arrLength-i-1; j++)
			{
				int temp;
				//swap arr[j+1] and arr[i]
				if(arr[j] > arr[j+1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
							
				}
			}
			
		}
		return arr;
	}
	
	
	/***********************************Prime Number******************************************/
	
	/**
	 * 
	 * @param num --> Integer
	 * @return --> boolean
	 */
	
	public static boolean isPrime(int num)
	{
		boolean flag = true;
		for (int i = 2; i <= num/2; i++) 
		{
			if(num % i == 0)
			{
				flag = false;
				break;
			}	
		}
		return flag;
	}
	
	/***********************************Prime Number******************************************/
	/**
	 * 
	 * @param number --> integer
	 * @return factorial --> integer type
	 */
	public static int factorial(int number)
	{
		if(number == 0)
			return 1;
		
		int factorial = 1;
		for(int i = 1; i <= number; i++)
			factorial *= i;
		
		return factorial;
		
	}

}
