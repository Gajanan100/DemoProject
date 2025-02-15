package com.example.demo.exception.globalException;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.AutherNotFoundException;
import com.example.demo.exception.BookCategoryNotFoundException;
import com.example.demo.exception.BookCopiesNotFoundException;
import com.example.demo.exception.BookNotExistException;
import com.example.demo.exception.BookReviewNotFoundException;
import com.example.demo.exception.BranchNotFoundException;
import com.example.demo.exception.EmpRoleNotFoundException;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.exception.LibraryNotFoundException;
import com.example.demo.exception.TransHistoryNotFoundException;
import com.example.demo.exception.UserMemberShipNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.exception.UserAllRedyPresent;

import io.jsonwebtoken.ExpiredJwtException;

@RestControllerAdvice
public class GlobalExceptionHandler { 

	private ProblemDetail problemDetail;

	@ExceptionHandler({ AutherNotFoundException.class })
	public List<ProblemDetail> handleEmpNotFoundException(AutherNotFoundException employeeException) {
		problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				employeeException.getMessage());
		problemDetail.setProperty("Error Code", 1);
		return List.of(problemDetail);
	}

	@ExceptionHandler({ BookNotExistException.class })
	public List<ProblemDetail> handleEmpNotFoundException(BookNotExistException employeeException) {
		problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				employeeException.getMessage());
		problemDetail.setProperty("Error Code", 2);
		return List.of(problemDetail);
	}

	@ExceptionHandler({ EmployeeNotFoundException.class })
	public List<ProblemDetail> handleEmpNotFoundException(EmployeeNotFoundException employeeException) {
		problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				employeeException.getMessage());
		problemDetail.setProperty("Error Code", 3);
		return List.of(problemDetail);
	}

	@ExceptionHandler({ BookCategoryNotFoundException.class })
	public List<ProblemDetail> handleEmpNotFoundException(BookCategoryNotFoundException employeeException) {
		problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				employeeException.getMessage());
		problemDetail.setProperty("Error Code", 4);
		return List.of(problemDetail);
	}

	@ExceptionHandler({ BookReviewNotFoundException.class })
	public List<ProblemDetail> handleEmpNotFoundException(BookReviewNotFoundException employeeException) {
		problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				employeeException.getMessage());
		problemDetail.setProperty("Error Code", 5);
		return List.of(problemDetail);
	}

	@ExceptionHandler({ BookCopiesNotFoundException.class })
	public List<ProblemDetail> handleEmpNotFoundException(BookCopiesNotFoundException employeeException) {
		problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				employeeException.getMessage());
		problemDetail.setProperty("Error Code", 6);
		return List.of(problemDetail);
	}

	@ExceptionHandler({ EmpRoleNotFoundException.class })
	public List<ProblemDetail> handleEmpNotFoundException(EmpRoleNotFoundException employeeException) {
		problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				employeeException.getMessage());
		problemDetail.setProperty("Error Code", 7);
		return List.of(problemDetail);
	}

	@ExceptionHandler({ LibraryNotFoundException.class })
	public List<ProblemDetail> handleEmpNotFoundException(LibraryNotFoundException employeeException) {
		problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				employeeException.getMessage());
		problemDetail.setProperty("Error Code", 8);
		return List.of(problemDetail);
	}

	@ExceptionHandler({ TransHistoryNotFoundException.class })
	public List<ProblemDetail> handleEmpNotFoundException(TransHistoryNotFoundException employeeException) {
		problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				employeeException.getMessage());
		problemDetail.setProperty("Error Code", 9);
		return List.of(problemDetail);
	}

	@ExceptionHandler({ UserMemberShipNotFoundException.class })
	public List<ProblemDetail> handleEmpNotFoundException(UserMemberShipNotFoundException employeeException) {
		problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				employeeException.getMessage());
		problemDetail.setProperty("Error Code", 10);
		return List.of(problemDetail);
	}

	@ExceptionHandler({ UserNotFoundException.class })
	public List<ProblemDetail> handleEmpNotFoundException(UserNotFoundException employeeException) {
		problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				employeeException.getMessage());
		problemDetail.setProperty("Error Code", 11);
		return List.of(problemDetail);
	}
	
	@ExceptionHandler({BranchNotFoundException.class})
	public List<ProblemDetail>hendleBranchNotFoundException(BranchNotFoundException branchNotFoundException){
		problemDetail=ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				branchNotFoundException.getMessage());
		problemDetail.setProperty("Error Code", 12);
		return List.of(problemDetail);
		
	}
	@ExceptionHandler({UserAllRedyPresent.class})
	public List<ProblemDetail>UserAllRedyPresent(UserAllRedyPresent userAllRedyPresent){
		problemDetail=ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				userAllRedyPresent.getMessage());
		problemDetail.setProperty("Error Code", 13);
		return List.of(problemDetail);
		
	}

	
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<String> handleExpiredJwtException(ExpiredJwtException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body("Token has expired. Please login again to get a new token.");
    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleGeneralException(Exception ex) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("An error occurred: " + ex.getMessage());
//    }
    

}
