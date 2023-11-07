package string;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitStringTest {

	@Test
	@DisplayName("1,2를 ,로 split하면 1과 2로 나눠진다.")
	void whenSplitStringByComma_thenSplitString() {
		String input = "1,2";
		String[] output = input.split(",");
		
		assertThat(output).containsExactly("1", "2");
	}

	@Test
	@DisplayName("1을 ,로 split하면 1만 있는 배열이 반환된다.")
	void whenSplitStringByComma_givenOnlyOne_thenReturnOne() {
		String input = "1";
		String[] output = input.split(",");

		assertThat(output).containsExactly("1");
	}
}
