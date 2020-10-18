package com.highken.training.bootlearn.controller.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMessage {

	private String code;
	private String message;
}
