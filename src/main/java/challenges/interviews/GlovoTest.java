package challenges.interviews;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class GlovoTest {
	
	public static Boolean checkValidString(String stringToEvaluate) {
		Stack<Character> characters = new Stack<>();
		
		for(char element : stringToEvaluate.toCharArray()) {
			
			if(element == '(' || element == '{' ||  element == '[') {
				characters.push(element);
			} else {
				if (characters.empty()) {
					return false;
				} else {
					char lastChar = characters.peek();
					if((element == ')' && lastChar == '(') || (element == ']' && lastChar == '[') || (element == '}' && lastChar == '{')) {
						characters.pop();
					} else {
						return false;
					}
				}
			}
		}
		
		if (characters.isEmpty()) {
			return true;
		} else {
			return false;
		}
	} 
	
	/*
	Examples:
	1 - "()" -> true

	2 - "()[]{}" -> true

	3 - "(]" -> false

	4 - ")(" -> false

	5 - "([)]" -> false

	6 - "{[]}" -> true

	7 - ")" -> false

	8 - "([]" -> false

	9 - "{" -> false

	10 - "([)])" -> false

	11 - "(((((((((())))))))))" -> true

	12 - "" -> true
	*/
	@Test
	public void testThatCheckIfIsValidString() {
		List<String> testCases = Arrays.asList("()", "()[]{}", "(]", ")(", "([)]", "{[]}", ")", "([]", "{", "([)])", "(((((((((())))))))))", "");
		List<Boolean> expectedValues = Arrays.asList(true, true, false, false, false, true, false, false, false, false, true, true);
		for (int i = 0; i < testCases.size(); i++) {
			
			boolean validString = checkValidString(testCases.get(i));
			System.out.println(testCases.get(i));
			System.out.println("expected = " + expectedValues.get(i) + "actual= " + validString);
			assertEquals(expectedValues.get(i), validString);
		}
	}

}
