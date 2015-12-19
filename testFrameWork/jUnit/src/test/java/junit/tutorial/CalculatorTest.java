package junit.tutorial;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static junit.tutorial.custommatcher.IsDate.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void multiplyで3と4の乗算結果を取得できる() {
		Calculator calc = new Calculator();
		int expected = 12;
		int actual = calc.multiply(3, 4);
		assertThat(actual, is(expected));
	}

	@Test
	public void multyplyで5と7の乗算結果を取得できる() {
		Calculator calc = new Calculator();
		int expected = 35;
		int actual = calc.multiply(5, 7);
		assertThat(actual, is(expected));
	}

	@Test
	public void divideで3と除算結果が取得できる() {
		Calculator calc = new Calculator();
		float expected = 1.5f;
		float actual = calc.divide(3, 2);
		assertThat(actual, is(expected));
	}

	@Test(expected = IllegalArgumentException.class)
	public void divideで5と0の時IllegalArgumentExceptionを創出する() {
		Calculator calc = new Calculator();
		calc.divide(5, 0);
	}

	@Test
	public void minusDateで2015年12月13日と3で2015年12月10日が返却される() {
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 11, 13);
		Date date = cal.getTime();

		Calculator calc = new Calculator();
		Date actual = calc.minusDate(date, 3);

		assertThat(actual, is(dateOf(2015, 12, 10)));
	}
}
