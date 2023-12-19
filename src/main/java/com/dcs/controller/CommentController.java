package com.dcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dto.CommentDTO;
import com.dcs.exception.NoEntityFoundException;
import com.dcs.service.ICommentService;

@RestController

@RequestMapping("/comment")

public class CommentController {

	@Autowired
	ICommentService commentService;

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommentDTO> addComment(@Validated @RequestBody CommentDTO response) {
	
			CommentDTO newResponse = commentService.addComment(response);
			
			
			return new ResponseEntity<CommentDTO>(newResponse, HttpStatus.OK);
		
	}

	@PutMapping(path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<CommentDTO> editResponse( @PathVariable Integer id, @RequestBody CommentDTO comment) {
		

			CommentDTO updateResponse = commentService.updateComment(id, comment);
			

			return new ResponseEntity<CommentDTO>(updateResponse, HttpStatus.OK);

		} 

	@DeleteMapping("/remove/{Id}")
	public ResponseEntity<String> removeComment(@PathVariable Integer Id) throws NoEntityFoundException {
		
			CommentDTO isDelete = commentService.removeComment(Id);
			if (isDelete == null) {
				return new ResponseEntity<String>("Response not deleted", HttpStatus.OK);
			}
			return new ResponseEntity<String>("Response deleted", HttpStatus.OK);
	}



	@GetMapping(path = "get/comment/{commentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommentDTO> findByCommentId(@PathVariable Integer commentId){
		
			CommentDTO commentDTO = commentService.getByCommentId(commentId);
			return new ResponseEntity<CommentDTO>(commentDTO, HttpStatus.OK);
		}
	
	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CommentDTO>> getAllComments(){
		
			List<CommentDTO> commentDTO = commentService.getAllComment();
			return new ResponseEntity<List<CommentDTO>>(commentDTO, HttpStatus.OK);
		}
	
	
	}



