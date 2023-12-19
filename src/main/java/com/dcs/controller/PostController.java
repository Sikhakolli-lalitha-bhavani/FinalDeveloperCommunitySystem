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

import com.dcs.dto.PostDTO;
import com.dcs.exception.DeveloperCommunitySystemException;
import com.dcs.service.IPostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	
	@Autowired
	IPostService postService;
	
	@PostMapping(path="/add",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO post ){
		PostDTO post3=postService.addPost(post);
		
		return new ResponseEntity<PostDTO>(post3,HttpStatus.OK);
	}
	
	
	
	@PutMapping(path="update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostDTO> editPost(@PathVariable Integer id ,@RequestBody PostDTO post){
		PostDTO post1=postService.updatePost(id,post);
		
		return new ResponseEntity<PostDTO>(post1,HttpStatus.OK);
	}
	@DeleteMapping(path="remove/{postId}")
	public ResponseEntity<String> removePost(@PathVariable Integer postId)
	{
	PostDTO isDelete=postService.removePost(postId);
	if(isDelete==null) {
		return new ResponseEntity<String>("Response not deleted",HttpStatus.OK);
	}
	return new ResponseEntity<String>("Response deleted",HttpStatus.OK);
}
	
	@GetMapping("get/{postId}")    
	public PostDTO getPostById(@PathVariable Integer postId) throws DeveloperCommunitySystemException {   
		
		return postService.getPostById(postId);     
		}
	
	

		@GetMapping("/search/topic/{topic}")
		public ResponseEntity<List<PostDTO>> getPostsByTopic(@PathVariable String topic) {
	    
 
	    List<PostDTO> response = postService.findByTopic(topic);
	    return new ResponseEntity<List<PostDTO>>(response, HttpStatus.OK);
	}

	@GetMapping("/allPosts")
	public List<PostDTO> readAllPosts() {
		return postService.viewPost();
	}
}