
package com.devcommunityFinal1;
 
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
 
import java.util.Collections;

import java.util.Optional;
 
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import org.modelmapper.ModelMapper;

import org.springframework.boot.test.context.SpringBootTest;
 
import com.dcs.dao.DeveloperDao;

import com.dcs.dto.DeveloperDTO;

import com.dcs.entity.Developer;

import com.dcs.exception.NoEntityFoundException;

import com.dcs.service.DeveloperServiceImpl;
 
@SpringBootTest

class DeveloperServiceImplTest {
 
    @Mock

    private DeveloperDao developerDao;
 
    @Mock

    private ModelMapper modelMapper;
 
    @InjectMocks

    private DeveloperServiceImpl developerService;
 
    @BeforeEach

    void setUp() {

        MockitoAnnotations.openMocks(this);

    }
 
    @Test

    void testAddDeveloper() {

        DeveloperDTO developerDTO = new DeveloperDTO(/* Provide necessary data */);

        Developer developer = new Developer(/* Provide necessary data */);
 
        when(modelMapper.map(developerDTO, Developer.class)).thenReturn(developer);

        when(developerDao.save(developer)).thenReturn(developer);

        when(modelMapper.map(developer, DeveloperDTO.class)).thenReturn(developerDTO);
 
        DeveloperDTO result = developerService.addDeveloper(developerDTO);
 
        assertNotNull(result);

        // Add assertions based on expected behavior

    }
 
    @Test

    void testGetDeveloperById() {

        int devId = 1;

        Developer developer = new Developer();

        DeveloperDTO developerDTO = new DeveloperDTO();
 
        when(developerDao.findById(devId)).thenReturn(Optional.of(developer));

        when(modelMapper.map(developer, DeveloperDTO.class)).thenReturn(developerDTO);
 
        DeveloperDTO result = developerService.getDeveloperById(devId);
 
        assertNotNull(result);

    }
 
   

}
