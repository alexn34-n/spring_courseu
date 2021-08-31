package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary unlibrary=context.getBean("uniLibrary", UniLibrary.class);
        Book book=context.getBean("book",Book.class);
        unlibrary.getBook();
        unlibrary.addBook("John",book);
        unlibrary.addMagazine();
//        unlibrary.returnMagazine();
//       unlibrary.addBook();


//        SchoolLibrary schoolLibrary=context.getBean("schoolLibrary"
//                ,SchoolLibrary.class);
//        schoolLibrary.getBook();

        context.close();
    }
}
