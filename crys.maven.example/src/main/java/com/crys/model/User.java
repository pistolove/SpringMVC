package com.crys.model;

import java.io.Serializable;

/*create table USER(
	id integer(10) primary key not null,
	name varchar(10) not null
 )
*/

public class User implements Serializable {

	private static final long serialVersionUID = -772915035525883569L;
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
