package com.dcs.entity;
 
import java.time.LocalDate;
import java.util.List;
 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
 
    private Integer postId;
    private String query;
    private LocalDate postDate;
    private String topic;
    @OneToOne(cascade = CascadeType.ALL)
    private Developer developer;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Response> listOfResponse;
    @Transient
    private List<Comment> listOfComment;
    private Integer noOfViews;
    @Transient
    private List<Vote> vote;
}