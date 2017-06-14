import Utils.HibernateSessionFactory;
import model.Cart;
import model.Items;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Валентин Фалин on 14.06.2017.
 */
public class TestMain {
    public static void main(String[] args) {
        Cart cart1 = new Cart();
        cart1.setName("MyCart1");

        Items items1 = new Items("I10", 10, 1, cart1);
        Items items2 = new Items("I20", 20, 2, cart1);

        Set<Items> itemsSet = new HashSet<>();
        itemsSet.add(items1);
        itemsSet.add(items2);

        cart1.setItems(itemsSet);
        cart1.setTotal(10 * 1 + 20 * 2);

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        System.out.println("Session created");

        Transaction transaction = session.beginTransaction();
        session.save(cart1);
        session.save(items1);
        session.save(items2);
        transaction.commit();

        HibernateSessionFactory.shutdown();
    }
}
