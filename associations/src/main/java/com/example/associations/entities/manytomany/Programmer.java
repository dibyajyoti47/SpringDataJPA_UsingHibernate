package com.example.associations.entities.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "programmer")
public class Programmer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name = "salary")
	private int sal;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "programmers_projects", 
						joinColumns = @JoinColumn(name = "programmer_id", referencedColumnName = "id"), 
						inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id")
	)
	private Set<Project> projects;

	@Override
	public String toString() {
		return "Programmer [id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}
	
	
}
