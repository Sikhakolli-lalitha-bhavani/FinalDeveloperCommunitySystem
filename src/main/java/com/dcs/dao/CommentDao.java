package com.dcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcs.entity.Comment;
@Repository
public interface CommentDao extends JpaRepository<Comment, Integer> {

}