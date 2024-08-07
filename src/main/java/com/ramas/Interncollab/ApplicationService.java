package com.ramas.Interncollab;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramas.Interncollab.dto.ApplicationDTO;

@Service
public class ApplicationService {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
    private EmailService emailService;
	
	
	public Application submitApplication(ApplicationDTO applicationDTO) {
        Application application = new Application();
        application.setName(applicationDTO.getName());
        application.setEmail(applicationDTO.getEmail());
        application.setPhoneNumber(applicationDTO.getPhoneNumber());
        application.setResume(applicationDTO.getResume());
        application.setCoverLetter(applicationDTO.getCoverLetter());
        application.setStatus("Pending");
        application.setCompanyId(applicationDTO.getCompanyId());

        Application savedApplication = applicationRepository.save(application);

        emailService.sendConfirmationEmail(applicationDTO.getEmail());
        emailService.notifyCompany(applicationDTO.getCompanyId(), savedApplication);

        return savedApplication;
    }
	
	
	public Application updateStatus(Long id, String status) throws Exception {
        Optional<Application> optionalApplication = applicationRepository.findById(id);
        if (optionalApplication.isPresent()) {
            Application application = optionalApplication.get();
            application.setStatus(status);
            return applicationRepository.save(application);
        } else {
            throw new Exception("Application not found with id " + id);
        }
    }
	
	// adding a method in ApplicationService.java to get all applications.
	public List<Application> getAllApplications() {
	    return applicationRepository.findAll();
	}

}
