package com.mobile101.tierlistAPI.tierlist.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.boot.archive.scan.spi.ClassDescriptor.Categorization;

import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.TierList;
import com.mobile101.tierlistAPI.tierlist.model.TierListItem;
import com.mobile101.tierlistAPI.tierlist.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TierListJson {
	private long id;
	private String name;
	private User user;
	private LocalDateTime createdAt;
	private String description;
	private Category category;

	public static TierListJson packJson(TierList tierList) {
		TierListJson tierListJson = new TierListJson();
		tierListJson.setId(tierList.getId());
		tierListJson.setName(tierList.getName());
		tierListJson.setUser(tierList.getUser());
		tierListJson.setCreatedAt(tierList.getCreatedAt());
		tierListJson.setDescription(tierList.getDescription());
		tierListJson.setCategory(tierList.getCategory());
		return tierListJson;
	}

	public static List<TierListJson> packJsons(List<TierList> tierLists) {
		List<TierListJson> tierListListJson = new ArrayList<TierListJson>();
		for (TierList tierList : tierLists) {
			tierListListJson.add(packJson(tierList));
		}
		return tierListListJson;
	}

	public TierListJson packJsons_o(Category category, TierList tierList) {
		if (tierList.getCategory().equals(category)) {
			TierListJson tierListJson = new TierListJson();
			tierListJson.setId(tierList.getId());
			tierListJson.setCreatedAt(tierList.getCreatedAt());
			tierListJson.setDescription(tierList.getDescription());
			tierListJson.setUser(tierList.getUser());
			tierListJson.setName(tierList.getName());
			tierListJson.setCategory(tierList.getCategory());
			return tierListJson;
		}
		return null; 
	}
	
}
