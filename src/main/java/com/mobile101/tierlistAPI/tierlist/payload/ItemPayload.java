package com.mobile101.tierlistAPI.tierlist.payload;

import com.mobile101.tierlistAPI.tierlist.model.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPayload {
    private String name;
    private String description;
    private Category category;
    private String imageUrl;
}
