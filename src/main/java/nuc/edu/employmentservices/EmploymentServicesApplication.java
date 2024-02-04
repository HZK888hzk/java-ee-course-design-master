package nuc.edu.employmentservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class EmploymentServicesApplication {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        SpringApplication.run(EmploymentServicesApplication.class, args);
        //implements WebMvcConfigurer


    }

    /**
     * springboot 绞手架
     * 主要的启动类main
     *
     * 绞手架： 集成了许多优秀的框架，，，spring，springMvc，mybatis,jackson(序列化对象)
     *
     *
     * pom.xml
     *
     *
     * maven
     * gradle
     *
     *
     *
     */

}
