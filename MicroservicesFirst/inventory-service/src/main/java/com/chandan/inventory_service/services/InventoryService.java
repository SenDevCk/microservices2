package com.chandan.inventory_service.services;

import java.util.List;

import com.chandan.inventory_service.dtos.InventoryDto;
import com.chandan.inventory_service.dtos.InventoryRequestDto;
import com.chandan.inventory_service.models.Inventory;

public interface InventoryService {
      
	List<InventoryDto> isAvailable(List<String> skuCode);

	Inventory save(InventoryRequestDto reqDto);

}
