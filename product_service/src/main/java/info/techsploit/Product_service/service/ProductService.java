package info.techsploit.Product_service.service;

import info.techsploit.Product_service.request.ProductRequest;
import info.techsploit.Product_service.response.APIResponse;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<APIResponse>  createProduct(ProductRequest productRequest);
    ResponseEntity<APIResponse>  getProducts();
}
