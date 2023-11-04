package com.mobile101.tierlistAPI.tierlist.service.intf;

import java.util.List;
import java.util.Optional;

import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.TierList;

public interface ITierList {
    List<TierList> findAllTierLists();
	TierList findById(long id);
	TierList findByUserId(long id);
	TierList findByName(String name);
	TierList save(TierList tierList);
	List<TierList> findByCategory(Category category);
	
	void deleteById(long id);
	Optional<TierList> findOptionalById(long id);
}
