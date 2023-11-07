package string;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CharAtStringTest {
	@Test
	@DisplayName("abc값이 주어졌을 때 0번째 문자를 charAt으로 가져오면 a이다.")
	void whenGetCharAtZero_thenGetA() {
		String str = "abc";
		char charAt = str.charAt(0);
		assertThat(charAt).isEqualTo('a');
	}

	@Test
	@DisplayName("abc값이 주어졌을 때 1번째 문자를 charAt으로 가져오면 b이다.")
	void whenGetCharAtOne_thenGetB() {
		String str = "abc";
		char charAt = str.charAt(1);
		assertThat(charAt).isEqualTo('b');
	}

	@Test
	@DisplayName("abc값이 주어졌을 때 2번째 문자를 charAt으로 가져오면 c이다.")
	void whenGetCharAtTwo_thenGetC() {
		String str = "abc";
		char charAt = str.charAt(2);
		assertThat(charAt).isEqualTo('c');
	}

	@Test
	@DisplayName("abc값이 주어졌을 때 3번째 문자를 charAt으로 가져오면 StringIndexOutOfBoundsException이 발생한다.")
	void whenGetCharAtThree_thenThrowStringIndexOutOfBoundsException() {
		String str = "abc";
		assertThatThrownBy(() -> {
			str.charAt(3);
		}).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
		// TODO: hasMessageContaining("") 안에 들어가는 message가 뭔지 어케 알음??
	}

}
