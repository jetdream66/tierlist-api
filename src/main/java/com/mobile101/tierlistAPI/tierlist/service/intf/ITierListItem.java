package com.mobile101.tierlistAPI.tierlist.service.intf;

import java.util.List;
import java.util.Optional;

import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.Item;
import com.mobile101.tierlistAPI.tierlist.model.TierList;
import com.mobile101.tierlistAPI.tierlist.model.TierListItem;

public interface ITierListItem {
    List<TierListItem> findAllTierListItems();
    TierListItem findById(long id);
    
    TierListItem findByTierId(TierList tierList);

    
    List<TierListItem> findItemsByTierList(TierList tierList);

    TierListItem save(TierListItem tierListItem);
    void deleteById(long id);
    void deleteBytierListId(long id);
    Optional<TierListItem> findOptionalById(long id);
}
