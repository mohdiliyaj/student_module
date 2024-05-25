package in.ashokit.binding;

import java.util.List;

public class StudentExamResponse {
	private Integer userId;
	private Integer categoryId;
	private List<ExamResponse> response;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public List<ExamResponse> getResponse() {
		return response;
	}
	public void setResponse(List<ExamResponse> response) {
		this.response = response;
	}
}
