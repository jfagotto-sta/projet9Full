package com.projet9.Note;

import com.mongodb.*;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.projet9.Note.Domain.Note;
import com.projet9.Note.Repository.INoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Date;

@SpringBootApplication
@EnableMongoRepositories
public class NoteApplication {


	public static void main(String[] args) {
		SpringApplication.run(NoteApplication.class, args);


	}

}
