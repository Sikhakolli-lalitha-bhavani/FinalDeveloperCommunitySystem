package com.dcs.entity;
 
import com.dcs.util.VoteType;
 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vote")
public class Vote {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
 
    private Integer voteId;
	@Enumerated(EnumType.STRING)
    private VoteType voteType;
    @OneToOne(cascade = CascadeType.ALL)
    private Developer developerWhoVoted;
}
