package com.chandan.inventory_service.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chandan.inventory_service.dtos.InventoryDto;
import com.chandan.inventory_service.models.Inventory;
import com.chandan.inventory_service.repogetory.InventoryRepo;
import com.chandan.inventory_service.services.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	InventoryRepo inventoryRepo;

	@Override
	public List<InventoryDto> isAvailable(List<String> skuCodes) {
		// TODO Auto-generated method stub
		List<InventoryDto> skuCodeDtos=new ArrayList<>();
		List<String> data=inventoryRepo.findBySkuCodeIn(skuCodes).stream().map(item->item.getSkuCode()).toList();
		for (String skuCode:skuCodes) {
			if(data.contains(skuCode)) {
				skuCodeDtos.add(InventoryDto.builder().skuCode(skuCode).isAvailable(true).build());
			}else {
				skuCodeDtos.add(InventoryDto.builder().skuCode(skuCode).isAvailable(false).build());
			}
		}
		return skuCodeDtos;
	}
   private InventoryDto mapToInventoryDto(Inventory inventory) {
	   return InventoryDto.builder().skuCode(inventory.getSkuCode()).isAvailable(true).build();
   }
}
