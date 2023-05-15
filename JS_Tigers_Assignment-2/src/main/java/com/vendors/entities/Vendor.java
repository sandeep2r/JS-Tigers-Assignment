package com.vendors.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "vendor")
public class Vendor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Vendor name is required")
    private String name;
    
    @NotNull(message = "Bank account number is required")
    @Size(min = 8, max = 16, message = "Bank account number should be between 8 and 16 characters")
    private String bankAccountNumber;
    
    @NotNull(message = "Bank name is required")
    private String bankName;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_address_id", referencedColumnName = "id")
    @Valid
    private Address address;

	public Vendor() {
		super();
	}

	public Vendor(Long id, @NotNull(message = "Vendor name is required") String name,
			@NotNull(message = "Bank account number is required") @Size(min = 8, max = 16, message = "Bank account number should be between 8 and 16 characters") String bankAccountNumber,
			@NotNull(message = "Bank name is required") String bankName, @Valid Address address) {
		super();
		this.id = id;
		this.name = name;
		this.bankAccountNumber = bankAccountNumber;
		this.bankName = bankName;
		this.address = address;
	}

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

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", bankAccountNumber=" + bankAccountNumber + ", bankName="
				+ bankName + ", address=" + address + "]";
	}

    
    
    
}
