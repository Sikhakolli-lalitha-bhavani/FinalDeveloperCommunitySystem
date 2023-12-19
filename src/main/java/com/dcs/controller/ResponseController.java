package com.dcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dto.ResponseDTO;
import com.dcs.exception.NoEntityFoundException;
import com.dcs.service.IResponseService;

@RestController
@RequestMapping("/Response")
public class ResponseController {
	@Autowired
	IResponseService responseService;

	@PostMapping(path = "add/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> saveResponse(@RequestBody ResponseDTO response) {
		ResponseDTO newResponse = responseService.addResponse(response);
		return new ResponseEntity<ResponseDTO>(newResponse, HttpStatus.OK);
	}

	@PutMapping(path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> editResponse(@PathVariable Integer id, @RequestBody ResponseDTO response) {
		ResponseDTO updateResponse = responseService.updateResponse(id, response);
		return new ResponseEntity<ResponseDTO>(updateResponse, HttpStatus.OK);
	}

	@DeleteMapping("/remove/{respId}")
	public ResponseEntity<String> removeResponse(@PathVariable Integer respId) throws NoEntityFoundException {
		ResponseDTO isDelete = responseService.removeResponse(respId);
		if (isDelete == null) {
			return new ResponseEntity<String>("Response not deleted", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Response deleted", HttpStatus.OK);
	}

	@GetMapping("get/all")
	public ResponseEntity<List<ResponseDTO>> getAllDevelopers() {
		List<ResponseDTO> entities = responseService.getAllResponses();
		return new ResponseEntity<List<ResponseDTO>>(entities, HttpStatus.OK);
	}

}