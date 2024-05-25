package in.ashokit.binding;

public class Options {
	private Integer optionId;
	private String optionValue;
	private Integer optionNumber;
	private Questions question;

	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public Integer getOptionNumber() {
		return optionNumber;
	}

	public void setOptionNumber(Integer optionNumber) {
		this.optionNumber = optionNumber;
	}

	public Questions getQuestion() {
		return question;
	}

	public void setQuestion(Questions question) {
		this.question = question;
	}
}
