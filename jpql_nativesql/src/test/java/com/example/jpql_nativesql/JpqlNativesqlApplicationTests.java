package com.example.jpql_nativesql;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;

import com.example.jpql_nativesql.entities.Student;
import com.example.jpql_nativesql.repositories.StudentRepository;

@SpringBootTest
class JpqlNativesqlApplicationTests {
	
	@Autowired
	private StudentRepository repo;
	
	//@Test
	void testsaveStudent() {
		Student s = new Student();
		s.setFirstName("Foo");
		s.setLastName("Bar");
		s.setScore(11);
		repo.save(s);
	}
	
	//@Test
	void testFindAllStudents() {
		repo.findAllStudents().forEach(System.out::println);
	}
	
//	@Test
	void testfindAllStudentByFirstName() {
		repo.findAllStudentByFirstName("Dibyajyoti").forEach(System.out::println);
	}
	
//	@Test
	void testfindAllStudentByFirstNameMultiple() {
		repo.findAllStudentByFirstNameMultiple(Arrays.asList("Dibyajyoti", "Swati")).forEach(System.out::println);
	}
	
//	@Test
	void testfindStudentsForGivenScore() {
		repo.findStudentsForGivenScore(50, 70).forEach(System.out::println);
	}
	
//	@Test
	@Transactional
	@Rollback(value = false)
	void testdeleteStudentsByName () {
		repo.deleteStudentsByName("abc");
	}
//	@Test
	void testFindAllStudentsPartial() {
		repo.findAllStudentsPartial().forEach(o -> {
			System.out.print(o[0]+"_");
			System.out.println(o[1]);
		});
	}
	
//	@Test
	void testFindAllStudentsWithPage() {
		repo.findAllStudentsWithPage(PageRequest.of(0, 5)).forEach(System.out::println);
	}
	
	@Test
	void testFindAllStudentsWithPageAndSort() {
		repo.findAllStudentsWithPage(PageRequest.of(2, 10, Direction.DESC, "firstName")).forEach(System.out::println);
	}
}
