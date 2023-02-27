package org.example.dao;

import org.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(Person.class));
    }
    public Person show(int id){
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }
    public void create(Person person){
        jdbcTemplate.update("INSERT INTO users(name,email) VALUES (?,?)", person.getName(),person.getEmail());
    }
    public void update(Person person, int id){
        jdbcTemplate.update("UPDATE users SET name = ? WHERE id = ?", person.getName(), id);
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }
}
