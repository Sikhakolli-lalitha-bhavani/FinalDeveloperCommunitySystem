package com.devcommunityFinal1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.dcs.dao.PostDao;
import com.dcs.dto.PostDTO;
import com.dcs.entity.Post;
import com.dcs.exception.NoEntityFoundException;
import com.dcs.service.PostServiceImpl;
 
@SpringBootTest
class PostServiceImplTest {
 
    @Mock
    private PostDao postDao;
 
    @Mock
    private ModelMapper modelMapper;
 
    @InjectMocks
    private PostServiceImpl postService;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testPost = new Post();
        testPost.setPostId(1);
        when(modelMapper.map(any(), any())).thenReturn(testPostDTO);
    }
 
    @Test
    void testAddPost() {
        PostDTO postDTO = new PostDTO();
        Post post = new Post();
 
        when(modelMapper.map(postDTO, Post.class)).thenReturn(post);
        when(postDao.save(post)).thenReturn(post);
        when(modelMapper.map(post, PostDTO.class)).thenReturn(postDTO);
 
        PostDTO result = postService.addPost(postDTO);
 
        assertNotNull(result);
    }
 
    private Post testPost;
    private PostDTO testPostDTO;
 
   
 
    @Test
    public void testUpdatePost() {
    }
 
 
    @Test
    public void testGetPostById_ExistingPost() {
        Post testPost = new Post();
        testPost.setPostId(1);
 
        PostDTO testPostDTO = new PostDTO();
        testPostDTO.setPostId(1);
 
        when(postDao.findById(1)).thenReturn(Optional.of(testPost));
        when(modelMapper.map(testPost, PostDTO.class)).thenReturn(testPostDTO);
 
        PostDTO resultPostDTO = postService.getPostById(1);
 
        assertEquals(testPostDTO.getPostId(), resultPostDTO.getPostId());
    }
 
    @Test
    public void testGetPostById_NonExistingPost() {
        when(postDao.findById(1)).thenReturn(Optional.empty());
 
        assertThrows(NoEntityFoundException.class, () -> postService.getPostById(1));
    }

 
 
   
}
