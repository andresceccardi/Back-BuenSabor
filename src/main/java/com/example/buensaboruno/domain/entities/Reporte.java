package com.example.buensaboruno.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Reporte extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String comida;

    @Column(nullable = false)
    private Integer pedidos;

    @Column(nullable = false)
    private Double ingresos;

    @Column(nullable = false)
    private Double ganancia;

    @Column(nullable = false)
    private String cliente;

    // Constructor sin el campo id, generado automáticamente por la base de datos
    public Reporte(LocalDate fecha, String comida, Integer pedidos, Double ingresos, Double ganancia, String cliente) {
        this.fecha = fecha;
        this.comida = comida;
        this.pedidos = pedidos;
        this.ingresos = ingresos;
        this.ganancia = ganancia;
        this.cliente = cliente;
    }

    // Getters y Setters según sea necesario
    // También puedes agregar otros métodos según las necesidades de tu aplicación

}
