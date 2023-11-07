package calculator;

public class StringCalculator {

	// private method test 왜 때문에 지양해야함?

	public void calculator() {
		StringCalculator calculator = new StringCalculator();
		String input = calculator.input();

		String[] split = calculator.splitByDelimiter(input, calculator.getCustomDelimiter(input));
		calculator.validateSplitString(split);

		System.out.println(calculator.sum(split));
	}

	public int sum(String[] split) {
		int sum = 0;
		for (String s : split) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}

	public String[] splitByDelimiter(String input, Character customDelimiter) {
		String delimiters = ",|:|" + customDelimiter;
		return input.split(delimiters);
	}

	public String deleteCustomDelimiter(String input) {
		return input.substring(4);
	}

	public void validateSplitString(String[] split) {
		for (int i = 0; i < split.length; i++) {
			int num;
			try {
				num = Integer.parseInt(split[i]);
			} catch (NumberFormatException e) {
				throw new RuntimeException("숫자가 아닙니다.");
			}
			if (num < 0) {
				throw new RuntimeException("음수입니다.");
			}
		}
	}

	public Character getCustomDelimiter(String input) {
		if (input.startsWith("//") && input.charAt(3) == '\n') {
			Character delimiter = input.charAt(2);
			input = deleteCustomDelimiter(input);
			return delimiter;
		} else if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
			return null;
		} else {
			throw new RuntimeException("커스텀 구분자 양식에 맞지 않습니다.");
		}
	}

	public String input() {
		FastReader reader = new FastReader();
		System.out.println("문자열을 입력하세요.");
		String input = reader.next();
		return input;
	}
}
