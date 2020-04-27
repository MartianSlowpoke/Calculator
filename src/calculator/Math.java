package calculator;

public enum Math {

	ZERO("0") {
		@Override
		public String toString() {
			return "0";
		}
	},

	ONE("1") {
		@Override
		public String toString() {
			return "1";
		}
	},
	TWO("2") {
		@Override
		public String toString() {
			return "2";
		}
	},
	THREE("3") {
		@Override
		public String toString() {
			return "3";
		}
	},
	FOUR("4") {
		@Override
		public String toString() {
			return "4";
		}
	},
	FIVE("5") {
		@Override
		public String toString() {
			return "5";
		}
	},
	SIX("6") {
		@Override
		public String toString() {
			return "6";
		}
	},
	SEVEN("7") {
		@Override
		public String toString() {
			return "7";
		}
	},
	EIGHT("8") {
		@Override
		public String toString() {
			return "8";
		}
	},
	NINE("9") {
		@Override
		public String toString() {
			return "9";
		}
	},
	PLUS("+") {
		@Override
		public String toString() {
			return "+";
		}
	},
	MINUS("-") {
		@Override
		public String toString() {
			return "-";
		}
	},
	MULTIPLY("*") {
		@Override
		public String toString() {
			return "*";
		}
	},
	DIVIDE("/") {
		@Override
		public String toString() {
			return "/";
		}
	},
	EQUALS("=") {
		@Override
		public String toString() {
			return "=";
		}
	},
	FLOAT_POINT(".") {
		@Override
		public String toString() {
			return ".";
		}
	},
	CLEAR("C") {
		@Override
		public String toString() {
			return "C";
		}
	};

	private String text;

	Math(String text) {
		this.text = text;
	}

	public static Math fromString(String text) throws IllegalArgumentException {
		for (Math math : Math.values()) {
			if (math.text.equals(text))
				return math;
		}
		throw new IllegalArgumentException("No constant with text " + text + "found");
	}

}
