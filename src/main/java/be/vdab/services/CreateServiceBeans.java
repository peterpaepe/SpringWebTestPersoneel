package be.vdab.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("be.vdab.services")//Je geeft aan dat Spring één bean moet maken per class met de annotation @Services in de package be.vdab.services
@EnableTransactionManagement
public class CreateServiceBeans {
}