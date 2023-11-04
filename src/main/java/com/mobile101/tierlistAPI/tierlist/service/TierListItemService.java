package com.mobile101.tierlistAPI.tierlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.Item;
import com.mobile101.tierlistAPI.tierlist.model.TierList;
import com.mobile101.tierlistAPI.tierlist.model.TierListItem;
import com.mobile101.tierlistAPI.tierlist.repository.TierListItemRepository;
import com.mobile101.tierlistAPI.tierlist.service.intf.ITierListItem;

@Service
public class TierListItemService implements ITierListItem {

    @Autowired
    TierListItemRepository tierListItemRepository;

    @Override
    public List<TierListItem> findAllTierListItems() {
        return tierListItemRepository.findAll();
    }

    @Override
    public TierListItem findById(long id) {
        return tierListItemRepository.findById(id);
    }

    @Override
    public List<TierListItem> findItemsByTierList(TierList tierList) {
        return tierListItemRepository.findByTierList(tierList);
    }

    @Override
    public TierListItem findByTierId(TierList tierList) {
        return tierListItemRepository.findByTierId(tierList);
    }

    @Override
    public TierListItem save(TierListItem tierListItem) {
        return tierListItemRepository.save(tierListItem);
    }

    @Override
    public void deleteById(long id) {
        tierListItemRepository.deleteById(id);
    }

    @Override
    public void deleteBytierListId(long id) {
        tierListItemRepository.deleteById(id);
    }

    @Override
    public Optional<TierListItem> findOptionalById(long id) {
        return tierListItemRepository.findOptionalById(id);
    }

}
