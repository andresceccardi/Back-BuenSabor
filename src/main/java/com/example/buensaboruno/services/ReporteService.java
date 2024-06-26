package com.example.buensaboruno.services;

import java.time.LocalDate;
import java.util.List;

public interface ReporteService {

    List<Object[]> obtenerRankingComidas(LocalDate fechaInicio, LocalDate fechaFin);

    List<Object[]> obtenerIngresosPorPeriodo(LocalDate fechaInicio, LocalDate fechaFin);

    List<Object[]> obtenerPedidosPorCliente(LocalDate fechaInicio, LocalDate fechaFin);

    List<Object[]> obtenerGananciaPorPeriodo(LocalDate fechaInicio, LocalDate fechaFin);

    // Puedes agregar más métodos según sea necesario para tus reportes
}
