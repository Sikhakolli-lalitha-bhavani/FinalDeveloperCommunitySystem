package com.devcommunityFinal1;


import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
 
import java.util.List;
 
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.modelmapper.ModelMapper;

import org.springframework.boot.test.context.SpringBootTest;
 
import com.dcs.dao.UserDao;

import com.dcs.dto.UserDTO;

import com.dcs.entity.User;

import com.dcs.exception.UserAlreadyExists;

import com.dcs.service.UserServiceImpl;
 
@SpringBootTest

class UserServiceImplTest {
 
    @Mock

    private UserDao userDao;
 
    @Mock

    private ModelMapper modelMapper;
 
    @InjectMocks

    private UserServiceImpl userService;
 
    @Test

    void testRegisterUser() {

        // Arrange

        UserDTO userDTO = new UserDTO();

        userDTO.setUserName("testUser");
 
        User userEntity = new User();

        userEntity.setUserName("testUser");
 
        when(userDao.findAll()).thenReturn(List.of()); // No existing users

        when(modelMapper.map(userDTO, User.class)).thenReturn(userEntity);

        when(userDao.save(userEntity)).thenReturn(userEntity);

        when(modelMapper.map(userEntity, UserDTO.class)).thenReturn(userDTO);
 

        UserDTO result = userService.registerUser(userDTO);
 

        assertNotNull(result);

        assertEquals("testUser", result.getUserName());

    }
 
    @Test

    void testRegisterUserWithExistingUser() {

        UserDTO userDTO = new UserDTO();

        userDTO.setUserName("existingUser");
 
        User existingUser = new User();

        existingUser.setUserName("existingUser");
 
        when(userDao.findAll()).thenReturn(List.of(existingUser)); // Existing user

        when(modelMapper.map(userDTO, User.class)).thenReturn(existingUser);
 

        assertThrows(UserAlreadyExists.class, () -> userService.registerUser(userDTO));

    }
 
    @Test

    void testSignIn() {

        String userName = "testUser";

        String password = "password";
 
        User userEntity = new User();

        userEntity.setUserName(userName);

        userEntity.setUserPassword(password);
 
        UserDTO expectedUserDTO = new UserDTO();

        expectedUserDTO.setUserName(userName);
 
        when(userDao.findByUserName(userName)).thenReturn(userEntity);

        when(modelMapper.map(userEntity, UserDTO.class)).thenReturn(expectedUserDTO);

        UserDTO result = userService.signIn(userName, password);

        assertNotNull(result);

        assertEquals(userName, result.getUserName());

    }
 
    @Test

    void testSignInWithInvalidUserOrPassword() {

        String userName = "testUser";

        String password = "invalidPassword";
 
        when(userDao.findByUserName(userName)).thenReturn(null);

        assertThrows(UserAlreadyExists.class, () -> userService.signIn(userName, password));

    }
 
}
 