import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Class with various methods for using different kinds of Collections.
 * @author lbrandon
 *
 */
public class CollectionsClass {

	/**
	 * Takes a given list and removes elements in the range min through max (inclusive).
	 * 
	 * Demonstrates use of Iterator.
	 * 
	 * @param list of values
	 * @param min of range
	 * @param max of range
	 */
	public static void removeRange(ArrayList<Integer> list, int min, int max) {
		
		//Create iterator to iterate over list and remove items in place
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			if (next >= min && next <= max) {
				iterator.remove();
			}
		}
	}
	
	/**
	 * Takes given arraylist and modifies the list by placing a "*" in between each element, 
	 * and at the beginning and the end.
	 * 
	 * @param list of values to add stars
	 */
	public static void addStars(ArrayList<String> list) {
		
		//copy all values in arraylist to array
		//toArray takes as input an empty array into which the values will be stored
		String[] array = list.toArray(new String[list.size()]);
		
		//empty original arraylist
		list.removeAll(Arrays.asList(array));
		
		//add stars and values back into original arraylist
		list.add("*");
		for (String s : array) {
			list.add(s);
			list.add("*");
		}
	}
	
	/**
	 * Takes the given array of strings and returns a map with a key for each different string,
	 * and a value for the count of the number of times that string appears in the array.
	 * 
	 * Demonstrates use of HashMap.
	 * 
	 * @param strings to count
	 * @return map of word counts, where key is word and value is count
	 */
	public static Map<String, Integer> wordCount(String[] strings) {
		
		//create a hashmap (has no order)
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//iterate over array of strings
		for (String s : strings) {
			
			//if map doesn't contain key for string, add it
			if (!map.containsKey(s)) {
				
				//add key with default count 1
				map.put(s, 1);
			} else {
				
				//replace old count with incremented count
				map.replace(s, map.get(s) + 1);
			}
		}
		
		return map;
	}
	
	/**
	 * Takes an array of strings and returns a count of the unique words in the array.
	 * Case-sensitive. e.g. "Hello" and "hello" are considered different words.
	 * 
	 * Demonstrates use of HashSet.
	 * 
	 * @param words to count
	 * @return count of unique words
	 */
	public static int countUniqueWords(String[] words) {
		
		//create hashset (hash no order) of words in given array
		Set<String> hashSetWords = new HashSet<String>(Arrays.asList(words));
		
		//return count of unique elements in given array
		return hashSetWords.size();
	}
	
	/**
	 * Takes a map of food keys and food topping values, and modifies and returns the map
	 * as follows:
	 * If the key "ice cream" is present, set its value to "cherry"
	 * In all cases, set the key "bread" to have the value of "butter"
	 * 
	 * @param map of food items and toppings
	 * @return updated map of food items and toppings
	 */
	public static Map<String, String> setToppings(Map<String, String> map) {
		
		//add key "bread" and value "butter", if its not in map
		if (!map.containsKey("bread")) {
			map.put("bread", "butter");
		}
		
		//if key is "ice cream", set the value to "cherry"
		if (map.containsKey("ice cream")) {
			map.replace("ice cream", "cherry");
		}
		
		return map;
	}
	
	public static void main(String[] args) {
		
		//removeRange
		//create array of ints
		Integer[] removeRangeArray = {7, 9, 4, 2, 7, 7, 5, 3, 5, 1, 7, 8, 6, 7};
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//add all items from array to arraylist
		list.addAll(Arrays.asList(removeRangeArray));
		
		CollectionsClass.removeRange(list, 5, 7);
		
		//print output
		System.out.println("removeRange: " + list);
		System.out.println();
		
		//addStars
		//create array of strings
		String[] addStar = {"the", "quick", "brown", "fox"};
		
		//add all items in array to arraylist
		ArrayList<String> sList = new ArrayList<String>();
		sList.addAll(Arrays.asList(addStar));
		
		CollectionsClass.addStars(sList);
		
		System.out.println("addStars: " + sList);
		System.out.println();
		
		//wordCount
		String[] strings = {"a", "b", "a", "c", "b"};
		Map<String, Integer> ret = CollectionsClass.wordCount(strings);
		
		System.out.println("wordCount: " + ret);
		System.out.println();
		
		//countUniqueWords
		String[] countUniqueWordsArray = {"hello", "izzy", "and", 
				"Elise", "and", "Louise", "and", "Hello"};
		
		System.out.println("countUniqueWords: "
				+ CollectionsClass.countUniqueWords(countUniqueWordsArray));
		System.out.println();
		
		//setToppings
		//create hashmap with food items and toppings
		Map<String, String> food = new HashMap<String, String>();
		food.put("ice cream", "peanuts");
		
		Map<String, String> m = CollectionsClass.setToppings(food);
		System.out.println("setToppings: " + m);
		System.out.println();
		
	}

}
