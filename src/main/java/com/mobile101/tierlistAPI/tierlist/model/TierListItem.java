package com.mobile101.tierlistAPI.tierlist.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TierListItems")
@Table(name = "tierlistitems")
public class TierListItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tierlistitem_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tierlist_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	@OnDelete(action = OnDeleteAction.CASCADE) // ใส่ annotation นี้เพื่อกำหนด ON DELETE CASCADE
	private TierList tierList;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Item item;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tier_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Tier tier;

	public TierListItem() {

	}

	public TierListItem(TierList tierlist, Item item, Tier tier) {
		super();
		this.tierList = tierlist;
		this.item = item;
		this.tier = tier;
	}
}
