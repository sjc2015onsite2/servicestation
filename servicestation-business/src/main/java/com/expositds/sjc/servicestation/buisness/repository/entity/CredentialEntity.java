package com.expositds.sjc.servicestation.buisness.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Данные для авторизации пользователя (мандат).
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "credentials")
public class CredentialEntity {
	
	/**
	 * Идентификатор мандата.
	 */
	@Id
	@Column(name = "credential_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long credentialId;
	
	/**
	 * Логин.
	 */
	@Column(name = "login")
	private String login;
	
	/**
	 * Пароль.
	 */
	@Column(name = "password")
	private String password;
	
	/**
	 * Создаёт новый мандат для авторизации пользователя.
	 * 
	 * @param login логин
	 * @param password пароль
	 */
	public CredentialEntity(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public CredentialEntity() {
		this(null, null);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		CredentialEntity other = (CredentialEntity) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(Long credentialId) {
		this.credentialId = credentialId;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
	
}
