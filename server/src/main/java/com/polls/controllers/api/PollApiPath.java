package com.polls.controllers.api;

public interface PollApiPath {
	// Save API
	String ADD_POLL = "/create";
	String ADD_VOTE = "/vote/{pollId}";

	// Find API
	String GET_POLL = "/{id}";
}
