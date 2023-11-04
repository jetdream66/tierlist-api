package com.mobile101.tierlistAPI.tierlist.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.json.ItemJson;
import com.mobile101.tierlistAPI.tierlist.json.TierListJson;
import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.Item;
import com.mobile101.tierlistAPI.tierlist.model.TierList;
import com.mobile101.tierlistAPI.tierlist.payload.TierListPayload;
import com.mobile101.tierlistAPI.tierlist.service.TierListService;

@Service
public class TierListBusiness {
	@Autowired
	TierListService tierListService;

	public List<TierListJson> getListTierList() {
		return TierListJson.packJsons(tierListService.findAllTierLists());
	}

	public TierListJson getTierListId(long id) {
		return TierListJson.packJson(tierListService.findById(id));
	}

	public Long saveTierList(TierListPayload tierListPayload) {
		TierList tierList = new TierList(
				tierListPayload.getName(),
				tierListPayload.getUser(),
				tierListPayload.getDescription(),
				tierListPayload.getCreatedAt(),
				tierListPayload.getCategory());
		tierListService.save(tierList);

		return tierList.getId();

	}

	public List<TierListJson> getListItem_Category(Category category) {
		List<TierList> tierListsInCategory = tierListService.findByCategory(category);
		List<TierListJson> tierListJsonList = new ArrayList<>();
		for (TierList tierList : tierListsInCategory) {
			TierListJson TierListJson = new TierListJson();
			TierListJson = TierListJson.packJsons_o(category, tierList);
			if (TierListJson != null) {
				tierListJsonList.add(TierListJson);
			}
		}
		return tierListJsonList;
	}

	public void updateTierList(long id, TierListPayload tierListPayload) {
		TierList tierListData = tierListService.findById(id);
		tierListData.setName(tierListPayload.getName());
		tierListData.setUser(tierListPayload.getUser());
		tierListData.setDescription(tierListPayload.getDescription());
		tierListData.setCreatedAt(tierListPayload.getCreatedAt());
		tierListData.setCategory(tierListPayload.getCategory());
		tierListService.save(tierListData);
	}

	public void deleteTierList(long id) {
		tierListService.deleteById(id);
	}
}
