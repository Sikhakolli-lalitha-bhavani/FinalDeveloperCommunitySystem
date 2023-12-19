package com.dcs.entity;
//import java.time.LocalDate;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.OneToMany;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//
//@Entity
//@DiscriminatorValue("developer")
//public class Developer extends User {
//	private String devName;
//	private String devSkill;
//	private LocalDate memberSince;
//	// If no. of Upvote on Post is 5, then reputation value is 1
//	// If no. of Upvote on Post is 10, then reputation value is 2 and so on
//	private Integer reputation;
//	private String status;
////	@OneToMany(mappedBy="developer" ,fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
////	@JsonIgnore
////	private List<Post> listOfPosts;
//	
//	public Developer() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Developer(Integer userId, String userName, String userPassword, String userRole) {
//		super(userId, userName, userPassword, userRole);
//		// TODO Auto-generated constructor stub
//	}
//	
//	public Developer(Integer userId, String userName, String userPassword, String userRole, String devName,
//			String devSkill, LocalDate memberSince, Integer reputation, String status) {
//		super(userId, userName, userPassword, userRole);
//		this.devName = devName;
//		this.devSkill = devSkill;
//		this.memberSince = memberSince;
//		this.reputation = reputation;
//		this.status = status;
//	//	this.listOfPosts = listOfPosts;
//	}
//	
//	public String getDevName() {
//		return devName;
//	}
//	public void setDevName(String devName) {
//		this.devName = devName;
//	}
//	public String getDevSkill() {
//		return devSkill;
//	}
//	public void setDevSkill(String devSkill) {
//		this.devSkill = devSkill;
//	}
//	public LocalDate getMemberSince() {
//		return memberSince;
//	}
//	public void setMemberSince(LocalDate memberSince) {
//		this.memberSince = memberSince;
//	}
//	public Integer getReputation() {
//		return reputation;
//	}
//	public void setReputation(Integer reputation) {
//		this.reputation = reputation;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
////	public List<Post> getListOfPosts() {
////		return listOfPosts;
////	}
////	public void setListOfPosts(List<Post> listOfPosts) {
////		this.listOfPosts = listOfPosts;
////	}
//	// Block or Unblock
//	@Override
//	public String toString() {
//		return "Developer [devName=" + devName + ", devSkill=" + devSkill + ", memberSince=" + memberSince
//				+ ", reputation=" + reputation + ", status=" + status + "]";
//	}
//
//	
//	
//	
//	
//
//}












//package com.devcommunity.entity;
 
import java.time.LocalDate;
import java.util.List;
 
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "developer")
@PrimaryKeyJoinColumn(name="user_id")  
public class Developer extends User {

    private String devName;
    private String devSkill;
    private LocalDate memberSince;
  
    private Integer reputation;
    // Block or Unblock
    private String status;
    @Transient
    private List<Post> listOfPosts;
}