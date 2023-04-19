package files;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Controller class.
 * @author Mursaleen
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//name of file to read
		String fileName = "text.txt";
		
		//define default sum value
		double sum = 0.0;
		
		//try to get sum of numbers in file
		try {
			sum = MyFileReader.readFileGetTotalSum(fileName);
		} catch (FileNotFoundException e) {
			//prints error message and info about which line
			e.printStackTrace();
		} finally {
			//prints the value of sum, regardless of any exception
			System.out.println("total sum: " + sum);
		}
		
		//get list of line sums
		ArrayList<Double> lineSums = MyFileReader.readFileGetLineSums(fileName);
		System.out.println("total line sums: " + lineSums);
		
		//write list of sum values to new file
		MyFileWriter.writeFileLineSums("text_line_sums.txt", lineSums, false);
		
	}

}
