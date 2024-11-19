package info.techsploit.Product_service.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class Product {

    @Id
    private String id;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
}
