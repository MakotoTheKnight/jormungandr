package io.makototheknight.jormungandr.database.repository;


import io.makototheknight.jormungandr.database.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
