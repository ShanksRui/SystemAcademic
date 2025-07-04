package com.dev.System_Academic.Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Subject implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Integer hourQuantity;
	private Double passGrade;
	

	@JsonIgnore
	@OneToMany(mappedBy = "subject")
	private Set<Enrollment> enrollments = new HashSet<>();
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "course_id")
	private Course course;
	
	public Subject() {
		
	}
	
	public Subject(Long id, String name, Integer hourQuantity, Double passGrade,Course course) {
		this.id = id;
		this.name = name;
		this.hourQuantity = hourQuantity;
		this.passGrade = passGrade;
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHourQuantity() {
		return hourQuantity;
	}

	public void setHourQuantity(Integer hourQuantity) {
		this.hourQuantity = hourQuantity;
	}

	public Double getPassGrade() {
		return passGrade;
	}

	public void setPassGrade(Double passGrade) {
		this.passGrade = passGrade;
	}

	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}
	
	public Course getCourse() {
		return course;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return Objects.equals(id, other.id);
	}
	
}
