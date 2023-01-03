package io.github.carlosaugusto516.clientes;

import io.github.carlosaugusto516.clientes.model.entity.Cliente;
import io.github.carlosaugusto516.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesApplication {
    public static void main(String[] args) {
        SpringApplication.run (ClientesApplication.class, args);

    }
}
