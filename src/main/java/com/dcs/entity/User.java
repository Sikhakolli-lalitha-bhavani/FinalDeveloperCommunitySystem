package com.dcs.entity;

 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@Inheritance(strategy=InheritanceType.JOINED)  
 
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
 
    private Integer userId;
    private String userName;
    private String userPassword;
  
    private String userRole;
}
