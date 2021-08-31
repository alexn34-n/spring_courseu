package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) throws Exception{
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session=null;

try {
//    Session session = factory.getCurrentSession();
    Employee employee=new Employee("John","Peerson"
            ,"IT",500);
    Detail detail=new Detail("Dublin","123456789"
            ,"peerson@gmail.com");
    employee.setEmDetail(detail);
    session.beginTransaction();

    session.save(employee);

    session.getTransaction().commit();
    System.out.println("Done!!!");

//    Session session = factory.getCurrentSession();
//    Employee employee=new Employee("Carl","Carlson"
//            ,"Sales",700);
//    Detail detail=new Detail("Oslo","888996654"
//            ,"carlson@gmail.com");
//    employee.setEmDetail(detail);
//    session.beginTransaction();
//
//    session.save(employee);
//
//    session.getTransaction().commit();
//    System.out.println("Done!!!");

//    session = factory.getCurrentSession();
//
//
//    session.beginTransaction();
//    Employee emp=session.get(Employee.class,1);
//    System.out.println(emp.getEmDetail());
//
//    session.getTransaction().commit();
//    System.out.println("Done!!!");


    session = factory.getCurrentSession();


    session.beginTransaction();
    Employee emp=session.get(Employee.class,2);
    session.delete(emp);

    session.getTransaction().commit();
    System.out.println("Done!!!");

} finally {
    session.close();
    factory.close();
}
    }
}
