package com.example.demo.entity;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Entity
@Table(name = "BookCopies")
@Embeddable
@AccessType(Type.FIELD)
public class BookCopies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int copy_id;
    @NotNull(message = "Book status cannot be null!") 
    @Column(name = "book_status", nullable = false)
	public boolean book_status;
    @NotNull(message = "Location cannot be null or empty!")
    @Column(name = "location", nullable = false)
	public String location;
    @NotNull(message = "Book ID cannot be null or zero!")
    @Column(name = "book_id", nullable = false)
    public int book_id; 
    
    
    



}
