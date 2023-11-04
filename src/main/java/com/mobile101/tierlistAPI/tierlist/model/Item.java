package com.mobile101.tierlistAPI.tierlist.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="Items")
@Table(
	name = "items",
    uniqueConstraints = {
                @UniqueConstraint(name = "item_name_unique", columnNames = "name")
        }
)
public class Item {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long id;
    
	@Column(name = "name", unique = true, nullable = false)
	private String name;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Category category;


    @Column(name = "description", nullable = true)
	private String description;

    @Column(name = "image_url", nullable = false, columnDefinition = "LONGTEXT")
	private String imageUrl;


    
	public Item() {
		
	}

	public Item(String name, String description,Category category,  String imageUrl){
		super();
        this.name = name;
        this.description = description;
		this.category = category;
        this.imageUrl = imageUrl;
	}

}
