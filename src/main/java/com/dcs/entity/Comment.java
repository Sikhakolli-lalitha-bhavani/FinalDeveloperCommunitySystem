package com.dcs.entity;
//
//
//import java.time.LocalDate;
//import java.util.List;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//@Entity
//public class Comment {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="commentId")
//	private Integer commentId;
//	
//	@Column(nullable = false)
//	private String text;
//	
//	@OneToOne
//    @JoinColumn(name = "userId", referencedColumnName = "userId")
//	
//	
//	private Developer createdBy;
//	@ManyToOne
//	@JoinColumn(name="responseId")
//	@JsonIgnore
//	private Response response;
//	private LocalDate createdDate;
//	
//	public Comment(Integer commentId, String text, Developer createdBy, LocalDate createdDate) {
//		super();
//		this.commentId = commentId;
//		this.text = text;
//		this.createdBy = createdBy;
//		this.createdDate = createdDate;
//		
//	}
//	public Comment() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Integer getCommentId() {
//		return commentId;
//	}
//	public void setCommentId(Integer commentId) {
//		this.commentId = commentId;
//	}
//	public String getText() {
//		return text;
//	}
//	public void setText(String text) {
//		this.text = text;
//	}
//	public Developer getCreatedBy() {
//		return createdBy;
//	}
//	public void setCreatedBy(Developer createdBy) {
//		this.createdBy = createdBy;
//	}
//	public LocalDate getCreatedDate() {
//		return createdDate;
//	}
//	public void setCreatedDate(LocalDate createdDate) {
//		this.createdDate = createdDate;
//	}
//	
//	@Override
//	public String toString() {
//		return "Comment [commentId=" + commentId + ", text=" + text + ", createdBy=" + createdBy + ", createdDate="
//				+ createdDate + "]";
//	}
//	
//}





import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
 
public class Comment {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer commentId;
    private String text;
    @OneToOne(cascade = CascadeType.ALL)
    private Developer createdBy;
    private LocalDate createdDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    List<Vote> votes = new ArrayList<>();
    

}
