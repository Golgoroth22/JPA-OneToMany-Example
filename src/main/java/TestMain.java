import Utils.HibernateSessionFactory;
import model.Cart;
import model.Items;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Валентин Фалин on 14.06.2017.
 */
public class TestMain {
    public static void main(String[] args) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        System.out.println("Session created");

        //Create/Insert
        //---------------------------------------------------------------------------
        Transaction transaction = session.beginTransaction();

        Cart cart1 = new Cart();
        cart1.setName("MyCart1");

        Items items1 = new Items("I10", 10, 1, cart1);
        Items items2 = new Items("I20", 20, 2, cart1);

        Set<Items> itemsSet = new HashSet<>();
        itemsSet.add(items1);
        itemsSet.add(items2);

        cart1.setItems(itemsSet);
        cart1.setTotal(10 * 1 + 20 * 2);
        session.save(cart1);
        session.save(items1);
        session.save(items2);

        transaction.commit();
        //---------------------------------------------------------------------------

        //Update
        //---------------------------------------------------------------------------
        Transaction transaction1 = session.beginTransaction();
        Query query = session.createQuery("update Items set quantity = :newQ where itemTotal = :it");
        query.setParameter("newQ", 2);
        query.setParameter("it", 10);
        query.executeUpdate();
        transaction1.commit();
        //---------------------------------------------------------------------------

        //Read/Get
        //---------------------------------------------------------------------------
        Transaction transaction2 = session.beginTransaction();
        Query query1 = session.createQuery("from Items as i INNER JOIN FETCH i.cart as c");
        List list = query1.list();
        System.out.println(list.size());
        for (Object obj : list) {
            System.out.println(obj.toString());
        }
        transaction2.commit();
        //---------------------------------------------------------------------------

        //Delete
        //---------------------------------------------------------------------------
        Transaction transaction3 = session.beginTransaction();
        Query query2 = session.createQuery("delete Items where itemId = :id");
        query2.setParameter("id", "I10");
        query2.executeUpdate();
        transaction3.commit();
        //---------------------------------------------------------------------------

        HibernateSessionFactory.shutdown();
    }
}
