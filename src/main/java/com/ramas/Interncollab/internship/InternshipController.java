package com.ramas.Interncollab.internship;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramas.Interncollab.dto.InternshipDTO;

@RestController
@RequestMapping("/api/internships")
public class InternshipController {
	
	@Autowired
	private InternshipService internshipService;
	
	@GetMapping
	public ResponseEntity<List<Internship>> getAllInternships() {
        List<Internship> internships = internshipService.getAllInternships();
        return ResponseEntity.ok(internships);
    }
	
	 @PostMapping
	    public ResponseEntity<Internship> createInternship(@RequestBody InternshipDTO internshipDTO) {
	        Internship internship = internshipService.createInternship(internshipDTO);
	        return ResponseEntity.ok(internship);
	    }

}
