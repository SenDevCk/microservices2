package com.chandan.inventory_service.services;

import java.util.List;

import com.chandan.inventory_service.dtos.InventoryDto;

public interface InventoryService {
      
	List<InventoryDto> isAvailable(List<String> skuCode);

}
