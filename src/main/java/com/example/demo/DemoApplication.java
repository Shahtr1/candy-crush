package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.demo.controller.DataController;

@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	DataController dataController;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
	    dataController.processApiData();
	}

}
