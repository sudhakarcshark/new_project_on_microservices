package info.techsploit.Product_service.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class ProductResponse {
    private String id;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
}
