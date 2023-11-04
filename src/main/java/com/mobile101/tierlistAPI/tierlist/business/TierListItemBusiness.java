package com.mobile101.tierlistAPI.tierlist.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.json.ItemJson;
import com.mobile101.tierlistAPI.tierlist.json.TierListItemJson;
import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.Item;
import com.mobile101.tierlistAPI.tierlist.model.TierList;
import com.mobile101.tierlistAPI.tierlist.model.TierListItem;
import com.mobile101.tierlistAPI.tierlist.payload.TierListItemPayload;
import com.mobile101.tierlistAPI.tierlist.service.TierListItemService;

@Service
public class TierListItemBusiness {
	@Autowired
	TierListItemService tierListItemService;
	
	public List<TierListItemJson> getListTierListItem() {
		return TierListItemJson.packJsons(tierListItemService.findAllTierListItems());
	}

	public TierListItemJson getTierListItemId(long id) {
		return TierListItemJson.packJson(tierListItemService.findById(id));
	}

	public TierListItemJson getTierListItemByTierList(TierList tierList) {
		return TierListItemJson.packJson(tierListItemService.findByTierId(tierList));
	}

	public Long saveTierListItem(TierListItemPayload tierListItemPayload) {
		TierListItem tierListItem = new TierListItem(
				tierListItemPayload.getTierList(),
				tierListItemPayload.getItem(),
				tierListItemPayload.getTier());
		tierListItemService.save(tierListItem);
		return tierListItem.getId();
	}

	public List<TierListItemJson> getListItem_Tierlist(TierList tierList) {
		List<TierListItem> itemsInThisTierList = tierListItemService.findItemsByTierList(tierList);
		List<TierListItemJson> itemThisTierListJsonList = new ArrayList<>();
		for (TierListItem tierListItem : itemsInThisTierList) {
			TierListItemJson tierListItemJson = new TierListItemJson();
			tierListItemJson = tierListItemJson.packJsons_o(tierList, tierListItem);
			if (tierListItemJson != null) {
				itemThisTierListJsonList.add(tierListItemJson);
			}
		}
		return itemThisTierListJsonList;
	}

	public void updateTierListItem(long id, TierListItemPayload tierListItemPayload) {
		TierListItem tierListItemData = tierListItemService.findById(id);
		tierListItemData.setTierList(tierListItemPayload.getTierList());
		tierListItemData.setItem(tierListItemPayload.getItem());
		tierListItemData.setTier(tierListItemPayload.getTier());
		tierListItemService.save(tierListItemData);
	}

	public void deleteTierListItem(long id) {
		tierListItemService.deleteById(id);
	}
	public void deleteTierListItemBytierListId(long tierListId) {
		tierListItemService.deleteBytierListId(tierListId);
	}
}	
