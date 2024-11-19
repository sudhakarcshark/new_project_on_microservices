package info.techsploit.order_service.dto;

import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderRequest {

    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
