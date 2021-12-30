package com.polls.exeptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionsHandler {

	private static Logger LOG = LoggerFactory.getLogger(GlobalExceptionsHandler.class);

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	String processingConstraintExceptions(ConstraintViolationException e, HttpServletRequest request) {
		return processingException(e);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	String processingMethodArgumentExceptions(MethodArgumentNotValidException e, HttpServletRequest request) {
		return processingException(e);
	}

	@ExceptionHandler(InvalidInputException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	String processingInvalidInputExceptions(InvalidInputException e) {
		return processingException(e);
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	String processingNotFoundExceptions(NotFoundException e) {
		return processingException(e);
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	String processingOtherExceptions(RuntimeException e) {
		return processingException(e);
	}
	
	private String processingException(Exception e) {
		LOG.error(e.getMessage());
		return e.getLocalizedMessage();
	}
}
