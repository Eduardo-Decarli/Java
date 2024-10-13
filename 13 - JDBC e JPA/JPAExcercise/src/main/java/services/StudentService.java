package services;

import com.google.protobuf.ServiceException;
import entities.Student;
import jakarta.persistence.*;

public class StudentService {

    private EntityManager em = null;

    public void registerStudent(Student student) throws ServiceException {
        EntityManager em = EntityFactory.getEntityManager();
        try {
            em.getTransaction().begin(); // Inicia uma transaction
            em.persist(student); // Persiste um estudante no DB
            em.getTransaction().commit(); // Confirma a transaction
        }
        catch(EntityExistsException error){
            throw new ServiceException(error.getMessage());
        }
        finally {
            em.close();
        }
    }

    public Student selectStudent(Long id) throws ServiceException {
        EntityManager em = EntityFactory.getEntityManager();
        try{
            Student student = em.find(Student.class, id); // Marca o tipo da classe que terá que buscar e o id
            return student;
        }
        catch(NoResultException erro){
            throw new ServiceException(erro.getMessage());
        }
        finally {
            em.close();
        }
    }
}
