package com.dcs.entity; 
import java.time.LocalDateTime;
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
@Table(name = "response")
 
public class Response {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
 
    private Integer respId;
    private String answer;
    private LocalDateTime respDateTime;
    @OneToOne(cascade = CascadeType.ALL)
    private Post post;
    @OneToOne(cascade = CascadeType.ALL)
    @Transient
    private Developer developer;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> listOfComments;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Vote> vote;
}