package in.ashokit.service;

import java.util.List;

import in.ashokit.binding.DashboardResponse;
import in.ashokit.binding.StudentExamResponse;
import in.ashokit.entity.StudentResponse;

public interface IStudentService {
	
	public Integer validateExam(StudentExamResponse response);
	
	public StudentResponse getExamResult(Integer responseId);
	
	public List<StudentResponse> getAllResults(Integer userId);
	
	public DashboardResponse getDashboardResponse(Integer userId);
	
}
