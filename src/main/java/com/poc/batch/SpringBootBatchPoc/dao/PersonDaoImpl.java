package com.poc.batch.SpringBootBatchPoc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.poc.batch.SpringBootBatchPoc.model.Person;

@Repository
public class PersonDaoImpl extends JdbcDaoSupport implements PersonDao {
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void insert(List<? extends Person> persons) {
		String sql = "INSERT INTO person " + "(first_name, last_name, email, age) VALUES (?, ?, ?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Person person = persons.get(i);
				ps.setString(1, person.getFirstName());
				ps.setString(2, person.getLastName());
				ps.setString(3, person.getEmail());
				ps.setInt(4, person.getAge());
			}
 
			public int getBatchSize() {
				return persons.size();
			}
		});
	}

	@Override
	public List<Person> loadAllPersons() {
		String sql = "SELECT * FROM person";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
 
		List<Person> result = new ArrayList<Person>();
		for (Map<String, Object> row : rows) {
			Person person = new Person();
			person.setFirstName((String) row.get("first_name"));
			person.setLastName((String) row.get("last_name"));
			person.setEmail((String) row.get("email"));
			person.setAge((int) row.get("age"));
			result.add(person);
		}
 
		return result;
	}

	@Override
	public void insert(Person person) {
		String sql="Insert  into person (first_name, last_name, email, age) values (?,?,?,?)";
		Object[] params = { person.getFirstName(),person.getLastName(),person.getEmail(),person.getAge()};
		getJdbcTemplate().update(sql,params);
		
	}

	@Override
	public void update(Person person) {
		String sql="Update person set first_name=?, last_name=?, age=? where  email=?";
		Object[] params = { person.getFirstName(),person.getLastName(),person.getAge(),person.getEmail()};
		getJdbcTemplate().update(sql, params);
	}
	
}
