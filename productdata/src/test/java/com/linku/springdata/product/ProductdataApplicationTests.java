package com.linku.springdata.product;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.mapping.Collection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.linku.springdata.product.entities.Product;
import com.linku.springdata.product.repos.ProductRepository;

@SpringBootTest
class ProductdataApplicationTests {
	
	@Autowired
	ProductRepository repository;
	
	@Autowired
	private EntityManager em;
	
	@Test
	void testCreate() {
		Product p = new Product();
		p.setId(102);
		p.setName("Sony");
		p.setDesc("Great");
		p.setPrice(13d);
		repository.save(p);
	}
	
	@Test
	void testRead () {
		Optional<Product> optional = repository.findById(101);
		System.out.println(optional.get());
	}

	@Test
	void testUpdate() {
		Product product = repository.findById(101).get();
		product.setName("Apple");
		repository.save(product);
	}
	
	@Test
	void testDelete() {
		repository.deleteById(102);
	}
	
	@Test
	void testFindproductByNameAndDesc() {
		List<Product> list = repository.findByNameAndDesc("Samsung Gear", "From Samsung");
		System.out.println(list);
	}
	
	@Test
	void testFindproductByName() {
		List<Product> list = repository.findByName("IWatch");
		System.out.println(list);
	}
	
	@Test
	void testCount() {
		System.out.println(repository.count());
	}

	@Test
	void testfindByIdIn() {
		List<Product> list = repository.findByIdIn(Arrays.asList(2,3));
		System.out.println(list);
	}
	
	@Test
	void testfindByDescLike() {
		List<Product> list = repository.findByDescLike("%Inc");
		System.out.println(list);
	}
	
	@Test
	void testfindByPriceBetween() {
		List<Product> list = repository.findByPriceBetween(100d, 300d);
		System.out.println(list);
	}

	@Test
	void testfindByDescContains() {
		List<Product> list = repository.findByDescContains("from");
		System.out.println(list);
	}

	@Test
	void testfindByPriceGreaterThan() {
		List<Product> list = repository.findByPriceGreaterThan(100.00);
		System.out.println(list);
	}
	
	@Test
	void testFindAllPaging () {
		Pageable pageable = PageRequest.of(1, 2);
		Page<Product> page = repository.findAll(pageable);
		page.forEach(p -> System.out.println(p));
	}
	
	@Test
	void testFindAllSorting() {
		repository.findAll(Sort.by(Direction.DESC, "name")).forEach(p -> System.out.println(p.getName()));;
	}
	
	@Test
	void testFindAllSortingMultiple() {
		repository.findAll(Sort.by(Direction.DESC, "name", "price")).forEach(p -> System.out.println(p.getName()+"_"+p.getPrice()));;
	}
	
	@Test
	void testFindAllSortingMultipleOrderObject() {
		repository.findAll(Sort.by(new Sort.Order(Direction.ASC, "name"), new Sort.Order(Direction.DESC, "price"))).forEach(System.out::println);
	}
	
	@Test
	void testPagingAndSorting () {
		Pageable pageable = PageRequest.of(0, 2, Direction.ASC, "name");
		repository.findAll(pageable).forEach(System.out::println);
	}
	
	@Test
	@Transactional
	void testCachingl1() { //level 1 caching
		repository.findById(1);
		repository.findById(1);
		repository.findById(1);
		//only one database call, check console 
	}
	
	@Test
	@Transactional
	void testCachingEvict() { 
		Session session = em.unwrap(Session.class);
		Product product = repository.findById(1).get(); // 1st time, will call db
		repository.findById(1); // 2nd time,  wont call db
		session.evict(product); // removing the obect from l1 cache
		repository.findById(1).get(); // third time, will call db
	}


}
