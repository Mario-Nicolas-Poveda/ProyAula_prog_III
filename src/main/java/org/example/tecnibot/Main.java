package org.example.tecnibot;

import org.example.tecnibot.config.*;
import org.example.tecnibot.dao.FacturaDAO;
import org.example.tecnibot.service.FacturaService;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DatabaseConfig config = new DatabaseConfig("localhost", "5432", "tecnibot", "admin", "admin123");
        IDatabaseConnection db = new PostgresDatabaseConnection(config);

        try (Connection conn = db.connect()) {
            FacturaDAO facturaDAO = new FacturaDAO(conn);
            FacturaService facturaService = new FacturaService(facturaDAO);
            facturaService.mostrarFactura(3); // Puedes cambiar el ID según lo necesites
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}