package controller;

public enum PICommand {

	CALCULATE("calculate") {
		@Override
		public String toString() {
			return "calculate";
		}
	},
	CLEAR("clear") {
		@Override
		public String toString() {
			return "clear";
		}
	};

	private String text;

	PICommand(String text) {
		this.text = text;
	}

	public static PICommand fromText(String text) {
		for (PICommand command : PICommand.values()) {
			if (command.text.equals(text))
				return command;
		}
		throw new IllegalArgumentException("no found with such text " + text);
	}

}
