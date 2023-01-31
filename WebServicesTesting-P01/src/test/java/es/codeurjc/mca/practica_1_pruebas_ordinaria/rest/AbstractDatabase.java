package es.codeurjc.mca.practica_1_pruebas_ordinaria.rest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
public abstract class AbstractDatabase {
    
    @Container
    public static MySQLContainer mySQLContainer = new MySQLContainer<>("mysql:8.0.24")
      .withDatabaseName("test")
      .withUsername("user")
      .withPassword("pass")
      .withReuse(true);

      @DynamicPropertySource
      public static void overrideProperties(DynamicPropertyRegistry registry) {
          registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
      }
      

}
