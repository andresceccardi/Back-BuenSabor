package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Long> {

    @Query("SELECT r.fecha, SUM(r.ingresos) AS total FROM Reporte r WHERE r.fecha BETWEEN :fechaInicio AND :fechaFin GROUP BY r.fecha ORDER BY r.fecha ASC")
    List<Object[]> obtenerIngresosPorPeriodo(LocalDate fechaInicio, LocalDate fechaFin);

    @Query("SELECT am.descripcion AS Comida, SUM(pd.cantidad) AS Pedidos " +
            "FROM Pedido p " +
            "JOIN p.pedidoDetalles pd " +
            "JOIN pd.articulo am " +
            "WHERE p.fechaPedido BETWEEN :fechaInicio AND :fechaFin " +
            "AND p.eliminado = false " +
            "AND pd.eliminado = false " +
            "GROUP BY am.descripcion " +
            "ORDER BY Pedidos DESC")
    List<Object[]> obtenerRankingComidas(LocalDate fechaInicio, LocalDate fechaFin);

    @Query("SELECT r.cliente, COUNT(r.cliente) AS pedidos FROM Reporte r WHERE r.fecha BETWEEN :fechaInicio AND :fechaFin GROUP BY r.cliente ORDER BY pedidos DESC")
    List<Object[]> obtenerPedidosPorCliente(LocalDate fechaInicio, LocalDate fechaFin);

    @Query("SELECT r.fecha, SUM(r.ganancia) AS total FROM Reporte r WHERE r.fecha BETWEEN :fechaInicio AND :fechaFin GROUP BY r.fecha ORDER BY r.fecha ASC")
    List<Object[]> obtenerGananciaPorPeriodo(LocalDate fechaInicio, LocalDate fechaFin);

    // Otros métodos de consulta según las necesidades
}
