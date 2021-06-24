package Configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@ComponentScan(basePackages = "ComponentScan")
public class ComponentScanner {


    @Bean
    public Scanner scanner(){

        return new Scanner(System.in);
    }
}
