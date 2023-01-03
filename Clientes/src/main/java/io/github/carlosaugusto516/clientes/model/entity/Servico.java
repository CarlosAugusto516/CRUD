package io.github.carlosaugusto516.clientes.model.entity;

import io.github.carlosaugusto516.clientes.ClientesApplication;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 150)
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;
    @Column
    private BigDecimal valor;

}

