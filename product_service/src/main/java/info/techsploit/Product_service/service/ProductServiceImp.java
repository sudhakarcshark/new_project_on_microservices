package info.techsploit.Product_service.service;

import info.techsploit.Product_service.mapper.ProductMapper;
import info.techsploit.Product_service.model.Product;
import info.techsploit.Product_service.repository.ProductRepository;
import info.techsploit.Product_service.request.ProductRequest;
import info.techsploit.Product_service.response.APIResponse;
import info.techsploit.Product_service.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService{

    private final  ProductRepository productRepository;

    @Override
    public ResponseEntity<APIResponse> createProduct(ProductRequest productRequest) {

       Product product = productRepository.save(ProductMapper.mapperToProduct(productRequest));

        return ResponseEntity.ok(APIResponse
                .builder()
                .errorMsg("SUCCESSFULLY_STORED")
                .errorId(0)
                .data(ProductMapper.mapperToProductResponse(product))
                .build()
        );
    }

    @Override
    public ResponseEntity<APIResponse> getProducts() {

      List<Product> productslist =  productRepository.findAll();

     List<ProductResponse> productResponseList = productslist.stream()
              .map(Product-> ProductMapper.mapperToProductResponse(Product)).toList();

        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorId(0)
                        .errorMsg("PRODUCT_LIST")
                        .data(productResponseList)
                        .build()
        );
    }
}
