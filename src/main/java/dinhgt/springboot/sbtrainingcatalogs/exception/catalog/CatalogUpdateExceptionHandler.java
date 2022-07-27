package dinhgt.springboot.sbtrainingcatalogs.exception.catalog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dinhgt.springboot.sbtrainingcatalogs.errors.ErrorResponse;


@RestControllerAdvice
public class CatalogUpdateExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerException(CatalogCreateException error) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setHttpCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(error.getMessage());
		errorResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	}

}
