import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.util.List;

/*
start mysql server:
docker run --rm --name mas-mysql -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=mas_db -p3306:3306 mysql
 */

public class Main {
    public static void main(String[] args) {
        db();
    }

    public static void db() {
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;

        try {
            registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            var metadata = new MetadataSources(registry)
                    .getMetadataBuilder()
                    .build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();

            var session = sessionFactory.openSession();
            session.beginTransaction();

            var p1 = new Product("premium shoes");
            p1.setIntroductionDate(LocalDate.of(2020, 1, 15));
            p1.setWeight(0.5);

            var p2 = new Product("special game");
            p2.setIntroductionDate(LocalDate.of(2019, 5, 1));

            var s1 = new Shop();
//            s1.addProduct(p1);
//            s1.addProduct(p2);

            session.save(p1);
            session.save(p2);
            session.save(s1);

            session.getTransaction().commit();

            // reading
            session.beginTransaction();
            List<Product> productList = session.createQuery("from Product").list();
            for (var product : productList) {
                System.out.println(product);
            }

            List<Shop> shopList = session.createQuery("from Shop").list();
            for (var shop : shopList) {
                System.out.println(shop);
            }

            session.getTransaction().commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}

