package com.booksearchms.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class BookSearchController {
	
	Logger logger = LoggerFactory.getLogger(BookSearchController.class);
	
	@Value("${server.port}")
	String myport;
	
	@Value("${jlc.search.message}")
	String message;
	
	@Value("${jlc.search.welcome}")
	String welcome;
	
	@GetMapping("/allbooks")
	public List<String> getAllBooks(){
		logger.info("BookSearchController -- getAllBooks()");
		logger.info("---myport---"+myport);
		logger.info("---message---"+message);
		
		List<String> booksList = new ArrayList<String>();
		booksList.add("SpringBoot");
		booksList.add("Angular");
		booksList.add("ReactJS");
		booksList.add("NodeJS");
		booksList.add("MongoDB");
		booksList.add(myport);
		booksList.add(message);
		booksList.add(welcome);
		return booksList;
	}
}
