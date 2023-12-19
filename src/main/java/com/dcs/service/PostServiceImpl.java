package com.dcs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.PostDao;
import com.dcs.dao.VoteDao;
import com.dcs.dto.PostDTO;
import com.dcs.entity.Developer;
import com.dcs.entity.Post;
import com.dcs.exception.NoEntityFoundException;
@Service
public class PostServiceImpl implements IPostService {
	@Autowired
	PostDao postDao;
	@Autowired
	VoteDao voteDao;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	
	public PostDTO addPost(PostDTO post) {
		Post entity1=modelMapper.map(post, Post.class);
		entity1=postDao.save(entity1);
		PostDTO entity=modelMapper.map(entity1,PostDTO.class);
		return entity;
	}

	@Override
	public PostDTO updatePost( Integer id ,PostDTO post) {
		Optional<Post> post1 =  postDao.findById(id);
		
		if(!post1.isPresent()) {
			throw new NoEntityFoundException("No Post for this Id");
		}
		
		Post post2 = post1.get();
		post2.setDeveloper(modelMapper.map(post.getDeveloper(), Developer.class));
		post2.setPostDate(post.getPostDate());
		post2.setNoOfViews(post.getNoOfViews());
		post2.setTopic(post.getTopic());
		post2.setQuery(post.getQuery());
		post2 = postDao.save(post2);
		return modelMapper.map(post2, PostDTO.class);
		

	}


	@Override
	public PostDTO getPostById(Integer postId) {
		Optional<Post> entity=postDao.findById(postId);
		
		if(!entity.isPresent()) {
			throw new NoEntityFoundException("No Post is found for thr Id");
		
		}
		Post post = entity.get();
	
	
		PostDTO entity1=modelMapper.map(post,PostDTO.class);
		return entity1;
		
		
	}

	@Override
	public PostDTO removePost(Integer postId) {

		Optional<Post> post = postDao.findById(postId);
		if(!post.isPresent()) {
			throw new NoEntityFoundException("Wrong id given");
		}
		Post post2 = post.get();
        return modelMapper.map(post2,PostDTO.class);
	}

	

	 @Override
	    public List<PostDTO> findByTopic(String topic) {
	       
	        List<Post> post = postDao.findByTopic(topic);
	        
	        if(post.size()==0 || post== null) {
	        	throw new NoEntityFoundException("No post found for this topic ");
	        }

	        return post
	                .stream()
	                .map(post1 -> modelMapper.map(post1, PostDTO.class))
	                .collect(Collectors.toList());
	    }
	 

	@Override
	public List<PostDTO> viewPost() {
			List<PostDTO> postDTOs = new ArrayList<PostDTO>();
			List<Post> post = postDao.findAll();
			if(post.size()==0 || post== null) {
	        	throw new NoEntityFoundException("No post found for this topic ");
	        }
			
			postDTOs= post
	                .stream()
	                .map(post1 -> modelMapper.map(post1, PostDTO.class))
	                .collect(Collectors.toList());

			return postDTOs;
		}
	}
	