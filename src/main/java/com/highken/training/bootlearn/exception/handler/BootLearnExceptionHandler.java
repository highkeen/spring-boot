package com.highken.training.bootlearn.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.highken.training.bootlearn.controller.model.ResponseMessage;
import com.highken.training.bootlearn.exception.HighkeenBootLearnException;
import com.highken.training.bootlearn.exception.HighkeenBootLearnNotFoundException;

@ControllerAdvice
@RestController
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BootLearnExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Map<Class<? extends HighkeenBootLearnException>,HttpStatus> HTTP_STATUS_MAP;
	static{
		HTTP_STATUS_MAP=new HashMap<>();
		HTTP_STATUS_MAP.put(HighkeenBootLearnException.class, HttpStatus.BAD_REQUEST);
		HTTP_STATUS_MAP.put(HighkeenBootLearnNotFoundException.class, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(HighkeenBootLearnException.class)
	public final ResponseEntity<ResponseMessage> handleInternalErrorException(HighkeenBootLearnException ex, WebRequest request) {
		ResponseMessage errorDetails = ResponseMessage.builder().message(ex.getMessage()).code(ex.getErrorCode()).build();
		return new ResponseEntity<>(errorDetails, HTTP_STATUS_MAP.getOrDefault(ex.getClass(), HttpStatus.BAD_REQUEST));
	}

}
