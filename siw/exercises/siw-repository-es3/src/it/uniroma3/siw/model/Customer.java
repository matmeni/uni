package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"firstname", "lastname", "email"}))
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String firstname;
    
    @Column(nullable = false)
    private String lastname;

    private String email;

    private String phoneNumber;
    
    private LocalDate dateOfBirth;
    
    private LocalDate registrationDate;
    
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Address address;
    
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Order> orders;
 

    public Customer() { }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String description) {
        this.firstname = description;
    }
    
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String description) {
        this.lastname = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String code) {
        this.email = code;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate Birthdate) {
        this.dateOfBirth = Birthdate;
    }
    
    
    public Address getAddress() {
  return address;
 }

 public void setAddress(Address address) {
  this.address = address;
 }

 public List<Order> getOrders() {
  return orders;
 }

 public void setOrders(List<Order> orders) {
  this.orders = orders;
 }

 public boolean equals(Object obj) {
        Customer c = (Customer)obj;
        return (this.getLastname().equals(c.getLastname())) && (this.getFirstname().equals(c.getFirstname()));
   }

    public int hashCode() {
        return this.id.hashCode();
     }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Customer");
        sb.append("{id=").append(id);
        sb.append(", name='").append(firstname);
        sb.append(", surname=").append(lastname);
        sb.append(", birthdate='").append(dateOfBirth);
        sb.append(", phone number='").append(phoneNumber);
        sb.append("}\n");
        return sb.toString();
    }
}