package io.makototheknight.jormungandr.database.repository;

import io.makototheknight.jormungandr.database.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

}
