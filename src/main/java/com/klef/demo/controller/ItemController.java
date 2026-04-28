package com.klef.demo.controller;

import com.klef.demo.entity.Item;
import com.klef.demo.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "https://aidlink-app.netlify.app/")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // ✅ CREATE
    @PostMapping("/add")
    public Item addItem(@RequestBody Item item) {
        item.setStatus("REQUESTED");
        item.setDonorId(null);
        return itemService.addItem(item);
    }

    // ✅ GET ALL
    @GetMapping("/display")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // ✅ GET BY USER
    @GetMapping("/user/{userId}")
    public List<Item> getUserItems(@PathVariable Long userId) {
        return itemService.getItemsByUser(userId);
    }

    // ✅ UPDATE
    @PutMapping("/update/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    // ✅ DONATE (FIXED ONLY HERE)
    @PutMapping("/donate/{id}/{donorId}")
    public Item donateItem(@PathVariable Long id, @PathVariable Long donorId) {

        // get existing item first
        Item existing = itemService.getAllItems()
                .stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElseThrow();

        existing.setDonorId(donorId);
        existing.setStatus("PENDING");

        return itemService.addItem(existing);
    }
}