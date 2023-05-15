package com.vendors.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "address")
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Address line 1 is required")
    private String line1;
    
    private String line2;
    
    @NotNull(message = "City is required")
    private String city;
    
    @NotNull(message = "Country is required")
    private String country;
    
    @NotNull(message = "Zip code is required")
    @Pattern(regexp = "^[0-9]{6}(?:-[0-9]{4})?$", message = "Zip code should be in the format XXXXXX")
    private String zipCode;

	public Address() {
		super();
	}

	public Address(Long id, @NotNull(message = "Address line 1 is required") String line1, String line2,
			@NotNull(message = "City is required") String city,
			@NotNull(message = "Country is required") String country,
			@NotNull(message = "Zip code is required") @Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$", message = "Zip code should be in the format XXXXX or XXXXX-XXXX") String zipCode) {
		super();
		this.id = id;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", country=" + country
				+ ", zipCode=" + zipCode + "]";
	}
    
    
}

