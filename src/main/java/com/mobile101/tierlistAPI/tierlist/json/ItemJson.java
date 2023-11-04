package com.mobile101.tierlistAPI.tierlist.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.Item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemJson {
    private long id;
    private String name;
    private String description;
	private	Category category;
    private String imageUrl;

    public static ItemJson packJson(Item item) {
		ItemJson itemJson = new ItemJson();
		itemJson.setId(item.getId());
		itemJson.setName(item.getName());
        itemJson.setDescription(item.getDescription());
		itemJson.setCategory(item.getCategory());
        itemJson.setImageUrl(item.getImageUrl());
		return itemJson;
	}
	
	public static List<ItemJson> packJsons(List<Item> items) {
		List<ItemJson> itemListJson = new ArrayList<ItemJson>();
		for(Item item:items) {
			itemListJson.add(packJson(item));
		}
		return itemListJson;
	}
	public ItemJson packJsons_o(Category category, Item item) {
		if (item.getCategory().equals(category)) {
			ItemJson itemJson = new ItemJson();
			itemJson.setId(item.getId());
			itemJson.setName(item.getName());
			itemJson.setDescription(item.getDescription());
			itemJson.setCategory(item.getCategory());
			itemJson.setImageUrl(item.getImageUrl());
			return itemJson;
		}
		return null; 
	}
	
	
	
	
}
