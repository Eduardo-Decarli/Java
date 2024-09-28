package application;

import dominio.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null, "Carlos", "Calrlossilva@gmail.com");
        Pessoa p2 = new Pessoa(null, "Joaquim Torres", "Joaquim@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

        // Criar o EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        // Iniciar a transação
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();  // Iniciar a transação

            // Persistir as entidades no banco de dados
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);

            tx.commit();  // Comitar a transação

            Pessoa p = em.find(Pessoa.class, 2); // Busca o usuario no Id 2 no banco de dados

            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();

            System.out.println(p);

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();  // Fazer rollback se algo der errado
            }
            e.printStackTrace();  // Exibir o erro
        } finally {
            em.close();  // Fechar o EntityManager
            emf.close();  // Fechar o EntityManagerFactory
        }

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
