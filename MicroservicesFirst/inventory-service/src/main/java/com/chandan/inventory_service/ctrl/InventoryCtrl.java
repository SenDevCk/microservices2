package com.chandan.inventory_service.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryCtrl {
    
	@GetMapping("/is")
	private String isAvailable(@RequestParam List<String> skuCode) {
		return "";
	}
}
