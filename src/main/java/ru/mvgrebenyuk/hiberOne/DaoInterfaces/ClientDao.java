package ru.mvgrebenyuk.hiberOne.DaoInterfaces;

import ru.mvgrebenyuk.hiberOne.Client;
import ru.mvgrebenyuk.hiberOne.Product;

import java.util.List;

public interface ClientDao {

    Client findById(Long id);

    Client findByName(String name);

    List<Client> getAllClients();

    void updateOrSaveClient(Client client);

    void removeClient(Client client);

    List<Product> getProductsByCID(Long id);
}
