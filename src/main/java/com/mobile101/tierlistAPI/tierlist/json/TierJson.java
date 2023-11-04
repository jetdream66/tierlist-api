package com.mobile101.tierlistAPI.tierlist.json;

import java.util.ArrayList;
import java.util.List;

import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.Item;
import com.mobile101.tierlistAPI.tierlist.model.Tier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TierJson {
    private long id;
    private String name;
	private Category category;
    public static TierJson packJson(Tier tier) {
		TierJson tierJson = new TierJson();
		tierJson.setId(tier.getId());
        tierJson.setName(tier.getName());
		return tierJson;
	}
	
	public static List<TierJson> packJsons(List<Tier> tiers) {
		List<TierJson> tierListJson = new ArrayList<TierJson>();
		for(Tier tier:tiers) {
			tierListJson.add(packJson(tier));
		}
		return tierListJson;
	}



	public TierJson packJsons_o(Category category, Tier tier) {
		if (tier.getCategory().equals(category)) {
			TierJson tierJson = new TierJson();
			tierJson.setId(tier.getId());
			tierJson.setName(tier.getName());
			tierJson.setCategory(tier.getCategory());
		
			return tierJson;
		}
		return null; 
	}
}
