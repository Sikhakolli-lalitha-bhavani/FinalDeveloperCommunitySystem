package com.dcs.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.dcs.dto.CommentDTO;
import com.dcs.exception.NoEntityFoundException;
@Service
public interface ICommentService {

	CommentDTO addComment(CommentDTO  comment);

	CommentDTO  removeComment(Integer respId) throws NoEntityFoundException;

	CommentDTO getByCommentId(Integer commentId);
	
	List<CommentDTO> getAllComment();

	CommentDTO updateComment(Integer id, CommentDTO comment);
}