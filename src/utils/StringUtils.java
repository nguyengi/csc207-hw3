package utils;

//import java.math.BigInteger;
import java.util.ArrayList;

public class StringUtils {
	public static String[] splitAt(String str, char c) {
		int begin = 0, end = 0;
		ArrayList<String> arr = new ArrayList<>();
		while ((end = str.indexOf(c, begin)) >= 0) {
			arr.add(str.substring(begin, end));
			begin = end + 1;
		} // while there are still commas left
		arr.add(str.substring(begin, str.length()));
		String[] a = new String[arr.size()];
		return arr.toArray(a);
	} // splitAt(String, char)

	public static String[] splitCSV(String str1) {
		StringBuilder str = new StringBuilder(str1);
		int[] quotes = findQuotes(str, 0);
		int begin = 0, end = 0, search = 0;
		ArrayList<String> arr = new ArrayList<>();
		while (end < str.length()) {
			end = str.indexOf(",", search);
			if (end < 0)
				end = str.length();
			if (end < quotes[0] || end == str.length() || quotes[0] < 0) {
				if (str.charAt(begin) == '\"' && str.charAt(end - 1) == '\"') {
					arr.add(str.substring(begin + 1, end - 1));
				} // if quotes need to be removed
				else {
					arr.add(str.substring(begin, end));
				} // if there is no quote that need to be removed
				begin = end + 1;
			} // if comma found is valid and another string should be added
			else if (quotes[0] >= 0 && quotes[1] >= 0 && end > quotes[1]) {
				quotes = findQuotes(str, end);
				continue;
			} // if search moves out of comma zone and another quote pair is
				// needed
			search = end + 1;
		} // while there are still commas left
		String[] a = new String[arr.size()];
		return arr.toArray(a);
	} // splitCSV(String)

	/*
	 * @param String, int
	 * 
	 * @return int[] Helper method that finds a pair of valid quotes
	 */
	public static int[] findQuotes(StringBuilder str, int begin) {
		int[] quotes = { -1, -1 };
		int i = str.indexOf("\"", begin);
		if (i >= 0
				&& (i == begin || str.charAt(i - 1) == ','
						|| i == str.length() - 1 || str.charAt(i + 1) != '\"')) {
			quotes[0] = i;
			while ((i = str.indexOf("\"", i + 1)) >= 0) {
				if (i == str.length() - 1 || str.charAt(i + 1) == ',') {
					quotes[1] = i;
					break;
				} // if the second quote found is valid
				else if (str.charAt(i + 1) == '\"') {
					str.delete(i, i + 1);
					i--;
				} // if the second quote found is next to another quote
				i++;
			} // while there are still valid quotes
		} // if the first quote found is valid
		else if (i != -1) {
			return findQuotes(str, i);
		} // if the first quote found is invalid
		return quotes;
	} // findQuotes (String, int)

	public static String deLeet(String str) {
		String[] arr1 = { "a", "b", "e", "l", "n", "o", "t" };
		String[] arr2 = { "@", "|3", "3", "1", "|\\|", "0", "+" };
		for (int i = 0; i < arr1.length; i++) {
			str = str.replace(arr2[i], arr1[i]);
		} // iteration through list of characters
		return str;
	} // deLeet (String)

	public static String nameGame(String str) {
		String regex = "(?i)^gi|^ch|^gh|^ng|^ph|^qu|^rh|^sc|^sh|^th|^wh|^wr|^zh|^[bcdfghijklmnpqrstvwxyz]";
		return str + "!\n" + str + ", " + str + " bo "
				+ str.replaceAll(regex, "B") + " Bonana fanna fo "
				+ str.replaceAll(regex, "F") + "\nFee fy mo "
				+ str.replaceAll(regex, "M") + ", " + str + "!";
	} // nameGame (String)

}
