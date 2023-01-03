package io.github.carlosaugusto516.clientes.model.repository;

import io.github.carlosaugusto516.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente,Integer> {
}
