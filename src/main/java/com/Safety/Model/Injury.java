package com.Safety.Model;


import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import java.util.Optional;



@Entity
@Table(name="injury")
public class Injury {


		   @Id
		   private int injuryId;
		   @Column(name="injuryInfo",nullable=false)
		   @NotEmpty(message="injuryInfo should not be empty.")
		   private String injuryInfo;
		   
		  
		



//		public Injury(int i, String string, int j, int k) {
//			// TODO Auto-generated constructor stub
//		}

		public int getInjuryId() {
			return injuryId;
		}

		public void setInjuryId(int injuryId) {
			this.injuryId = injuryId;
		}

		public String getInjuryInfo() {
			return injuryInfo;
		}

		public void setInjuryInfo(String injuryInfo) {
			this.injuryInfo = injuryInfo;
		}

		
		public Injury(int injuryId, @NotEmpty(message = "injuryInfo should not be empty.") String injuryInfo) {
			super();
			this.injuryId = injuryId;
			this.injuryInfo = injuryInfo;
		}
		

		@Override
		public String toString() {
			return "Injury [injuryId=" + injuryId + ", injuryInfo=" + injuryInfo + "]";
		}

		public Injury() {
			super();
			// TODO Auto-generated constructor stub
		}

		
	
		   
		   
	

	}
