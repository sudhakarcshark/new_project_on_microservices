package info.techsploit.inventory_service.service;

import info.techsploit.inventory_service.model.Inventory;
import info.techsploit.inventory_service.repository.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepo inventoryRepo;

     @Transactional(readOnly = true)
     public boolean isInStock(String skuCode){

        return inventoryRepo.findBySkuCode(skuCode).isPresent();

     }
}
