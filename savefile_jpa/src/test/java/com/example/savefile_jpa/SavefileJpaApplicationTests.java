package com.example.savefile_jpa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.savefile_jpa.entities.Image;
import com.example.savefile_jpa.repos.ImageRepository;

@SpringBootTest
class SavefileJpaApplicationTests {
	
	@Autowired
	private ImageRepository repo;
	
	@Test
	void testImageSave() throws IOException {
		Image image = new Image();
		image.setName("myImg2.txt");
//		image.setId(1);
		
		File file = new File("D://t1.txt");
		byte fileContent [] = new byte[(int) file.length()];
		FileInputStream stream = new FileInputStream(file);
		stream.read(fileContent);
		image.setData(fileContent);
		repo.save(image);
		stream.close();
	}
	
	@Test
	void testImageRead() throws IOException {
		Image img = repo.findById(0l).get();
		File file = new File("D://downloaded/"+img.getName());
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(img.getData());
	}
}
