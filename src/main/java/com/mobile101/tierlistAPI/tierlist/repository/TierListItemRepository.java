package com.mobile101.tierlistAPI.tierlist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.Item;
import com.mobile101.tierlistAPI.tierlist.model.TierList;
import com.mobile101.tierlistAPI.tierlist.model.TierListItem;

@Repository
public interface TierListItemRepository extends JpaRepository<TierListItem, Long>{
    TierListItem findById(long id);
    
    TierListItem findByTierId(TierList tierList);

    List<TierListItem> findByTierList(TierList tierList);

    Optional<TierListItem> findOptionalById(long id);
}
