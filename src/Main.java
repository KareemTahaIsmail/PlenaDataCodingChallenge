import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter your string: ");

		String str = scan.next();

		printDuplicates(str);
		
		scan.close();

	}

	static void printDuplicates(String str) {
		char[] letters = str.toCharArray();

		Map<Character, Integer> charMap = new HashMap<Character, Integer>();

		for (Character c : letters) {
			char a = Character.toUpperCase(c);
			if (charMap.containsKey(c) || charMap.containsKey(a)) {
				charMap.put(a, charMap.get(a) + 1);
			} else {
				charMap.put(c, 1);
			}
		}

		for (Map.Entry<Character, Integer> set : charMap.entrySet()) {

			if (set.getValue() == 1) {
				System.out.println("First unrepeated letter is: " + set.getKey());
				break;
			}
		}

		LinkedHashMap<Character, Integer> sortedMap = new LinkedHashMap<>();
		 
		charMap.entrySet()
		    .stream()
		    .sorted(Map.Entry.comparingByValue())
		    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		
		for (Map.Entry<Character, Integer> set : sortedMap.entrySet()) {

			if (set.getValue() > 1 && set.getKey()==str.charAt(0)) {
				System.out.print(set.getKey());
				for(int i = 0; i<set.getValue()-1; i++) {
					System.out.print(Character.toLowerCase(set.getKey()));
				}
			}
			else {
				System.out.print(set.getKey());
			}
		}
		 

	}
}
