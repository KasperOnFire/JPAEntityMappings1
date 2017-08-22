package test;

import entity.Address;
import entity.Book;
import entity.Customer;
import entity.CustomerFacade;
import enums.CustomerType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Kasper
 */
public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_JPAEntityMappings1_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        try {
            Book b1 = new Book();
            b1.setTitle("The Old Man and the Sea");
            Book b2 = new Book();
            b2.setTitle("For Whom The Bell Tolls");
            Book b3 = new Book();
            b3.setTitle("The Sun Also Rises");

            Customer c1 = new Customer();
            c1.setFirstName("Test");
            c1.setLastName("User");
            c1.setCustomerType(CustomerType.RUSTY);
            c1.addHobbies("Tennis");
            c1.addHobbies("Hacking");
            c1.addHobbies("Programming");
            System.out.println(c1.getHobbies()); //to test
            c1.addPhone("12345678", "test1");
            c1.addPhone("987456321", "test2");

            List<Customer> clist = new ArrayList();
            clist.add(c1);

            Address a1 = new Address();
            a1.setCity("Kolding");
            a1.setStreet("Jernbanegade");
            a1.setCustomers(clist);
            Address a2 = new Address();
            a2.setCity("Kgs. Lyngby");
            a2.setStreet("Nybrovej");
            a2.setCustomers(clist);

            List<Address> addressList = new ArrayList();
            addressList.add(a1);
            addressList.add(a2);

            c1.setAddresses(addressList);
            
            

            em.getTransaction().begin();
            em.persist(b1);
            em.persist(b2);
            em.persist(b3);
            em.persist(a1);
            em.persist(a2);
            em.persist(c1);
            em.getTransaction().commit();

            CustomerFacade cf = new CustomerFacade(emf);

            Customer newcustomer = cf.getCustomer(c1.getId());
            System.out.println(newcustomer.getFirstName());
            System.out.println(newcustomer.getAddresses().get(0).getCity());

            Customer c2 = new Customer();

            c2.setFirstName("Mega");
            c2.setLastName("super");
            cf.addCustomer(c2);
            System.out.println(cf.getCustomer(5).getFirstName());

            cf.deleteCustomer(5); //nvm
            
            cf.getCustomers();


        } finally {
            em.close();
        }

    }
}
