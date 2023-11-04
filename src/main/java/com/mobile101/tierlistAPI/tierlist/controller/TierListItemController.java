package com.mobile101.tierlistAPI.tierlist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile101.tierlistAPI.exception.BaseException;
import com.mobile101.tierlistAPI.tierlist.business.TierListItemBusiness;
import com.mobile101.tierlistAPI.tierlist.json.ItemJson;
import com.mobile101.tierlistAPI.tierlist.json.TierListItemJson;
import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.TierList;
import com.mobile101.tierlistAPI.tierlist.model.TierListItem;
import com.mobile101.tierlistAPI.tierlist.payload.TierListItemPayload;
import com.mobile101.tierlistAPI.tierlist.service.TierListItemService;

@RestController
@RequestMapping("/api")
public class TierListItemController {
    @Autowired
	TierListItemService tierListItemService;
	
	@Autowired
	TierListItemBusiness tierListItemBusiness;

	public TierListItemController(TierListItemService tierListItemService) {
		this.tierListItemService = tierListItemService;
	}
	
	@PostMapping("/tierListItems")
	public ResponseEntity<Long> saveTierListItem(@RequestBody TierListItemPayload payload) throws BaseException {
		Long tierlistItemId = tierListItemBusiness.saveTierListItem(payload);
		return new ResponseEntity<>(tierlistItemId, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/tierListItems")
	public ResponseEntity<List<TierListItemJson>> getAllTierListItems() throws BaseException{
		return ResponseEntity.ok(tierListItemBusiness.getListTierListItem());
	}
	
	@GetMapping(value = "/tierListItems/{id}")
	public ResponseEntity<TierListItemJson> getTierListItemById(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(tierListItemBusiness.getTierListItemId(id));
	}

	@GetMapping(value = "/tierListItems_Tierlist/{tierList_id}")
	public ResponseEntity<TierListItemJson> getTierListItemByTierList(@PathVariable("tierList_id") TierList tierList) throws BaseException{
		return ResponseEntity.ok(tierListItemBusiness.getTierListItemByTierList(tierList));
	}
	
	@GetMapping(value = "/items_tierList/{tierList_id}")
	public ResponseEntity<List<TierListItemJson>> getIteminThisTierList(@PathVariable("tierList_id") TierList tierList) throws BaseException {
		return ResponseEntity.ok(tierListItemBusiness.getListItem_Tierlist(tierList));
	}

    @PutMapping(value = "/tierListItems/{id}")
	public ResponseEntity<TierListItemJson> updatetierListItem(@PathVariable("id") long id, @RequestBody TierListItemPayload payload){
		Optional<TierListItem> tierListItemData = tierListItemService.findOptionalById(id);
		if(tierListItemData.isPresent()) {
			tierListItemBusiness.updateTierListItem(tierListItemData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/tierListItems/{id}")
	public ResponseEntity<TierListItemJson> deleteTierListItemById(@PathVariable("id") long id) {
		try {
			tierListItemBusiness.deleteTierListItem(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
