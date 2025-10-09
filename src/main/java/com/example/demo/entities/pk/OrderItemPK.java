// Represents a composite primary key for the OrderItem entity
package com.example.demo.entities.pk;

import com.example.demo.entities.Order;
import com.example.demo.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemPK {

    @ManyToOne
    @JoinColumn(name = "order_id") // Foreign key reference to Order
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id") // Foreign key reference to Product
    private Product product;


    // Composite key equality based on order and product
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
