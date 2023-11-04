package com.mobile101.tierlistAPI.tierlist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="Categories")
@Table(
	name = "categories"
)
public class Category {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long id;
    
	@Column(name = "name", nullable = false)
	private String name;

    @Column(name = "image", nullable = true, columnDefinition = "LONGTEXT")
	private String image;

	public Category() {
		
	}

	public Category(String name, String image){
		super();
        this.name = name;
        this.image = image;
	}
}
