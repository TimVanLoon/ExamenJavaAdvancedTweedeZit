package edu.ap.spring.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Quote {
	
		@Id
		@GeneratedValue
		private Long id;
	   
		private String quote;
	   
		public Quote(){
		   
		}
	   
		public Quote(String quote) {
		   this.quote = quote;
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", quote=" + quote + "]";
	}
	   
	   
}
