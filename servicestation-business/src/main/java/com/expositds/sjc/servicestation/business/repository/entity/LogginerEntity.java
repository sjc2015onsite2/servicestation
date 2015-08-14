package com.expositds.sjc.servicestation.business.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.expositds.sjc.servicestation.domain.model.LogginerRole;

/**
 * Базовый пользователь сайта-агрегатора и СТО.
 * 
 * @author Alexey Suslov
 *
 */
@Entity
@Table(name = "logginers")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class LogginerEntity {

	/**
	 * Идентификатор залогинивающегося.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * Имя залогинивающегося.
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * Логин залогинивающегося.
	 */
	@Column(name = "login")
	private String login;
	
	/**
	 * Пароль залогинивающегося.
	 */
	@Column(name = "password")
	private String password;
	
	/**
	 * Роль пользователя.
	 */
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private LogginerRole role;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogginerEntity other = (LogginerEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LogginerRole getRole() {
		return role;
	}

	public void setRole(LogginerRole role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
