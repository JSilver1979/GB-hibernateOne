package ru.mvgrebenyuk.hiberOne.DaoInterfaces;

import ru.mvgrebenyuk.hiberOne.Client;
import ru.mvgrebenyuk.hiberOne.Product;

import java.util.List;

public interface ProductDao {
    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    void saveOrUpdate(Product product);

    List<Client> getClientsByPID(Long id);
}
