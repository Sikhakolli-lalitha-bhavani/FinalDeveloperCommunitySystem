package com.dcs.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.CommentDao;
import com.dcs.dto.CommentDTO;
import com.dcs.entity.Comment;
import com.dcs.entity.Developer;
import com.dcs.exception.NoEntityFoundException;

//import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	private CommentDao commentDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDTO addComment(CommentDTO comment) {

		Comment  comment2 = new Comment() ;
		comment2.setCreatedBy(modelMapper.map(comment.getCreatedBy(),Developer.class));
		comment2.setText(comment.getText());
		comment2.setCreatedDate(comment.getCreatedDate());
		
		
	 Comment	comment3 = commentDao.save(comment2);
		return modelMapper.map(comment3, CommentDTO.class);

	}

	@Override
	public CommentDTO updateComment( Integer id,CommentDTO comment) {

		Optional<Comment> entity2 = commentDao.findById(id);
		if(!entity2.isPresent()) {
			throw new NoEntityFoundException("Wrong comment Id");
		}
		
		Comment entity1 = entity2.get();
		
		
		entity1.setCreatedBy(modelMapper.map(comment.getCreatedBy(), Developer.class));
		entity1.setCreatedDate(comment.getCreatedDate());
		entity1.setText(comment.getText());
		commentDao.save(entity1);
		return modelMapper.map(entity1, CommentDTO.class);
	}

	@Override
	public CommentDTO removeComment(Integer respId) throws com.dcs.exception.NoEntityFoundException {

		Comment existingResponseEntity = commentDao.findById(respId)
				.orElseThrow(() -> new com.dcs.exception.NoEntityFoundException("No comment Found "));

		commentDao.deleteById(respId);

		return modelMapper.map(existingResponseEntity, CommentDTO.class);
	}



	@Override
	public CommentDTO getByCommentId(Integer commentId) {

		Optional<Comment> comment = commentDao.findById(commentId);
		if(!comment.isPresent()) {
			throw new NoEntityFoundException("Comment not found ");
		}
		Comment comment2 = comment.get();
		
		CommentDTO commentDTO = modelMapper.map(comment2, CommentDTO.class);
		return commentDTO;
	}

	@Override
	public List<CommentDTO> getAllComment() {
		List<Comment > comments = commentDao.findAll();
		if(comments.size()==0 || comments== null) {
        	throw new NoEntityFoundException("No Comments for this post ");
        }
		
		return comments.stream().map(com->(modelMapper.map(com, CommentDTO.class))).collect(Collectors.toList());
	}



}