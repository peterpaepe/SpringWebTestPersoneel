package be.vdab.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource("classpath:spring/services.xml")//@ComponentScan("be.vdab.services")//Je geeft aan dat Spring één bean moet maken per class met de annotation @Services in de package be.vdab.services
@EnableTransactionManagement
public class CreateServiceBeans {
}