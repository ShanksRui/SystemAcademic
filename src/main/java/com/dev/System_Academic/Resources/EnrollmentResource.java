package com.dev.System_Academic.Resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dev.System_Academic.Entities.Enrollment;
import com.dev.System_Academic.Services.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentResource {

	@Autowired
	private EnrollmentService service;
	
	@GetMapping()
	public ResponseEntity<List<Enrollment>> findAll(){
		List<Enrollment> enrollments = service.findAll();
		return ResponseEntity.ok().body(enrollments);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Enrollment> findById(@PathVariable Long id){
		Enrollment obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Enrollment> insert(@RequestBody Enrollment enrollment){
		Enrollment obj = service.insert(enrollment);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);	
	}
	
	
}
