package com.example.buensaboruno.controllers;

import com.example.buensaboruno.services.ReporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReportesController {

    private final ReporteService reporteService;

    public ReportesController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/ingresos")
    public ResponseEntity<?> getIngresosPorPeriodo(
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFin) {
        try {
            List<Object[]> ingresos = reporteService.obtenerIngresosPorPeriodo(fechaInicio, fechaFin);
            return ResponseEntity.status(HttpStatus.OK).body(ingresos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error al obtener los ingresos. Por favor, inténtelo más tarde.\"}");
        }
    }

    @GetMapping("/ranking-comidas")
    public ResponseEntity<?> getRankingComidas(
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFin) {
        try {
            List<Object[]> rankingComidas = reporteService.obtenerRankingComidas(fechaInicio, fechaFin);
            return ResponseEntity.status(HttpStatus.OK).body(rankingComidas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error al obtener el ranking de comidas. Por favor, inténtelo más tarde.\"}");
        }
    }

    @GetMapping("/pedidos-por-cliente")
    public ResponseEntity<?> getPedidosPorCliente(
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFin) {
        try {
            List<Object[]> pedidosPorCliente = reporteService.obtenerPedidosPorCliente(fechaInicio, fechaFin);
            return ResponseEntity.status(HttpStatus.OK).body(pedidosPorCliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error al obtener los pedidos por cliente. Por favor, inténtelo más tarde.\"}");
        }
    }

    @GetMapping("/ganancia")
    public ResponseEntity<?> getGananciaPorPeriodo(
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFin) {
        try {
            List<Object[]> ganancia = reporteService.obtenerGananciaPorPeriodo(fechaInicio, fechaFin);
            return ResponseEntity.status(HttpStatus.OK).body(ganancia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error al obtener la ganancia. Por favor, inténtelo más tarde.\"}");
        }
    }

    // Implementa otros métodos del controlador según sea necesario
}
