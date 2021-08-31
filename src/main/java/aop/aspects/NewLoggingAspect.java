package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class NewLoggingAspect {
    @Around("execution(public String returnBook())")

    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice(): в библиотеку"+
                "  пытаются вернуть книгу");
        Object targetMethodResult=null;
        try {
            // long begin=System.currentTimeMillis();
          targetMethodResult = proceedingJoinPoint.proceed();
            // targetMethodResult="1984";
            //long end=System.currentTimeMillis();
        }
        catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAdvice было поймано "+
                    " исключение"+ e);

            throw e;
          //  targetMethodResult="Неизвестное  название книги";
        }


        System.out.println("aroundReturnBookLoggingAdvice(): в библиотеку"+
                " успешно вернули  книгу");
//        System.out.println("aroundReturnBookLoggingAdvice(): метод returnBook"+
//                "выполнил работу за "+(end-begin)+" миллисекунд ");
        return targetMethodResult;

    }
}
