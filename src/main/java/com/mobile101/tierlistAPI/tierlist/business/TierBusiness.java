package com.mobile101.tierlistAPI.tierlist.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.json.ItemJson;
import com.mobile101.tierlistAPI.tierlist.json.TierJson;
import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.Item;
import com.mobile101.tierlistAPI.tierlist.model.Tier;
import com.mobile101.tierlistAPI.tierlist.payload.TierPayload;
import com.mobile101.tierlistAPI.tierlist.service.TierService;

@Service
public class TierBusiness {
    @Autowired
	TierService tierService;
	
	public List<TierJson> getListTier() {
		return TierJson.packJsons(tierService.findAllTiers());
	}
	public TierJson getTierId(long id) {
		return TierJson.packJson(tierService.findById(id));
	}


	public List<TierJson> getListTiers_Categories(Category category) {
		List<Tier> tiersInCategory = tierService.findTiersByCategory(category);
		List<TierJson> tiersJsonList = new ArrayList<>();
		for (Tier tier : tiersInCategory) {
			TierJson tierJson = new TierJson();
			tierJson = tierJson.packJsons_o(category, tier);
			if (tier != null) {
				tiersJsonList.add(tierJson);
			}
		}
		return tiersJsonList;
	}


	public void saveTier(TierPayload tierPayload) {
		Tier tier = new Tier(
				tierPayload.getName(),
				tierPayload.getCategory());
		tierService.save(tier);
	}
	public void updateTier(long id, TierPayload tierPayload) {
		Tier tierData = tierService.findById(id);
		tierData.setName(tierPayload.getName());
		tierService.save(tierData);
	}
	public void deleteTier(long id) {
		tierService.deleteById(id);
	}
}
