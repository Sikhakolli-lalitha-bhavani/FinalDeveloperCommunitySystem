package com.dcs.dto;


import java.time.LocalDate;

import com.dcs.entity.Response;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
	@NotNull
	private Integer commentId;
	@Min(10)
	@Max(20)
	private String text;
	private DeveloperDTO createdBy;
	private LocalDate createdDate;
	@Transient
	@JsonIgnore
	private Response response;
}
