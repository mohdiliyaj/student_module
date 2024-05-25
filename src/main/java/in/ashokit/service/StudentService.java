package in.ashokit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit.Exception.ExamNotSubExcep;
import in.ashokit.binding.DashboardResponse;
import in.ashokit.binding.ExamResponse;
import in.ashokit.binding.Questions;
import in.ashokit.binding.StudentExamResponse;
import in.ashokit.clients.AdminApiClient;
import in.ashokit.entity.StudentResponse;
import in.ashokit.repo.StudentResponseRepo;

@Service
public class StudentService implements IStudentService {

	private StudentResponseRepo studentResponseRepo;

	private AdminApiClient adminClient;

	public StudentService(StudentResponseRepo studentResponseRepo, AdminApiClient adminClient) {
		this.studentResponseRepo = studentResponseRepo;
		this.adminClient = adminClient;
	}

	@Override
	public Integer validateExam(StudentExamResponse response) {
		ResponseEntity<List<Questions>> allQuestions = adminClient.getAllQuestions(response.getCategoryId());
		if (allQuestions.getStatusCode().is2xxSuccessful()) {
			List<Questions> questions = allQuestions.getBody();
			List<ExamResponse> studentResponse = response.getResponse();
			int marks = 0;
			for (int i = 0; i < questions.size(); i++) {
				for (int j = 0; j < studentResponse.size(); j++) {
					if (questions.get(i).getQuestionId() == studentResponse.get(j).getQuestionId() && questions.get(i)
							.getAnswer().getCorrectAnswer() == studentResponse.get(j).getSelectedOption()) {
						marks++;
					}
				}
			}
			StudentResponse result = new StudentResponse();
			result.setCategory(response.getCategoryId());
			if ((double) (marks / questions.size()) >= 0.70) {
				result.setExamStatus("pass");
			} else {
				result.setExamStatus("fail");
			}
			result.setPercentage((double) marks / questions.size());
			result.setScoredMarks(marks);
			result.setSubmittedTime(LocalDateTime.now());
			result.setUser(response.getUserId());
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				String writeValueAsString = objectMapper.writeValueAsString(response.getResponse());
				result.setResponse(writeValueAsString);
			} catch (Exception e) {
				throw new ExamNotSubExcep("Internal server error");
			}
			StudentResponse save = studentResponseRepo.save(result);
			if (save != null) {
				return save.getResponseId();
			} else {
				return null;
			}
		}
		return null;
	}

	@Override
	public StudentResponse getExamResult(Integer responseId) {
		Optional<StudentResponse> byId = studentResponseRepo.findById(responseId);
		if (byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

	@Override
	public List<StudentResponse> getAllResults(Integer userId) {
		PageRequest of = PageRequest.of(0, 5);
		return studentResponseRepo.findByUserOrderByResponseIdDesc(userId, of).getContent();
	}

	@Override
	public DashboardResponse getDashboardResponse(Integer userId) {
		List<StudentResponse> byUser = studentResponseRepo.findByUser(userId);
		DashboardResponse response = new DashboardResponse();
		if (byUser.size() > 0) {
			response.setTotalAttempts(byUser.size());
			response.setPassedAttempts(byUser.stream().filter(e -> e.getExamStatus().equals("pass")).count());
			response.setFailedAttempts(byUser.stream().filter(e -> e.getExamStatus().equals("fail")).count());
			response.setOverAllPercentage(byUser.stream().mapToDouble(StudentResponse::getPercentage).sum());
		} else {
			response.setTotalAttempts(0);
			response.setPassedAttempts(null);
			response.setFailedAttempts(null);
			response.setOverAllPercentage(0.0);
		}
		return response;
	}

}
