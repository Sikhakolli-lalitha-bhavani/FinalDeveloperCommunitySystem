package com.dcs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcs.dto.VoteDTO;

@Service
public interface IVoteService {

	VoteDTO addVote(VoteDTO vote);

	List<VoteDTO> getAllVotes();

}
