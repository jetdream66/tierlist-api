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
import com.mobile101.tierlistAPI.tierlist.business.TierListBusiness;
import com.mobile101.tierlistAPI.tierlist.business.TierListItemBusiness;
import com.mobile101.tierlistAPI.tierlist.json.TierListItemJson;
import com.mobile101.tierlistAPI.tierlist.json.TierListJson;
import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.TierList;
import com.mobile101.tierlistAPI.tierlist.payload.TierListPayload;
import com.mobile101.tierlistAPI.tierlist.service.TierListService;

@RestController
@RequestMapping("/api")
public class TierListController {
    @Autowired
	TierListService tierListService;
	
	@Autowired
	TierListBusiness tierListBusiness;
	@Autowired
	TierListItemBusiness tierListItemBusiness;

	public TierListController(TierListService tierListService) {
		this.tierListService = tierListService;
	}
	
	@PostMapping("/tierLists")
	public ResponseEntity<Long> saveTierList(@RequestBody TierListPayload payload) throws BaseException {
		Long tierListId = tierListBusiness.saveTierList(payload);
		return new ResponseEntity<>(tierListId, HttpStatus.CREATED);
		
	}
	@GetMapping(value = "/tierLists_category/{category_id}")
	public ResponseEntity<List<TierListJson>> getTierList_category(@PathVariable("category_id") Category category) throws BaseException {
		return ResponseEntity.ok(tierListBusiness.getListItem_Category(category));
	}
	@GetMapping(value = "/tierLists")
	public ResponseEntity<List<TierListJson>> getAllTierLists() throws BaseException{
		return ResponseEntity.ok(tierListBusiness.getListTierList());
	}
	
	@GetMapping(value = "/tierLists/{id}")
	public ResponseEntity<TierListJson> getTierListById(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(tierListBusiness.getTierListId(id));
	}
	
    @PutMapping(value = "/tierLists/{id}")
	public ResponseEntity<TierListJson> updatetierList(@PathVariable("id") long id, @RequestBody TierListPayload payload){
		Optional<TierList> tierListData = tierListService.findOptionalById(id);
		if(tierListData.isPresent()) {
			tierListBusiness.updateTierList(tierListData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/tierLists/{id}")
	public ResponseEntity<TierListJson> deleteTierListById(@PathVariable("id") long id) {
		try {

		
			tierListBusiness.deleteTierList(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
