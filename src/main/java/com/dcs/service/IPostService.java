package com.dcs.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.dcs.dto.PostDTO;
@Service
public interface IPostService {

	PostDTO addPost(PostDTO post);
	PostDTO getPostById(Integer postId);

	PostDTO removePost(Integer postId);
	List<PostDTO> viewPost();

	List<PostDTO> findByTopic(String topic);

	PostDTO updatePost(Integer id, PostDTO post);

}