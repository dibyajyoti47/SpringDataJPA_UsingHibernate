package com.example.savefile_jpa.entities;

import java.util.Arrays;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity @Table(name="image")
public class Image {
	
	@Id
	private long id;
	private String name;
	@Lob
	private byte[] data;

	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", data=" + Arrays.toString(data) + "]";
	}
}
