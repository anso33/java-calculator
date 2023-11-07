package string;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SubstringStringTest {

	@Test
	@DisplayName("(1,2)값이 주어졌을 때 ()를 제거하고 1,2를 반환한다.")
	void whenSubstringStringByParentheses_thenRemoveParentheses() {
		String str = "(1,2)";
		String substring = str.substring(1, str.length() - 1);
		assertThat(substring).isEqualTo("1,2");
	}
}
