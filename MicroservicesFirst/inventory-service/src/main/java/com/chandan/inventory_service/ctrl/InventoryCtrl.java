package com.chandan.inventory_service.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.inventory_service.dtos.InventoryDto;
import com.chandan.inventory_service.services.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryCtrl {
	
	@Autowired
	InventoryService inventoryService;
    
	@GetMapping("/isInStock")
	private List<InventoryDto> isAvailableInStock(@RequestParam List<String> skuCodes) {
		return inventoryService.isAvailable(skuCodes);
	}
}
