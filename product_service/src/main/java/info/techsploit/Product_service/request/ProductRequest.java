package info.techsploit.Product_service.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class ProductRequest {

    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
}
