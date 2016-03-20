package io.makototheknight.jormungandr.scheduler;


import io.makototheknight.jormungandr.database.model.Question;
import io.makototheknight.jormungandr.database.model.Tag;
import io.makototheknight.jormungandr.database.repository.QuestionRepository;
import io.makototheknight.jormungandr.database.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class ApiActionScheduler {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Scheduled(fixedRate = 3000000)
    public void doStuffWithArray() throws SQLException {

        Tag tag = new Tag();
        Question question = new Question();
        question.setQuestionId(1L);
        questionRepository.save(question);
        tag.setQuestionId(question.getQuestionId());
        tag.setTags(new String[] {"foo", "bar", "baz", "bing"});
        tagRepository.save(tag);
        System.out.println(tag);
        System.out.println(tagRepository.findAll());

//        String sql = "INSERT INTO tags VALUES (?, ?)";
//        String sql2 = "INSERT INTO questions VALUES (?, null, null, null)";
//
//        int questionInsert = jdbcTemplate.update(con -> {
//            PreparedStatement ps = con.prepareStatement(sql2);
//            ps.setInt(1, 123);
//
//            return ps;
//        });
//
//        int update = jdbcTemplate.update(con -> {
//            PreparedStatement ps = con.prepareStatement(sql);
//            Array tags = con.createArrayOf("varchar", new String[]{"foo", "bar", "baz"});
//            ps.setInt(1, 123);
//            ps.setArray(2, tags);
//            return ps;
//        });
    }
}
