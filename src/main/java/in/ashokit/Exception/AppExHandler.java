package in.ashokit.Exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExHandler {
	
	@ExceptionHandler(value = ExamNotSubExcep.class)
	public ResponseEntity<ExInfo> examNotSubEx(ExamNotSubExcep e){
		ExInfo info = new ExInfo();
		info.setExCode("500");
		info.setExMsg(e.getMessage());
		info.setExDate(LocalDate.now());
		return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(value = ResultNotFound.class)
	public ResponseEntity<ExInfo> resultNotFound(ResultNotFound e){
		ExInfo info = new ExInfo();
		info.setExCode("404");
		info.setExMsg(e.getMessage());
		info.setExDate(LocalDate.now());
		return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
	}
	
	
}
