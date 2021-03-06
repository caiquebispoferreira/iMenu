package ca.ibs.imenu.dto;

import ca.ibs.imenu.entity.OrderItem;
import ca.ibs.imenu.entity.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItemDTO implements Serializable {
    private Long id;
    private ProductDTO product;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
    private boolean delivered;
    private boolean reviewed;
    public OrderItemDTO(OrderItem item){
        this.id = item.getId();
        this.product = new ProductDTO(item.getProduct());
        this.quantity = item.getQuantity();
        this.unitPrice = item.getUnitPrice();
        this.totalPrice = item.getTotalPrice();
        this.delivered = item.isDelivered();
        this.reviewed = item.isReviewed();
    }
}

