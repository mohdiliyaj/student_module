package in.ashokit.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.StudentResponse;
import java.util.List;


public interface StudentResponseRepo extends JpaRepository<StudentResponse, Integer>{
	
	public Page<StudentResponse> findByUserOrderByResponseIdDesc(Integer user, Pageable pageable);
	
	public List<StudentResponse> findByUser(Integer userId);
	
}
