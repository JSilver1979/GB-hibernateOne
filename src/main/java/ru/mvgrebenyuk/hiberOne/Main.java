package ru.mvgrebenyuk.hiberOne;

import ru.mvgrebenyuk.hiberOne.DAO.ClientDaoImpl;
import ru.mvgrebenyuk.hiberOne.DAO.ProductDaoImpl;
import ru.mvgrebenyuk.hiberOne.DaoInterfaces.ClientDao;
import ru.mvgrebenyuk.hiberOne.DaoInterfaces.ProductDao;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
            try {
                ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
//                System.out.println(productDao.findAll());
//                productDao.deleteById(1L);
//                System.out.println(productDao.findAll());
//                Product product = productDao.findById(2L);
//                product.setPrice(333);
//                product.setTitle("Changed Apple");
//                productDao.saveOrUpdate(product);
//                System.out.println(productDao.findAll());
//                Product newProduct = new Product();
//                newProduct.setTitle("Watermelon");
//                newProduct.setPrice(50);
//                productDao.saveOrUpdate(newProduct);
//                System.out.println(productDao.findAll());

                ClientDao clientDao = new ClientDaoImpl(sessionFactoryUtils);
//                System.out.println(clientDao.getAllClients());
                System.out.println(productDao.getClientsByPID(3L));
                System.out.println("-------");
                System.out.println(clientDao.getProductsByCID(1L));
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                sessionFactoryUtils.shutdown();
            }
    }
}
