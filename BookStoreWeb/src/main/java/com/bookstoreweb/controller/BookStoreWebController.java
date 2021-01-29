package com.bookstoreweb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstoreweb.proxy.BookSearchProxy;

@RefreshScope
@RestController
public class BookStoreWebController {
	
	Logger logger = LoggerFactory.getLogger(BookStoreWebController.class);
	
	@Value("${server.port}")
	String myport;
	
	@Value("${jlc.store.message}")
	String message;
	
	@Value("${jlc.store.welcome}")
	String welcome;
	
	@Autowired
	private BookSearchProxy bookSearchProxy;
	
	@GetMapping("/mybooks")
	public List<String> getMyBooks(){
		logger.info("BookStoreWebController --getMyBooks()");
		logger.info("---myport---"+myport);
		logger.info("---message---"+message);
		
		List<String> booksList = bookSearchProxy.getAllBooks();
		booksList.add(myport);
		booksList.add(message);
		booksList.add(welcome);
		return booksList;
	}
}
