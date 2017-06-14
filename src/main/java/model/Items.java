package model;

import javax.persistence.*;

/**
 * Created by Валентин Фалин on 14.06.2017.
 */
@Entity
@Table(name = "items")
public class Items {
    private int id;
    private String itemId;
    private int itemTotal;
    private int quantity;
    private Cart cart;

    public Items() {
    }

    public Items(String itemId, int itemTotal, int quantity, Cart cart) {
        this.itemId = itemId;
        this.itemTotal = itemTotal;
        this.quantity = quantity;
        this.cart = cart;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "item_id", nullable = false, length = 10)
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Column(name = "item_total", nullable = false, precision = 0)
    public int getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(int itemTotal) {
        this.itemTotal = itemTotal;
    }

    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Items items = (Items) o;

        if (id != items.id) return false;
        if (cart != items.cart) return false;
        if (itemTotal != items.itemTotal) return false;
        if (quantity != items.quantity) return false;
        if (itemId != null ? !itemId.equals(items.itemId) : items.itemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        //result = 31 * result + cart;
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + itemTotal;
        result = 31 * result + quantity;
        return result;
    }
}
