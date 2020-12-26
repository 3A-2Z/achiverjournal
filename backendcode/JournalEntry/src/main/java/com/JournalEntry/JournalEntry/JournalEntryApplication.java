package com.JournalEntry.JournalEntry;

import com.JournalEntry.JournalEntry.api.JournalEntryController;
import com.JournalEntry.JournalEntry.dao.JournalEntryDao;
import com.JournalEntry.JournalEntry.dao.JournalEntryDataAccessService;
import com.JournalEntry.JournalEntry.datasource.PostgresDatasource;
import com.JournalEntry.JournalEntry.service.JournalEntryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  
public class JournalEntryApplication { 
 
	public static void main(String[] args) {   
		SpringApplication.run(JournalEntryApplication.class, args);   
	}

}   
  