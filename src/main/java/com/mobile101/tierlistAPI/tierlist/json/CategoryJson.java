package com.mobile101.tierlistAPI.tierlist.json;

import java.util.ArrayList;
import java.util.List;

import com.mobile101.tierlistAPI.tierlist.model.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryJson {
    private long id;
    private String name;
    private String image;

    public static CategoryJson packJson(Category category) {
		CategoryJson categoryJson = new CategoryJson();
		categoryJson.setId(category.getId());
		categoryJson.setName(category.getName());
		categoryJson.setImage(category.getImage());
		return categoryJson;
	}
	
	public static List<CategoryJson> packJsons(List<Category> categorys) {
		List<CategoryJson> categoryListJson = new ArrayList<CategoryJson>();
		for(Category category:categorys) {
			categoryListJson.add(packJson(category));
		}
		return categoryListJson;
	}
}
