package com.dcs.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcs.entity.Post;
@Repository
public interface PostDao extends JpaRepository<Post, Integer> {

	Page<Post> findByTopic(String topic,Pageable pageable);

	List<Post> findByTopic(String topic);

	


}
