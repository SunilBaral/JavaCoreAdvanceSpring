package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.Student;
import com.spring.jdbc.entities.StudentDao;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		// insert query
		String query = "insert into student(id,name,city) values(?,?,?)";
		int i = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return i;
	}

	@Override
	public int change(Student student) {
		// updating data
		String query = "update student set name=?,city=? where id=?";
		int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}

	@Override
	public int delete(Student student) {
		String query = "delete from student where id=?";
		int d = this.jdbcTemplate.update(query, student.getId());
		return d;
	}

	@Override
	public Student getStudent(int studentId) {
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper= new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}
	@Override
	public List<Student> getAllStudents() {
		String query="select * from student";
		List<Student> student = this.jdbcTemplate.query(query,new RowMapperImpl());
		return student;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



}
