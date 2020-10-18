package com.highken.training.bootlearn.controller.model;

import lombok.Data;

@Data
public class PageRequest {

	/** The page. */
	private int page=0;
	
	/** The size. */
	private int size=10;
}
