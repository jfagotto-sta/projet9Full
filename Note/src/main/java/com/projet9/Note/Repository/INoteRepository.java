package com.projet9.Note.Repository;


import com.projet9.Note.Domain.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INoteRepository extends MongoRepository<Note,Long> {


    List<Note> findByIdPatient(long id);
}
