package ru.mvgrebenyuk.hiberOne.DAO;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mvgrebenyuk.hiberOne.Client;
import ru.mvgrebenyuk.hiberOne.DaoInterfaces.ClientDao;
import ru.mvgrebenyuk.hiberOne.Product;
import ru.mvgrebenyuk.hiberOne.SessionFactoryUtils;

import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {
    private SessionFactoryUtils sessionFactoryUtils;

    @Autowired
    public ClientDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Client findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.getTransaction().commit();
            return client;
        }
    }

    @Override
    public Client findByName(String name) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, name);
            session.getTransaction().commit();
            return client;
        }
    }

    @Override
    public List<Client> getAllClients() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Client> clients = session.createQuery("select c from Client c")
                    .getResultList();
            session.getTransaction().commit();
            return clients;
        }
    }

    @Override
    public void updateOrSaveClient(Client client) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeClient(Client client) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.remove(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Product> getProductsByCID(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            System.out.println(client);
            List<Product> products = client.getProducts();
            Hibernate.initialize(products);
            session.getTransaction().commit();
            return products;
        }
    }
}
