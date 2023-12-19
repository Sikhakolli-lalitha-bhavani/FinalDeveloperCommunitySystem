package com.dcs.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

//import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
@NotNull
	private Integer postId;
	private String query;
	private LocalDate postDate;
	private String topic;
	private DeveloperDTO developer;
//	private List<ResponseDTO> listOfResponse;
	private Integer noOfViews;
	
}