package info.techsploit.order_service.controller;

import info.techsploit.order_service.dto.OrderRequest;
import info.techsploit.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String PlaceOrder(@RequestBody OrderRequest orderRequest){

        orderService.PlaceOrder(orderRequest);
        return "Order Place Successfully";
    }
}
