package com.dcs.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dao.DeveloperDao;
import com.dcs.dto.DeveloperDTO;
import com.dcs.service.IDeveloperService;

@RestController
@RequestMapping("/developer")
public class DeveloperController {
	@Autowired
	IDeveloperService developerService;
	@Autowired
	DeveloperDao developerDao;

	@GetMapping(path = "get/{devId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeveloperDTO> getDevelopersById(@PathVariable Integer devId) {

		DeveloperDTO developer1 = developerService.getDeveloperById(devId);
		return new ResponseEntity<DeveloperDTO>(developer1, HttpStatus.OK);
	}

	@PostMapping(path = "add/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeveloperDTO> saveDeveloper(@RequestBody DeveloperDTO developer) {
		DeveloperDTO newDeveloper = developerService.addDeveloper(developer);

		return new ResponseEntity<DeveloperDTO>(newDeveloper, HttpStatus.OK);
	}



	@GetMapping(path = "get3/{reputation}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DeveloperDTO>> getDevelopersByReputation(@PathVariable Integer reputation) {
		List<DeveloperDTO> developer7 = developerService.getDeveloperByReputation(reputation);
		return new ResponseEntity<List<DeveloperDTO>>(developer7, HttpStatus.OK);
	}

	@GetMapping(path = "get22/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DeveloperDTO>> getDevelopersByStatus(@PathVariable String status

	) {
		List<DeveloperDTO> developerDTOs = developerService.getDevelopersByStatus(status);
		return new ResponseEntity<List<DeveloperDTO>>(developerDTOs, HttpStatus.OK);
	}

	@PutMapping(path = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeveloperDTO> editDeveloper(@PathVariable Integer id, @RequestBody DeveloperDTO developer)
		 {
		DeveloperDTO developer1 = developerService.updateDeveloper(id, developer);
		
		return new ResponseEntity<DeveloperDTO>(developer1, HttpStatus.OK);
	}

	@GetMapping("/allDevelopers")
	public List<DeveloperDTO> readAllDevelopers() {
		return developerService.viewDevelopers();
	}
	
	
	@DeleteMapping(path = "delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteDevelopr(@PathVariable Integer id ){
		String answer= developerService.delete(id);
		return new ResponseEntity<String>(answer,HttpStatus.OK);
	}

}
