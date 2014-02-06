package utils;

public class StringTest {
	public static void main(String[] args) {
//		printValues(StringUtils.splitAt("a::c", ':'));
//		printValues(StringUtils.splitCSV("a,\"b,\"b\",c"));
//		String str = "33";
//		System.out.println(str.replaceAll("3", "e"));
//		System.out.println(StringUtils.nameGame("Huong"));
		String str = "abc";
		System.out.println(str.indexOf(','));
	}

	public static void printValues(String[] values) {
		System.out.print("{");
		for (int i = 0; i < values.length - 1; i++) {
			System.out.print(values[i] + ", ");
		}
		if (values.length > 0)
			System.out.print(values[values.length - 1]);
		System.out.print("}");
	}
}
