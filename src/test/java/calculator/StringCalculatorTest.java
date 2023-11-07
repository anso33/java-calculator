package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@Test
	@DisplayName("//{구분자}/n으로 양식에 맞게 커스텀 구분자를 넣으면 커스텀 구분자만 잘 가져온다.")
	void getCustomDelimiter() {
		// given
		final StringCalculator calculator = new StringCalculator();

		// when
		String input = "//;\n1;2;3";
		Character expected = ';';

		// then
		Character output = calculator.getCustomDelimiter(input);
		assertThat(output).isEqualTo(expected);
	}

	@Test
	@DisplayName("//{구분자}/n으로 양식에 맞게 커스텀 구분자를 넣으면 커스텀 구분자만 잘 가져온다.2")
	void getCustomDelimiter2() {
		// given
		final StringCalculator calculator = new StringCalculator();

		// when
		String input = "//+\n1+2+3";
		Character expected = '+';

		// then
		Character output = calculator.getCustomDelimiter(input);
		assertThat(output).isEqualTo(expected);
	}

	@Test
	@DisplayName("양식에 맞지 않게 커스텀 구분자를 넣으면 RuntimeException을 발생시킨다.")
	void getCustomDelimiter_whenWrongDelimiter_thenThrowRuntimeException() {
		// given
		final StringCalculator calculator = new StringCalculator();

		// when
		String input = "//;1;2;3";

		// then
		assertThatThrownBy(() -> {
			calculator.getCustomDelimiter(input);
		}).isInstanceOf(RuntimeException.class).hasMessageContaining("커스텀 구분자 양식에 맞지 않습니다.");
	}

	@Test
	@DisplayName("양식에 맞지 않게 커스텀 구분자를 넣으면 RuntimeException을 발생시킨다.2")
	void getCustomDelimiter_whenWrongDelimiter_thenThrowRuntimeException2() {
		// given
		final StringCalculator calculator = new StringCalculator();

		// when
		String input = "//+/n1;2;3";

		// then
		assertThatThrownBy(() -> {
			calculator.getCustomDelimiter(input);
		}).isInstanceOf(RuntimeException.class).hasMessageContaining("커스텀 구분자 양식에 맞지 않습니다.");
	}

	@Test
	@DisplayName("커스텀 구분자를 넣지 않으면 null을 반환한다.")
	void getCustomDelimiter_whenNoDelimiter_thenReturnNull() {
		// given
		final StringCalculator calculator = new StringCalculator();

		// when
		String input = "1,2,3";

		// then
		Character output = calculator.getCustomDelimiter(input);

		assertThat(output).isNull();
	}

	@Test
	@DisplayName("기본적인 구분자들로 이루어진 문자열을 split하면 숫자들로만 이루어진 String배열을 반환한다.")
	void splitByDelimiter() {
		// given
		final StringCalculator calculator = new StringCalculator();

		// when
		String input = "1,2:3";
		String[] expected = {"1", "2", "3"};

		// then
		String[] output = calculator.splitByDelimiter(input, null);
		assertThat(output).isEqualTo(expected);
	}

	@Test
	@DisplayName("기본적인 구분자들과 커스텀 구분자로 이루어진 문자열을 split하면 숫자들로만 이루어진 String배열을 반환한다.")
	void splitByDelimiter_whenCustomDelimiter_thenReturnStringArray() {
		// given
		final StringCalculator calculator = new StringCalculator();

		// when
		String input = "1!2:3";
		Character inputCustomDelimiter = '!';
		String[] expected = {"1", "2", "3"};

		// then
		String[] output = calculator.splitByDelimiter(input, inputCustomDelimiter);
		assertThat(output).isEqualTo(expected);
	}

	@Test
	@DisplayName("커스텀 구분자를 표현하기 위한 양식을 제거한다.")
	void deleteCustomDelimiter() {
		// given
		final StringCalculator calculator = new StringCalculator();

		// when
		String input = "//;\n1;2;3";
		String expected = "1;2;3";

		// then
		String output = calculator.deleteCustomDelimiter(input);
		assertThat(output).isEqualTo(expected);
	}

	@Test
	@DisplayName("String배열에 대해서 음수이면 RuntimeException을 발생시킨다.")
	void validateSplitString_givenNagative_thenThrowRuntimeException() {
		// given
		final StringCalculator calculator = new StringCalculator();

		// when
		String[] input = {"1", "-2", "3"};

		// then
		assertThatThrownBy(() -> {
			calculator.validateSplitString(input);
		}).isInstanceOf(RuntimeException.class).hasMessageContaining("음수입니다.");
	}

	@Test
	@DisplayName("String배열에 대해서 숫자가 아니면 RuntimeException을 발생시킨다.")
	void validateSplitString_givenNoNumber_thenThrowException() {
		// given
		final StringCalculator calculator = new StringCalculator();

		// when
		String[] input = {"1", "r", "3"};

		// then
		assertThatThrownBy(() -> {
			calculator.validateSplitString(input);
		}).isInstanceOf(RuntimeException.class).hasMessageContaining("숫자가 아닙니다.");
	}

	@Test
	@DisplayName("String배열에 대해서 integer로 더하여 총합을 반환한다.")
	void sum() {
		// given
		final StringCalculator calculator = new StringCalculator();

		// when
		String[] input = {"1", "2", "3"};

		// then
		int output = calculator.sum(input);
		int expected = 6;

		assertThat(output).isEqualTo(expected);
	}
}