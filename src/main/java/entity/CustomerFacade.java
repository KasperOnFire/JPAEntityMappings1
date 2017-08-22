package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class CustomerFacade {

    EntityManagerFactory emf;

    public CustomerFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Customer getCustomer(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }

    }

    public List<Customer> getCustomers() {
        EntityManager em = getEntityManager();
        try {
            List<Customer> clist = em.createQuery("SELECT c FROM Customer c").getResultList();
            System.out.println(clist.get(0).getFirstName());
            return clist;
        } finally {
            em.close();
        }
    }

    public Customer addCustomer(Customer cust) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return em.find(Customer.class, cust.getId());
        } finally {
            em.close();
        }
    }

    public Customer deleteCustomer(long id) {
        EntityManager em = getEntityManager();
        try {
            Customer c = em.find(Customer.class, id);
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            return c;
        } finally {
            em.close();
        }
    }

    public Customer editCustomer(Customer cust) {
        EntityManager em = getEntityManager();
        try {
            Customer c = em.find(Customer.class, 4);
            c.setFirstName("NewName");
            em.getTransaction().begin();
            em.persist(c);
            em.close();
            return em.find(Customer.class, 4);
        } finally {
            em.close();
        }
    }

}
