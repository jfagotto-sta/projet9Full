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

	//@Autowired
	//static INoteRepository noterepo;
	public static void main(String[] args) {
		SpringApplication.run(NoteApplication.class, args);

//		Note note = new Note();
//		note.setIdNote(1);
//		note.setIdPatient(1);
//		note.setMessage("bidule");
//		note.setMessageDate(new Date());
//		noterepo.save(note);

//		ConnectionString connectionString = new ConnectionString("mongodb+srv://root:<password>@projet9note.tvdrlgl.mongodb.net/?retryWrites=true&w=majority");
//		MongoClientSettings settings = MongoClientSettings.builder()
//				.applyConnectionString(connectionString)
//				.serverApi(ServerApi.builder()
//						.version(ServerApiVersion.V1)
//						.build())
//				.build();
//		MongoClient mongoClient = MongoClients.create(settings);
//		MongoDatabase database = mongoClient.getDatabase("test");

	}

}
