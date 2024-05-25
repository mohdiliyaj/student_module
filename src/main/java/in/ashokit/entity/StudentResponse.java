package in.ashokit.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_response")
public class StudentResponse {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer responseId;
	
    private Integer scoredMarks;
    private LocalDateTime submittedTime;
    private String examStatus;
    private Double percentage;
    private Integer user;
    private Integer category;
    
    @Column(name = "responses", columnDefinition = "json")
    private String response;

	public Integer getResponseId() {
		return responseId;
	}

	public void setResponseId(Integer responseId) {
		this.responseId = responseId;
	}

	public Integer getScoredMarks() {
		return scoredMarks;
	}

	public void setScoredMarks(Integer scoredMarks) {
		this.scoredMarks = scoredMarks;
	}

	public LocalDateTime getSubmittedTime() {
		return submittedTime;
	}

	public void setSubmittedTime(LocalDateTime submittedTime) {
		this.submittedTime = submittedTime;
	}

	public String getExamStatus() {
		return examStatus;
	}

	public void setExamStatus(String examStatus) {
		this.examStatus = examStatus;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
