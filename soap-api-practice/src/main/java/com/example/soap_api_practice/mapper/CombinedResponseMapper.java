package com.example.soap_api_practice.mapper;

import com.example.soap_api_practice.dtos.combinedResponseDtos.CombinedResponse;
import com.example.soap_api_practice.dtos.combinedResponseDtos.OrderItem;
import com.example.soap_api_practice.dtos.combinedResponseDtos.OrderShipment;
import com.example.soap_api_practice.dtos.combinedResponseDtos.PlacedOrder;
import com.example.soap_api_practice.dtos.generatedService1Dtos.Item;
import com.example.soap_api_practice.dtos.generatedService1Dtos.Order;
import com.example.soap_api_practice.dtos.generatedService1Dtos.Service1Envelope;
import com.example.soap_api_practice.dtos.generatedService2Dtos.Service2Envelope;
import org.mapstruct.*;
import org.mapstruct.ap.shaded.freemarker.template.SimpleDate;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CombinedResponseMapper {

    /*@Mapping(target = "getCusotmerOrdersResponse.orderStatus.orderState", source = "res1.body.getOrdersResponse.status.message")
    @Mapping(target = "getCusotmerOrdersResponse.orderStatus.orderSummary.totalCount", source = "res2.body.createOrderResponse.summary.totalItems")
    @Mapping(target = "getCusotmerOrdersResponse.orderStatus.orderSummary.totalPrice", source = "res2.body.createOrderResponse.summary.totalAmount.value")
    @Mapping(target = "getCusotmerOrdersResponse.placedOrders", source = "res1.body.getOrdersResponse.orders.order", qualifiedByName = "orderToPlacedOrder")
    CombinedResponse formCombinedResponse(Service1Envelope res1, Service2Envelope res2);


    @Named("orderToPlacedOrder")
    @Mapping(target = "orderId", source = "id")
    @Mapping(target = "orderItems", source = "items.item", qualifiedByName = "itemToOrderItem")
    PlacedOrder orderToPlacedOrder(Order order);



    @Named("itemToOrderItem")
    default List<OrderItem> itemToOrderItem(List<Item> items, Service2Envelope res2){
       return items.stream().map(item -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setItemName(item.getName());
            orderItem.setOrderShipment(new OrderShipment());
            orderItem.getOrderShipment().setCarrierName(res2.getBody().getCreateOrderResponse().getShipment().getCarrier());
            orderItem.getOrderShipment().setEstimatedTime(new Date(res2.getBody().getCreateOrderResponse().getShipment().getEstimatedDelivery()));
            return orderItem;
        }).toList();

    }

        *//*@Named("itemToOrderItem")
    @Mapping(target = "itemName", source = "name")
    @Mapping(target = "orderShipment", qualifiedByName = "res2ToOrderItem")
    OrderItem itemToOrderItem(Item item);*//*


    *//*@Named("res2ToOrderItem")
    @Mapping(target = "carrierName", source = "res2.body.createOrderResponse.shipment.carrier")
    @Mapping(target = "estimatedTime", source = "res2.body.createOrderResponse.shipment.estimatedDelivery")
    OrderShipment res2ToOrderItem(Service2Envelope res2);*/

    @Mapping(target = "getCusotmerOrdersResponse.orderStatus.orderState", source = "service1Envelope.body.getOrdersResponse.status.message")
    @Mapping(target = "getCusotmerOrdersResponse.orderStatus.orderSummary.totalCount", source = "service2Envelope.body.createOrderResponse.summary.totalItems")
    @Mapping(target = "getCusotmerOrdersResponse.orderStatus.orderSummary.totalPrice", source = "service2Envelope.body.createOrderResponse.summary.totalAmount.value")
    @Mapping(target = "getCusotmerOrdersResponse.placedOrders", ignore = true)
    CombinedResponse formCombinedResponse(Service1Envelope service1Envelope, Service2Envelope service2Envelope);

    @AfterMapping
    default void setPlaceOrders(@MappingTarget CombinedResponse combinedResponse, Service1Envelope res1, Service2Envelope res2){
        List<Order> orders = res1.getBody().getGetOrdersResponse().getOrders().getOrder();
        List<PlacedOrder> po = orders.stream().map(order -> {
            PlacedOrder placedOrder = new PlacedOrder();
            placedOrder.setOrderId(order.getId().intValue());
            placedOrder.setOrderItems(mapOrderItems(order.getItems().getItem(), res2));
            return placedOrder;
        }).toList();
        combinedResponse.getGetCusotmerOrdersResponse().setPlacedOrders(po);
    }


    default List<OrderItem> mapOrderItems(List<Item> items, Service2Envelope res2){
        return items.stream().map(item ->{
            OrderItem orderItem = new OrderItem();
            orderItem.setItemName(item.getName());

            OrderShipment orderShipment = new OrderShipment();
            orderShipment.setCarrierName(res2.getBody().getCreateOrderResponse().getShipment().getCarrier());
            LocalDate localDate = LocalDate.parse(res2.getBody().getCreateOrderResponse().getShipment().getEstimatedDelivery());
            Date date = Date.from(
                    localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()
            );
        orderShipment.setEstimatedTime(date);

            orderItem.setOrderShipment(orderShipment);
            return orderItem;
        }).toList();

    }

}


