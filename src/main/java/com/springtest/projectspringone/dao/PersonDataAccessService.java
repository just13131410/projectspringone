package com.springtest.projectspringone.dao;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.springtest.projectspringone.model.Person;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>();


    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person){
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id){
        final String sqlvar = "SELECT id, name FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(sqlvar, new Object[]{id},  (resultSet, i) -> {
            String personIDStr = resultSet.getString("id");
            UUID idu = UUID.fromString(personIDStr);
            String name = resultSet.getString("name");           
            return new Person(idu, name);
        });
        return Optional.ofNullable(person);
    }

    @Override
    public List<Person> selectAllPeople(){
      final String sqlvar = "SELECT id, name FROM person";
          return jdbcTemplate.query(sqlvar, mapUsersFromDb());
    }

    private RowMapper<Person> mapUsersFromDb() {
        return (resultSet, i) -> {
            String personIDStr = resultSet.getString("id");
            UUID id = UUID.fromString(personIDStr);

            String name = resultSet.getString("name");
            
           
            return new Person(id, name);
        };
    }

    @Override
    public int deletePersonById(UUID id){
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person update){
        return 1;
    }

}
