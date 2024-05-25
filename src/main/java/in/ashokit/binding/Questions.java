package in.ashokit.binding;

import java.util.List;

public class Questions {
	private Integer questionId;
	private String questionValue;
	private Categories category;
	private Integer user;
	private Answer answer;
	private List<Options> options;
	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionValue() {
		return questionValue;
	}

	public void setQuestionValue(String questionValue) {
		this.questionValue = questionValue;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}
}
