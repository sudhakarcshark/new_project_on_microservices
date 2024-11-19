package info.techsploit.order_service.service;

import info.techsploit.order_service.dto.OrderLineItemsDto;
import info.techsploit.order_service.dto.OrderRequest;
import info.techsploit.order_service.model.Order;
import info.techsploit.order_service.model.OrderLineItems;
import info.techsploit.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void PlaceOrder(OrderRequest orderRequest){

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

            List<OrderLineItems> orderLineItems  =  orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapTODto)
                .toList();

            order.setOrderLineItems(orderLineItems);
            orderRepository.save(order);

    }

    private OrderLineItems mapTODto(OrderLineItemsDto orderLineItemsDto) {

        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;

    }


}
