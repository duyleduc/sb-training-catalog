package dinhgt.springboot.sbtrainingcatalogs.exception.item;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dinhgt.springboot.sbtrainingcatalogs.errors.ErrorResponse;


@RestControllerAdvice
public class ItemCreateExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerException(ItemCreateException error) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setHttpCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(error.getMessage());
		errorResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	}

}
