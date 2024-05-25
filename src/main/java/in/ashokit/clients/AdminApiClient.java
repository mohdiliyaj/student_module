package in.ashokit.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.binding.Categories;
import in.ashokit.binding.CategoriesResponse;
import in.ashokit.binding.Questions;
import in.ashokit.binding.Subjects;

@FeignClient(name = "ADMIN-MODULE")
public interface AdminApiClient {

	@GetMapping("/admin/getSubjects")
	public ResponseEntity<List<Subjects>> getSubjects();

	@GetMapping("/admin/getCategories/{subjectId}")
	public ResponseEntity<List<Categories>> getCategories(@PathVariable("subjectId") Integer subjectId);
	
	@GetMapping("/admin/getAllCategories")
	public ResponseEntity<CategoriesResponse> getAllCategories(
			@RequestParam(value = "page", defaultValue = "1") int pageNo,
			@RequestParam(value = "size", defaultValue = "7") int pageSize,
			@RequestParam(value = "categoryName", required = false) String categoryName,
			@RequestParam(value = "subjectName", required = false) String subjectName);

	@GetMapping("/admin/getQuestions/{categoryId}")
	public ResponseEntity<List<Questions>> getAllQuestions(@PathVariable("categoryId") Integer categoryId);
}
