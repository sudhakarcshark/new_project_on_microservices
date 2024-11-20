package info.techsploit.inventory_service.service;

import info.techsploit.inventory_service.dto.InventoryResponse;
import info.techsploit.inventory_service.model.Inventory;
import info.techsploit.inventory_service.repository.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepo inventoryRepo;

     @Transactional(readOnly = true)
     public List<InventoryResponse> isInStock(List<String> skuCode){

        return inventoryRepo.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity() > 10)
                            .build()
                ).toList();
     }
}
