package info.techsploit.Product_service.controller;

import info.techsploit.Product_service.request.ProductRequest;
import info.techsploit.Product_service.response.APIResponse;
import info.techsploit.Product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    ResponseEntity<APIResponse> createProduct(@RequestBody ProductRequest productRequest) {

        return productService.createProduct(productRequest);
    }

    @GetMapping("/get_products")
    ResponseEntity<APIResponse> getProducts(){
        return productService.getProducts();
    }

    }
