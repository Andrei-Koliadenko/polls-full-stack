package com.polls.controllers.api;

public interface PollApiPath {
	// API for adding
	String ADD_POLL = "/poll/create";
	String ADD_VOTE = "/poll/{id}/vote";
	/************************************************************************/
	// API for getting
	String GET_POLL = "/poll";	
}
