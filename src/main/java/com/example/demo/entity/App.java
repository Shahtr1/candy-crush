package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="apps")
public class App {
	
	@Id
	private Long id;
	
	private String appId;
	
	private String title;
	
	private String url;
	
	@Lob
	@Column( length = 100000 )
	private String description;
	
	private String icon;
	
	private String contentRating;
	
	private String size;
	
	private String version;
		
	private boolean free;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "developer_id", referencedColumnName = "id")
    private Developer developer;
	
	public App() {}

	public App(Long id, String appId, String title, String url, 
			String description, String icon, String contentRating,
			String size, String version, boolean free) {
		this.id = id;
		this.appId = appId;
		this.title = title;
		this.url = url;
		this.description = description;
		this.icon = icon;
		this.contentRating = contentRating;
		this.size = size;
		this.version = version;
		this.free = free;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getContentRating() {
		return contentRating;
	}

	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	@Override
	public String toString() {
		return "App [id=" + id + ", appId=" + appId + ", title=" + title + ", url=" + url + ", description="
				+ description + ", icon=" + icon + ", contentRating=" + contentRating + ", size=" + size + ", version="
				+ version + ", free=" + free + ", genre=" + genre + ", developer=" + developer + "]";
	}

	
	
	
	
}
