package com.klef.demo.service;

import com.klef.demo.entity.Item;
import com.klef.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item updateItem(Long id, Item item) {
        Item existing = itemRepository.findById(id).orElse(null);

        if (existing != null) {

            existing.setName(item.getName());
            existing.setCategory(item.getCategory());
            existing.setQuantity(item.getQuantity());
            existing.setLocation(item.getLocation());
            existing.setStatus(item.getStatus());
            existing.setUserId(item.getUserId());

            // ✅ REQUIRED FIX: prevent donorId overwrite
            if (item.getDonorId() != null) {
                existing.setDonorId(item.getDonorId());
            }

            return itemRepository.save(existing);
        }

        return null;
    }

    public List<Item> getItemsByUser(Long userId) {
        return itemRepository.findByUserId(userId);
    }
}