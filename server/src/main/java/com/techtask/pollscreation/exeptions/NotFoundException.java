package com.techtask.pollscreation.exeptions;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException {
	public NotFoundException(String message) {
		super(message);
	}
}
