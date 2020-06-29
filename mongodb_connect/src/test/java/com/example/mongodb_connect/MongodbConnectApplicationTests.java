package com.example.mongodb_connect;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mongodb_connect.models.Product;
import com.example.mongodb_connect.repositories.ProductRepository;

@SpringBootTest
class MongodbConnectApplicationTests {
	
	@Autowired
	private ProductRepository repo;
	
	@Test
	void testSave() {
		Product product = new Product();
		product.setName("Noika 6.2");
		product.setPrice(13f);
		repo.save(product);
	}

	@Test
	void testRead() {
		List<Product> products = repo.findAll();
		products.forEach(System.out::println);
	}

	@Test
	void testDelete() {
		repo.deleteById("5efa2839e8679f56cb9900b0");
	}
	
	@Test
	void testUpdate() {
		Product product = repo.findById("5efa27e411e29a04ee9d5e58").get();
		product.setName("Apple X");
		repo.save(product);
	}
}
