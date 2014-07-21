package models;

import javax.persistence.Entity;

import play.db.ebean.Model;

@Entity
public class Discussion extends Model{
	
	private String url = "";
	private String title = "";
	
	public Discussion(String _url, String _title) {
		this.url = _url;
		this.title = _title;
	}


	public String getUrl() {
		return url;
	}

	public String getTitle() {
		return title;
	}
		
}
