import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains various methods for parsing Strings based on regular expressions.
 * @author lbrandon
 *
 */
public class RegexClass {

	/**
	 * Prints given array of Strings.
	 * @param arr to print
	 */
	public static void printTokens(String[] arr) {
		System.out.println("Printing tokens:");
		String finalS = "";
		
		//iterate over given array and concatenate each string, 
		//followed by comma and single space
		for (String s : arr) {
			finalS += (s + ", ");
		}
		
		//remove last 2 chars (comma and single space)
		finalS = finalS.substring(0, finalS.length() - 2);
		System.out.println(finalS);
		System.out.println();
	}
	
	/**
	 * Splits the given string based on the given regex pattern.
	 * @param str to split
	 * @param regex pattern to match
	 * @return String array of tokens (strings)
	 */
	public static String[] splitString(String str, String regex) {
		//split given string based on given regex
		return str.split(regex);
	}
	
	/**
	 * Replaces all instances of the given pattern (regex)
	 * with the given replacement in the given String str.
	 * @param str to replace values in
	 * @param pattern to use for replacement
	 * @param replacement for the pattern
	 * @return updated str
	 */
	public static String replaceAllWithPattern(String str, String pattern, String replacement) {
		//replace the given pattern with the given replacement in str
		return str.replaceAll(pattern, replacement);
	}
	
	/**
	 * Parses and returns various parts of a given phone.
	 * @param phone number to parse
	 * @param part of phone number to return: 1 (area code), 2 (prefix), and 3 (number)
	 * @return part of phone number
	 */
	public static String getPhonePart(String phone, int part) {
		if (part < 1 || part > 3) {
			throw new IllegalArgumentException("Part must be 1, 2 or 3.");
		}
		
		//parenthesis() indicate groups
		//[-.\\s]+ indicates a character class,
		//matching one of multiple characters (with repetition): -, ., whitespace
		//\b matches an empty string or non-word character,
		//at the beginning or end of the pattern
		String regex = "\\b(\\d{3})[-.\\s]+(\\d{3})[-.\\s]+(\\d{4})\\b";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(phone);
		
		String phonePart = "";
		//matches entire phone number
		while (m.find()) {
			//get designated group
			phonePart = m.group(part);
		}
		
		return phonePart;
	}
	
	/**
	 * Replaces the area code in the given phone number with the given new area code.
	 * @param phone to replace area code in
	 * @param newArea for phone
	 * @return updated phone number
	 */
	public static String replaceAreaCode(String phone, String newArea) {
		
		//[0-9] indicates a character class
		//matching one of several characters: 0 - 9
		//{3} indicates exactly 3 in a row
		return phone.replaceFirst("[0-9]{3}", newArea);
	}
	
	public static void main(String[] args) {
		

		String str = "The cow jumped over the moon";
		//split the String based on single space
		String[] tokens = RegexClass.splitString(str, " ");
		RegexClass.printTokens(tokens);
		
		//split the String based on "the"
		tokens = RegexClass.splitString(str, "the");
		RegexClass.printTokens(tokens);
		
		str = "the        cow       jumped over          the\n"
				+ "         moon";
		//split the String based on various amounts of whitespace
		// \s matches a single whitespace character " "
		// \s+ matches 1 or more whitespace characters
		// because the \ (backslash) is a special character, we escape it with another \ (backslash)
		// so we use \\s+ to match 1 or more whitespace characters
		tokens = RegexClass.splitString(str, "\\s+");
		RegexClass.printTokens(tokens);
		
		String updatedStr = RegexClass.replaceAllWithPattern(str, "\\s+", " ");
		System.out.println("Replace whitespace: " + updatedStr);
		System.out.println("");
		
		//get parts of phone number
		String areaCode = RegexClass.getPhonePart("123-982-6342", 1); //get area code
		String prefix = RegexClass.getPhonePart("800 787     2394", 2); //get prefix
		String lineNumber = RegexClass.getPhonePart("  508.717.0989     ", 3); //get line number
		System.out.println("Phone number parts: " + areaCode + " " + prefix + " " + lineNumber);
		System.out.println("");
		
		//replace area code
		String phone = "123-982-6342";
		String updatedPhone = RegexClass.replaceAreaCode(phone, "888");
		System.out.println("Updated phone: " + updatedPhone);
		System.out.println("");
		
		//split text into sentences
		//a question can end with a . or ! or ?
		String text = "I'm fixing a hole where the rain gets in. " +
				"And stops my mind from wandering! " +
				"Where it will go?";
		
		tokens = RegexClass.splitString(text, "[.!?]");
		RegexClass.printTokens(tokens);
		
		//extract quote from text
		String quoteString = "\"Be yourself; everyone else is already taken.\" said Oscar Wilde";
		
		//escape double-quotes " with backslash \
		tokens = RegexClass.splitString(quoteString, "\"");
		
		//2nd item in tokens array is the quote itself
		String quote = tokens[1];
		
		System.out.println("Oscar Wilde said: " + quote);
		System.out.println("");
		
	}
}
