package com.dcs.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dcs.dao.DeveloperDao;
import com.dcs.dto.DeveloperDTO;
import com.dcs.entity.Developer;
import com.dcs.exception.NoEntityFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeveloperServiceImpl implements IDeveloperService {
	@Autowired
	DeveloperDao developerDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DeveloperDTO addDeveloper(DeveloperDTO developer) {
		
		
			Developer entity1 = modelMapper.map(developer, Developer.class);
			
			entity1 = developerDao.save(entity1);
			
			return modelMapper.map(entity1, DeveloperDTO.class);
			
		

	}

	@Override
	public DeveloperDTO getDeveloperById(Integer devId) throws NoEntityFoundException {

		Optional<Developer> developer = developerDao.findById(devId);
		if(!developer.isPresent()) {
		 throw new NoEntityFoundException("Developer not Found");
		}
		Developer developer2 = developer.get();
		
		return modelMapper.map(developer2, DeveloperDTO.class);
		
		

	}
	
	

	@Override
	public List<DeveloperDTO> getDeveloperByReputation(Integer reputation) {
		List<Developer> entity4 = developerDao.findByReputation(reputation);
		
		
		List<DeveloperDTO> developerDTOs = entity4.stream().map(entity -> modelMapper.map(entity, DeveloperDTO.class))
				.collect(Collectors.toList());
		if(developerDTOs==null || developerDTOs.size()==0) {
			throw new NoEntityFoundException("No developers Found ");
		}
		return developerDTOs;
	}


	@Override
	public Page<DeveloperDTO> getAllDevelopers(int page, int pageSize) {
		Pageable pageable = PageRequest.of(page, pageSize);
		Page<Developer> developersPage = developerDao.findAll(pageable);
		List<DeveloperDTO> developerDTOs = developersPage.getContent().stream()
				.map(entity -> modelMapper.map(entity, DeveloperDTO.class)).collect(Collectors.toList());
		if(developerDTOs==null || developerDTOs.size()==0) {
			throw new NoEntityFoundException("No developers Found ");
		}
		return new PageImpl<>(developerDTOs, developersPage.getPageable(), developersPage.getTotalElements());
	}

	@Override
	public List<DeveloperDTO> getDevelopersByStatus(String status) {
		
		
		List<Developer> developers= developerDao.findByStatus(status);
	if(developers.size()==0 || developers == null) {
			throw new NoEntityFoundException("There are no Developers Found");
		}
		return developers.stream().map(this::mapEntityToDto).collect(Collectors.toList());
	}


	
	@Override
	public DeveloperDTO updateDeveloper( Integer id,DeveloperDTO developer)  {
		
		 Optional<Developer> newDeveloper1 =  developerDao.findById(id);
		if(!newDeveloper1.isPresent()) {
			throw new NoEntityFoundException("No developers found for this Id " +id);
		}
	Developer newDeveloper = newDeveloper1.get();
		newDeveloper.setDevName(developer.getDevName());
		newDeveloper.setDevSkill(developer.getDevSkill());
		newDeveloper.setMemberSince(developer.getMemberSince());
		newDeveloper.setReputation(developer.getReputation());
		newDeveloper.setStatus(developer.getStatus());
		
	
	developerDao.save(newDeveloper);
		return developer;
	}
	
	
	

	

	@Override
	public String delete(Integer id) {
		Developer developer;
		
			developer = developerDao.findById(id)
					.orElseThrow(() -> new NoEntityFoundException("Developer not found"));
		
			developerDao.deleteById(id);
			;

		
		
		return "Developer Deleted Successfully";
	}
	
	public Developer mapDtoToEntity(DeveloperDTO developer ) {
		Developer newDeveloper= modelMapper.map(developer, Developer.class);
		return newDeveloper;
		
		
		
	}
	public DeveloperDTO mapEntityToDto(Developer developer) {
		DeveloperDTO dtoDeveloper= modelMapper.map(developer, DeveloperDTO.class);
		return dtoDeveloper;
		
		
		
	}

	@Override
	public List<DeveloperDTO> viewDevelopers() {
		
		List<DeveloperDTO> developerDTOs = developerDao.findAll().stream()
				.map(entity -> modelMapper.map(entity, DeveloperDTO.class)).collect(Collectors.toList());
		if(developerDTOs==null || developerDTOs.size()==0) {
			throw new NoEntityFoundException("No developers Found ");
		}
		return developerDTOs;
	}

	

}
