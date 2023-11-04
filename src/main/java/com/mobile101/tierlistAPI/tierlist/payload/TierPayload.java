package com.mobile101.tierlistAPI.tierlist.payload;

import com.mobile101.tierlistAPI.tierlist.model.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TierPayload {
    private String name;
    private Category category;
}
