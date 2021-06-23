package org.example;

import ComponentScan.UserInputService;
import Configure.ComponentScanConfig;
import Models.Student;
import data_access.StudentDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        StudentDao studentDao = context.getBean(StudentDao.class);


        UserInputService userInputService= context.getBean(UserInputService.class);
        System.out.println(userInputService.getString());

        context.close();
    }
}
