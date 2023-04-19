package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utility class for reading particular types of files.
 * @author Mursaleen
 *
 */
public class MyFileReader {

	/**
	 * Calculates the total sum of numbers in the given file.
	 * Returns 0.0 if there are no numerical values found, or there is an error or exception.
	 * @param fileName to read
	 * @return sum of all numbers in file
	 * @throws FileNotFoundException if file is not found
	 */
	public static double readFileGetTotalSum(String fileName) throws FileNotFoundException {
		
		//create file
		File file = new File(fileName);
		
		//create default sum value
		double sum = 0.0;
		
		//create scanner with given file
		Scanner scanner = new Scanner(file);
		
		//while scanner has another token (value)
		while (scanner.hasNext()) {
			
			//if token (value) is a double
			if (scanner.hasNextDouble()) {
				
				//get token (value) as a double and add to sum
				double numDouble = scanner.nextDouble();
				sum += numDouble;
			//if it's not a double, skip it
			} else {
				scanner.next();
			}
		}
		
		//close scanner
		scanner.close();
		
		return sum;
	}
	
	/**
	 * Calculates the sum of numbers in each line of the given fileName.
	 * @param fileName to read
	 * @return list of line sums
	 */
	public static ArrayList<Double> readFileGetLineSums(String fileName) {
		
		//create arraylist to store sum of numbers for each line of given file
		ArrayList<Double> lineSums = new ArrayList<Double>();
		
		//create file object
		File file = new File(fileName);
		
		//define file reader
		FileReader fileReader = null;
		
		//define buffered reader
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				
				//split line into tokens (values) based on whitespace using regular expression \\s+
				//to indicate one or more instances of whitespace
				String[] numStringArray = line.trim().split("\\s+");
				
				//set default sum for line
				double sum = 0.0;
				
				//iterate over array of strings
				for (int i = 0; i < numStringArray.length; i++) {
					
					//get each value as a string
					String numString = numStringArray[i];
					
					//try parsing to double
					try {
						//cast each value to a double
						double numDouble = Double.parseDouble(numString);
					
						//add to sum for line
						sum += numDouble;
						
					} catch (NumberFormatException e) {
						//gets and prints exception message
						System.out.println("Can't parse and add value. " + e.getMessage());
					}
				}
				
				//add line sum to list of sums
				lineSums.add(sum);	
			}
			
		} catch (FileNotFoundException e) {
			//gets and prints filename
			System.out.println("Sorry, " + file.getName() + " not found.");
		} catch (IOException e) {
			//prints the error message and info about which line
			e.printStackTrace();
		} finally {
			
			//regardless, close file objects
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return lineSums;
	}
}
