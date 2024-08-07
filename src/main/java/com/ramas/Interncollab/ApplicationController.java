package com.ramas.Interncollab;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramas.Interncollab.dto.ApplicationDTO;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@PostMapping("/submit")
	public ResponseEntity<Application> submitApplication(@RequestBody ApplicationDTO applicationDTO) {
		Application application = applicationService.submitApplication(applicationDTO);
		return ResponseEntity.ok(application);
	}

	@PutMapping("/{id}/status")
	public ResponseEntity<Application> updateStatus(@PathVariable Long id, @RequestParam String status) throws Exception {
		Application updatedApplication = applicationService.updateStatus(id, status);
		return ResponseEntity.ok(updatedApplication);
	}

	// adding a method in ApplicationController.java to fetch all applications.
	// Backend Endpoint
	@GetMapping
	public ResponseEntity<List<Application>> getAllApplications() {
		List<Application> applications = applicationService.getAllApplications();
		return ResponseEntity.ok(applications);
	}

}
