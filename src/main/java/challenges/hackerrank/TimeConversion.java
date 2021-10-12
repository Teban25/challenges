package challenges.hackerrank;

/**
 * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
 * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock. -
 * 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock. Sample Input 0
 * -> 07:05:45PM Sample Output 0 -> 19:05:45
 */
public class TimeConversion {

	public static void main(String[] args) {
		System.out.println(timeConversion("01:00:00AM"));
	}

	public static String timeConversion(String s) {
		String militaryTime = "";
		String[] dateInput = s.split(":");
		String hour = dateInput[0];
		String minutes = dateInput[1];
		String seconds = dateInput[2].substring(0, 2);
		String period = dateInput[2].substring(2);
		if (period.equals("AM")) {
			String militaryHour = hour.equals("12") ? "00" : hour;
			militaryTime = String.format("%s:%s:%s", militaryHour, minutes, seconds);
		} else {
			int militaryHour = hour.equals("12") ? 12 : Integer.valueOf(hour) + 12;
			militaryTime = String.format("%s:%s:%s", String.valueOf(militaryHour), minutes, seconds);
		}
		return militaryTime;
	}
}
