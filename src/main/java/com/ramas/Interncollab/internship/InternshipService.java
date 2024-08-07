package com.ramas.Interncollab.internship;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramas.Interncollab.dto.InternshipDTO;

@Service
public class InternshipService {
	
	@Autowired
    private InternshipRepository internshipRepository;

    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }
    
    public Internship createInternship(InternshipDTO internshipDTO) {
        Internship internship = new Internship();
        internship.setTitle(internshipDTO.getTitle());
        internship.setDescription(internshipDTO.getDescription());
        internship.setCompanyName(internshipDTO.getCompanyName());
        internship.setLocation(internshipDTO.getLocation());
        return internshipRepository.save(internship);
    }

}
