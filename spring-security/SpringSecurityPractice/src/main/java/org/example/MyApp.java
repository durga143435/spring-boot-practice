package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MyApp {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp.class);
//        new MyApp().test();
    }

   /* public void test() {
        System.out.println("PASSWORD :: " + new BCryptPasswordEncoder().encode("pass123"));
    }*/
}
