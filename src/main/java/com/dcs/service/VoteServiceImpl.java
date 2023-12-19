package com.dcs.service;

import java.util.List;

import java.util.stream.Collectors;
 
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
 
import com.dcs.dao.VoteDao;

import com.dcs.dto.VoteDTO;

import com.dcs.entity.Vote;
import com.dcs.exception.NoEntityFoundException;
 
@Service
public class VoteServiceImpl implements IVoteService {
	@Autowired
	VoteDao voteDao;
	@Autowired
	private ModelMapper modelMapper;
	public VoteDTO addVote(VoteDTO vote) {
		Vote entity1=modelMapper.map(vote, Vote.class);
		entity1= voteDao.save(entity1);
		return modelMapper.map(entity1, VoteDTO.class);
	}
	public List<VoteDTO> getAllVotes() {

	List<Vote> votes = voteDao.findAll();
	   
	    List<VoteDTO> voteDTOs = votes.stream().map(entity -> modelMapper.map(entity, VoteDTO.class)).collect(Collectors.toList());   
	    if(voteDTOs.size()==0|| voteDTOs==null) {
	    	throw new NoEntityFoundException("No votes Found");
	    }
	    return voteDTOs;
	    }
	}
 
