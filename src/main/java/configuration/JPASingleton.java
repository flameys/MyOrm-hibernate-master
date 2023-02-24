package configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPASingleton {
    private static final String PERSISTENCE_UNIT_NAME = "unasat_persistence";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    private static EntityManager entityManager; //= factory.createEntityManager();

    private JPASingleton(){

    }

   /* public static JPASingleton getInstance(){
        if (entityManager == null){
            //entityManager = new JPASingleton();
        }
    } return ;*/
}
