package ru.mvgrebenyuk.hiberOne;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mvgrebenyuk.hiberOne.DAO.ClientDaoImpl;
import ru.mvgrebenyuk.hiberOne.DAO.ProductDaoImpl;
import ru.mvgrebenyuk.hiberOne.DaoInterfaces.ClientDao;
import ru.mvgrebenyuk.hiberOne.DaoInterfaces.ProductDao;


public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
            try {
                ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
                ClientDao clientDao = new ClientDaoImpl(sessionFactoryUtils);
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
