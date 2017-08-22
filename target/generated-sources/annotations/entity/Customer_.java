package entity;

import entity.Address;
import enums.CustomerType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-08-22T10:04:21")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> firstName;
    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile SingularAttribute<Customer, CustomerType> customerType;
    public static volatile ListAttribute<Customer, Address> addresses;
    public static volatile ListAttribute<Customer, String> hobbies;
    public static volatile MapAttribute<Customer, String, String> phones;
    public static volatile SingularAttribute<Customer, Long> id;

}