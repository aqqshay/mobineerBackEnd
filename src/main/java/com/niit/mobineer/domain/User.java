package com.niit.mobineer.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//-----------------Declaration Of Private Members----------------//
	@Id
	private String id;
	
	private String name;
	
	private String password;
	
	private String mail;
	
	private String contact;
	
	private String role="USER";
	
	private boolean enabled=true;
	//--------------End of Declaration Of Private Members------------//
	
	
	//------------------Mapping of User to Cart-----------------//
	@OneToOne( cascade=CascadeType.ALL , fetch=FetchType.EAGER, mappedBy="user")
    private Cart cart;

	
	
	//------------------Setter and Getter Methods Declaration----------------//
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	//--------------End Of Setter and Getter Methods Declaration------------//
	
	@Override
	public String toString() {
		return "User [user_id=" + id + ", name=" + name + ", email=" + mail + ", password=" + password + ", role="
				+ role + ", contact=" + contact + "]";
	}
}
	
