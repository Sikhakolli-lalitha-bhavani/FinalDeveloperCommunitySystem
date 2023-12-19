package com.dcs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dcs.dto.VoteDTO;
import com.dcs.exception.DeveloperCommunitySystemException;
import com.dcs.service.IVoteService;


@RestController
@RequestMapping("/vote")
public class VoteController {
	@Autowired
	IVoteService voteService;
	@PostMapping(path="/add",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VoteDTO> saveVote(@RequestBody VoteDTO vote) throws DeveloperCommunitySystemException{
		VoteDTO newVote=voteService.addVote(vote);
		if(newVote==null) {
			throw new DeveloperCommunitySystemException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<VoteDTO>(newVote,HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<VoteDTO>> getAllVotes() {
	    List<VoteDTO> entities = voteService.getAllVotes(); 
	    return new ResponseEntity<List<VoteDTO>>(entities, HttpStatus.OK);
		}

}
