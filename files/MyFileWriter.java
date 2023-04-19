package files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Utility class for writing to files.
 * @author Mursaleen
 *
 */
public class MyFileWriter {

	/**
	 * Writes the list of sum values to given file.
	 * @param fileName to write to
	 * @param lineSums to write
	 * @param append to end of file
	 */
	public static void writeFileLineSums(String fileName, ArrayList<Double> lineSums, boolean append) {

		//create file object
		File file = new File(fileName);
		
		//define file writer
		FileWriter fileWriter = null;
		
		//define print writer
		PrintWriter printWriter = null;
		
		try {
			fileWriter = new FileWriter(file, append);
			printWriter = new PrintWriter(fileWriter);
			
			//iterate over arraylist of values and write each one to the file
			for (double line : lineSums) {
				printWriter.println(line);
			}
			
			//flush memory
			printWriter.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			//regardless of what happens, close file objects
			try {
				fileWriter.close();
				printWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
