package com.devcookhome.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Table(name = "user")
@javax.persistence.Entity(name = "user")
public class User{

    @Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(nullable = true)
    private String name;
    @Column(nullable = true)
    private String username;
    @Column(nullable = true)
    private String user_password;
   /* @Column(nullable = false)
    private String matchingPassword;
    */
    @Column(nullable = true)
    private String email;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.user_password;
    }

    public void setPassword(String user_password) {
        this.user_password = user_password;
    }

    /*public String getMatchingPassword() {
        return this.matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }*/

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	
}
