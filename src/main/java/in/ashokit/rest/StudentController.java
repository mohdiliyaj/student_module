package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.Exception.ExamNotSubExcep;
import in.ashokit.Exception.ResultNotFound;
import in.ashokit.binding.CategoriesResponse;
import in.ashokit.binding.DashboardResponse;
import in.ashokit.binding.Questions;
import in.ashokit.binding.StudentExamResponse;
import in.ashokit.binding.Subjects;
import in.ashokit.clients.AdminApiClient;
import in.ashokit.entity.StudentResponse;
import in.ashokit.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@Autowired
	private AdminApiClient adminClient;

	@GetMapping("/getAllSubjects")
	public ResponseEntity<List<Subjects>> getSubjects() {
		ResponseEntity<List<Subjects>> subjects = adminClient.getSubjects();
		return subjects;
	}

	@GetMapping("/getAllExams")
	public ResponseEntity<CategoriesResponse> getCategories(@RequestParam(value="page", defaultValue = "1") Integer page,
			@RequestParam(value = "subjectName", required = false) String subjectName,
			@RequestParam(value = "categoryName", required = false) String categoryName) {
		ResponseEntity<CategoriesResponse> allCategories = adminClient.getAllCategories(page, 5, categoryName, subjectName);
		return allCategories;
	}
	
	@GetMapping("/getAllQuestions/{examId}")
	public ResponseEntity<List<Questions>> getAllQuestions(@PathVariable("examId") Integer examId){
		ResponseEntity<List<Questions>> allQuestions = adminClient.getAllQuestions(examId);
		return allQuestions;
	}
	
	@PostMapping("/submitExam")
	public ResponseEntity<Integer> submitExam(@RequestBody StudentExamResponse response){
		if(response.getUserId() != null && response.getCategoryId() != null) {
			Integer validateExam = studentService.validateExam(response);
			if(validateExam != null) {
				return new ResponseEntity<>(validateExam, HttpStatus.CREATED);
			}
			throw new ExamNotSubExcep("Exam is not submitted to bad request from the client");
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getResult/{examId}")
	public ResponseEntity<StudentResponse> getExamResult(@PathVariable("examId") Integer responseId){
		StudentResponse examResult = studentService.getExamResult(responseId);
		if(examResult != null) {
			return new ResponseEntity<>(examResult, HttpStatus.OK);
		}
		throw new ResultNotFound("result not found");
	}
	
	@GetMapping("/getResults/{userId}")
	public ResponseEntity<List<StudentResponse>> getStudentResult(@PathVariable("userId") Integer userId){
		if(userId != null) {
			List<StudentResponse> allResults = studentService.getAllResults(userId);
			return new ResponseEntity<>(allResults, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/dashboard/{userId}")
	public ResponseEntity<DashboardResponse> buildDashboard(@PathVariable("userId") Integer userId){
		if(userId != null) {
			DashboardResponse dashboardResponse = studentService.getDashboardResponse(userId);
			return new ResponseEntity<>(dashboardResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		
	}
	
}
