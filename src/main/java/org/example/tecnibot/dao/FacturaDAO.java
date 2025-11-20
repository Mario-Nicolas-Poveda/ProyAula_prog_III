package org.example.tecnibot.dao;

import org.example.tecnibot.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
    private final Connection conn;

    public FacturaDAO(Connection conn) {
        this.conn = conn;
    }

    public Factura obtenerFacturaPorId(int idFactura) throws SQLException {
        String queryFactura = """
            SELECT f.id, f.fecha, f.total,
                   c.nombre AS cliente_nombre, c.telefono, c.direccion,
                   s.id AS servicio_id, s.costo_mano_obra, s.completado,
                   d.tipo, d.marca, d.modelo,
                   u.nombre AS tecnico_nombre, u.correo, u.password
            FROM factura f
            JOIN cliente c ON f.cliente_id = c.id
            JOIN servicio s ON f.servicio_id = s.id
            JOIN dispositivo d ON s.dispositivo_id = d.id
            JOIN usuario u ON s.tecnico_id = u.id
            WHERE f.id = ?
        """;

        try (PreparedStatement ps = conn.prepareStatement(queryFactura)) {
            ps.setInt(1, idFactura);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente(
                            rs.getString("cliente_nombre"),
                            rs.getString("telefono"),
                            rs.getString("direccion")
                    );

                    Dispositivo dispositivo = new Dispositivo(
                            rs.getString("tipo"),
                            rs.getString("marca"),
                            rs.getString("modelo"),
                            cliente
                    );

                    Tecnico tecnico = new Tecnico(
                            rs.getString("tecnico_nombre"),
                            rs.getString("correo"),
                            rs.getString("password")
                    );

                    Servicio servicio = new Servicio(dispositivo, tecnico, rs.getDouble("costo_mano_obra"));
                    servicio.setCompletado(rs.getBoolean("completado"));

                    String queryComponentes = """
                        SELECT c.nombre, c.descripcion, c.precio
                        FROM servicio_componente sc
                        JOIN componente c ON sc.componente_id = c.id
                        WHERE sc.servicio_id = ?
                    """;

                    try (PreparedStatement cps = conn.prepareStatement(queryComponentes)) {
                        cps.setInt(1, rs.getInt("servicio_id"));
                        try (ResultSet crs = cps.executeQuery()) {
                            while (crs.next()) {
                                Componente comp = new Componente(
                                        crs.getString("nombre"),
                                        crs.getString("descripcion"),
                                        crs.getDouble("precio")
                                );
                                servicio.agregarComponente(comp);
                            }
                        }
                    }

                    return new Factura(
                            cliente,
                            servicio,
                            rs.getDate("fecha").toLocalDate(),
                            rs.getDouble("total")
                    );
                }
            }
        }
        return null;
    }
}