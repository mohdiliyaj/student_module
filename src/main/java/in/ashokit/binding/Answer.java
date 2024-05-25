package in.ashokit.binding;

public class Answer {
	private Integer answerId;
	private Integer correctAnswer;
	private Questions question;

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public Integer getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Integer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Questions getQuestion() {
		return question;
	}

	public void setQuestion(Questions question) {
		this.question = question;
	}
}
