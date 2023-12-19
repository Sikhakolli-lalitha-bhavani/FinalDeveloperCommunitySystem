package com.dcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.dcs.dto.ResponseDTO;
import com.dcs.exception.NoEntityFoundException;

@Service
@Qualifier("responseServiceImpl")
public interface IResponseService {

	ResponseDTO addResponse(ResponseDTO response);

	ResponseDTO removeResponse(Integer respId) throws NoEntityFoundException;

	ResponseDTO updateResponse(Integer id, ResponseDTO response);

	List<ResponseDTO> getAllResponses();

}