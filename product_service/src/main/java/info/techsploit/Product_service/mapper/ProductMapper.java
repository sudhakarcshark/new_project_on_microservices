package info.techsploit.Product_service.mapper;

import info.techsploit.Product_service.model.Product;
import info.techsploit.Product_service.request.ProductRequest;
import info.techsploit.Product_service.response.ProductResponse;

public class ProductMapper {

   public static Product mapperToProduct(ProductRequest request){

       return Product.builder()
               .productName(request.getProductName())
               .productDescription(request.getProductDescription())
               .productPrice(request.getProductPrice())
               .build();
   }

   public static ProductResponse mapperToProductResponse(Product product){
       return ProductResponse.builder()
               .id(product.getId())
               .productName(product.getProductName())
               .productDescription(product.getProductDescription())
               .productPrice(product.getProductPrice())
               .build();
   }
}
