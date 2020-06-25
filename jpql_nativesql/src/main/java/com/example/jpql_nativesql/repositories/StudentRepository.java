package com.example.jpql_nativesql.repositories;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.jpql_nativesql.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	@Query("from Student")
	List<Student>  findAllStudents();
	
	@Query("select firstName, lastName from Student")
	List<Object[]> findAllStudentsPartial();
	
	@Query("from Student where firstName= :fname")
	List<Student> findAllStudentByFirstName(@Param(value = "fname") String fname);
	
	@Query("from Student where firstName in :names")
	List<Student> findAllStudentByFirstNameMultiple(List<String> names);
	
	@Query("from Student where score between :score1 and :score2")
	List<Student> findStudentsForGivenScore (@Param("score1") int score1, @Param("score2") int score2);
	
	@Modifying
	@Query("delete from Student where firstName = :name")
	void deleteStudentsByName(@Param("name") String name);
	
	@Query("from Student")
	List<Student> findAllStudentsWithPage(Pageable pageable);
}
