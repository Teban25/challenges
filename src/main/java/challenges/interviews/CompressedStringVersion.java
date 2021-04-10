package challenges.interviews;

public class CompressedStringVersion {

	public static void main(String[] args) {
		
		String input = "aaabbcdddd";

		int count = 1;

		char last = input.charAt(0);

		StringBuilder output = new StringBuilder();

		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == last) {
				count++;
			} else {
				if (count > 1) {
					output.append("" + count + last);
				} else {
					output.append(last);
				}
				count = 1;
				last = input.charAt(i);
			}
		}
		if (count > 1) {
			output.append("" + count + last);
		} else {
			output.append(last);
		}
		System.out.println(output.toString());
	}
}
