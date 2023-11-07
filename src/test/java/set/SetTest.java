package set;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("set의 size()메서드를 통해 set의 크기를 알 수 있다.")
	void whenUseSize_thenGetRealSizeOfSet() {
		int expected = 3;
		assertThat(numbers.size()).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
		// @DisplayName("set의 contains()메서드를 통해 set에 특정 원소가 포함되어 있는지 알 수 있다.")
	void whenUseContains_thenGetTrueOrFalse(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
		// @DisplayName("set의 contains()메서드를 통해 set에 특정 원소가 포함되어 있음을 올바르게 반환하는지 알 수 있다.")
	void whenUseContains_thenGetTrueOrFalse(int number, boolean expected) {
		assertThat(numbers.contains(number)).isEqualTo(expected);
	}
}
