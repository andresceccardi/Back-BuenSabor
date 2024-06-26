package com.example.buensaboruno.servicesImpl;

import com.example.buensaboruno.repositories.ReporteRepository;
import com.example.buensaboruno.services.ReporteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ReporteServiceImpl implements ReporteService {

    private final ReporteRepository reporteRepository;

    public ReporteServiceImpl(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }

    @Override
    public List<Object[]> obtenerIngresosPorPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
        return reporteRepository.obtenerIngresosPorPeriodo(fechaInicio, fechaFin);
    }

    @Override
    public List<Object[]> obtenerRankingComidas(LocalDate fechaInicio, LocalDate fechaFin) {
        return reporteRepository.obtenerRankingComidas(fechaInicio, fechaFin);
    }

    @Override
    public List<Object[]> obtenerPedidosPorCliente(LocalDate fechaInicio, LocalDate fechaFin) {
        return reporteRepository.obtenerPedidosPorCliente(fechaInicio, fechaFin);
    }

    @Override
    public List<Object[]> obtenerGananciaPorPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
        return reporteRepository.obtenerGananciaPorPeriodo(fechaInicio, fechaFin);
    }

    // Implementa otros métodos del servicio según sea necesario
}
