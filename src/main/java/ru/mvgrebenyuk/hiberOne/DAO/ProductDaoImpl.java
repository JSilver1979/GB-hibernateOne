package ru.mvgrebenyuk.hiberOne.DAO;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mvgrebenyuk.hiberOne.Client;
import ru.mvgrebenyuk.hiberOne.DaoInterfaces.ProductDao;
import ru.mvgrebenyuk.hiberOne.Product;
import ru.mvgrebenyuk.hiberOne.SessionFactoryUtils;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private SessionFactoryUtils sessionFactoryUtils;

    @Autowired
    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session
                    .createQuery("select p from Product p")
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.remove(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveOrUpdate(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Client> getClientsByPID(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            List<Client> clients = product.getClients();
            Hibernate.initialize(clients);
            session.getTransaction().commit();
            return clients;
        }
    }
}
