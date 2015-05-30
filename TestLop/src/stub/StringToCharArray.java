package stub;

import java.util.Arrays;

public class StringToCharArray {

	public static void main(String[] args) {

		String string = "JavaCodeGeeks";

		char[] charArray = string.toCharArray();

		System.out.println("String is:" + string + " Character Array : "
				+ Arrays.toString(charArray));
	}
}