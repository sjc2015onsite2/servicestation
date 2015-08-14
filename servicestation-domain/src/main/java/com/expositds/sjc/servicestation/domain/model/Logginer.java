package com.expositds.sjc.servicestation.domain.model;

/**
 * Базовый пользователь сайта-агрегатора и СТО.
 * 
 * @author Alexey Suslov
 *
 */
public class Logginer {

	/**
	 * Идентификатор залогинивающегося.
	 */
	private Long id;

	/**
	 * Имя залогинивающегося.
	 */
	private String name;
	
	/**
	 * Логин залогинивающегося.
	 */
	private String login;
	
	/**
	 * Пароль залогинивающегося.
	 */
	private String password;
	
	/**
	 * Роль пользователя.
	 */
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
		Logginer other = (Logginer) obj;
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
