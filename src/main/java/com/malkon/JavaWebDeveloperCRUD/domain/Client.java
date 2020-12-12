package com.malkon.JavaWebDeveloperCRUD.domain;

import java.io.Serializable;
import java.util.UUID;

public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id = UUID.randomUUID();
	private UUID code = UUID.randomUUID();
	private String name;

	public Client(UUID id, UUID code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public Client() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getCode() {
		return code;
	}

	public void setCode(UUID code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Client other = (Client) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

}
