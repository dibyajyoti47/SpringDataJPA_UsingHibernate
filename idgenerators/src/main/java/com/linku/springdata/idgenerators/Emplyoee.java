package com.linku.springdata.idgenerators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employee")
//@TableGenerator(name="employee_gen", 
//				table = "id_gen", 
//				pkColumnName = "gen_name", 
//				valueColumnName = "gen_val",
//				allocationSize = 100)
public class Emplyoee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
}
