package junit.tutorial;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
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
		int expected = 12;
		int actual = calc.multiply(5, 7);
		assertThat(actual, is(expected));
	}
}
