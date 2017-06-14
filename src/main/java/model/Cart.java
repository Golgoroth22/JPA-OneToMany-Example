package model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Валентин Фалин on 14.06.2017.
 */
@Entity
@Table(name = "cart")
public class Cart {
    private int cartId;
    private int total;
    private String name;
    private Set<Items> items;

    public Cart() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Column(name = "total", nullable = false, precision = 0)
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Column(name = "name", nullable = true, length = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "cart")
    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (cartId != cart.cartId) return false;
        if (total != cart.total) return false;
        if (name != null ? !name.equals(cart.name) : cart.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartId;
        result = 31 * result + total;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
