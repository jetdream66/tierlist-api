package com.mobile101.tierlistAPI.tierlist.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.json.ItemJson;
import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.Item;
import com.mobile101.tierlistAPI.tierlist.payload.ItemPayload;
import com.mobile101.tierlistAPI.tierlist.service.ItemService;

@Service
public class ItemBusiness {
	@Autowired
	ItemService itemService;

	public List<ItemJson> getListItem() {
		return ItemJson.packJsons(itemService.findAllItems());
	}

	public List<ItemJson> getListItem_Categories(Category category) {
		List<Item> itemsInCategory = itemService.findItemsByCategory(category);
		List<ItemJson> itemJsonList = new ArrayList<>();
		for (Item item : itemsInCategory) {
			ItemJson itemJson = new ItemJson();
			itemJson = itemJson.packJsons_o(category, item);
			if (itemJson != null) {
				itemJsonList.add(itemJson);
			}
		}
		return itemJsonList;
	}
	

	public ItemJson getItemId(long id) {
		return ItemJson.packJson(itemService.findById(id));
	}

	

	public void saveItem(ItemPayload itemPayload) {
		Item item = new Item(
				itemPayload.getName(),
				itemPayload.getDescription(),
				itemPayload.getCategory(),
				itemPayload.getImageUrl());
		itemService.save(item);
	}

	public void updateItem(long id, ItemPayload itemPayload) {
		Item itemData = itemService.findById(id);
		itemData.setName(itemPayload.getName());
		itemData.setCategory(itemPayload.getCategory());
		itemData.setImageUrl(itemPayload.getImageUrl());
		itemData.setDescription(itemPayload.getDescription());
		itemService.save(itemData);
	}

	public void deleteItem(long id) {
		itemService.deleteById(id);
	}
}
