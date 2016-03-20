package io.makototheknight.jormungandr.database.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;

@Component
@Converter(autoApply = true)
public class StringArrayConverter implements AttributeConverter<String[], Array> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StringArrayConverter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Array convertToDatabaseColumn(String[] attribute) {
        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            return connection.createArrayOf("varchar", attribute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String[] convertToEntityAttribute(Array dbData) {
        return new String[0];
    }
}
