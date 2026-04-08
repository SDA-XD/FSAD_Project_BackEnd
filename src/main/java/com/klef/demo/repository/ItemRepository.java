package com.klef.demo.repository;

import com.klef.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByUserId(Long userId);

    List<Item> findByDonorId(Long donorId); // 👈 REQUIRED
}