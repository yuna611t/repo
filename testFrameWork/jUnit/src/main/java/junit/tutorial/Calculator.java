package junit.tutorial;

import java.util.Calendar;
import java.util.Date;

public class Calculator {
	public int multiply(int x, int y) {
		return x * y;
	}

	public float divide(int x, int y) {
		if (y == 0)
			throw new IllegalArgumentException("divided by zero.");
		return (float) x / (float) y;
	}

	public Date minusDate(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -day);
		return cal.getTime();
	}

}
