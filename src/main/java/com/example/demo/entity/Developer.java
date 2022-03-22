package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="developers")
public class Developer {
	@Id
	private Long id;
	
	private String name;
	
	private String url;
	
	private String website;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@OneToOne(mappedBy = "developer")
    private App app;
	
	public Developer() {}

	public Developer(Long id, String name, String url, String website) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.website = website;
	}

	@Override
	public String toString() {
		return "Developer [id=" + id + ", name=" + name + ", url=" + url + ", website=" + website + "]";
	}
	
	
	
	
}
