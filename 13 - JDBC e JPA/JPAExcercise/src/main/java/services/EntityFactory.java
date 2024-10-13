package services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityFactory {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-jpa");

    public static EntityManager getEntityManager(){
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
