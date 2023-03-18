package design.cardia.apiratelimitdemo.controller

import design.cardia.apiratelimitdemo.model.Order
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class OrderController {
    @GetMapping("/order", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getOrder(): ResponseEntity<Order> {
        val order = Order("Order One", "Order One Description")
        return ResponseEntity.ok(order)
    }
}