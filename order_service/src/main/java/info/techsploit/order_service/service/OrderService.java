package info.techsploit.order_service.service;

import info.techsploit.order_service.dto.InventoryResponse;
import info.techsploit.order_service.dto.OrderLineItemsDto;
import info.techsploit.order_service.dto.OrderRequest;
import info.techsploit.order_service.model.Order;
import info.techsploit.order_service.model.OrderLineItems;
import info.techsploit.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final WebClient webClient;

    public void PlaceOrder(OrderRequest orderRequest){

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

            List<OrderLineItems> orderLineItems  =  orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapTODto)
                .toList();

            order.setOrderLineItems(orderLineItems);

          List<String> skuCodes = order.getOrderLineItems().stream()
                    .map(OrderLineItems::getSkuCode)
                    .toList();

        //Call Inventory Service, and place order if product is in stock

        InventoryResponse[]  inventoryResponsesArray  =    webClient.get()
                        .uri("http://localhost:8011/api/inventory",
                                uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                                .retrieve()
                                        .bodyToMono(InventoryResponse[].class)
                                                .block();

       boolean allProductsInStock = Arrays.stream(inventoryResponsesArray)
                .allMatch(InventoryResponse::isInStock);


        if (allProductsInStock){
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in stock, please try after some time");
        }


    }

    private OrderLineItems mapTODto(OrderLineItemsDto orderLineItemsDto) {

        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;

    }


}
