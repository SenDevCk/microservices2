package com.chandan.inventory_service.repogetory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandan.inventory_service.dtos.InventoryDto;
import com.chandan.inventory_service.models.Inventory;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Long>{

	List<Inventory> findBySkuCodeIn(List<String> skuCode);

}
