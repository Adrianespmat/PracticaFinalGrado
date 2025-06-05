package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import vista.EnterUser;

public class SpentController {
	public void agregarSpent(int carId) {
		System.out.println("Tipos de gasto permitidos: gasolina, revision, itv, cambio_aceite, otros");
        String tipo = EnterUser.leerTexto();
        int kilometraje = EnterUser.leerEntero();
        String fechaStr = EnterUser.leerTexto();
        double importe = EnterUser.leerDouble();
        String descripcion = EnterUser.leerTexto();
        
        try {
        	Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
        	
        	 try (Connection conn = null) {
                 String sql = "INSERT INTO gastos (car_id, tipo, kilometraje, fecha, importe, descripcion) VALUES (?, ?, ?, ?, ?, ?)";
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ps.setInt(1, carId);
                 ps.setString(2, tipo);
                 ps.setInt(3, kilometraje);
                 ps.setDate(4, new java.sql.Date(fecha.getTime()));
                 ps.setDouble(5, importe);
                 ps.setString(6, descripcion);
                 ps.executeUpdate();
                 System.out.println("Gasto añadido correctamente.");
             }
         } catch (Exception e) {
             System.out.println("Error al añadir gasto: " + e.getMessage());
         }
        }
	
	
	public void filterSpent(int carId) throws SQLException, ParseException {
		String filtroFechaInicio = EnterUser.leerTexto();
        String filtroFechaFin = EnterUser.leerTexto();
        
        String sql = "SELECT * FROM Spent WHERE car_id = ?";
        if (!filtroFechaInicio.isEmpty()) sql += " AND fecha >= ?";
        if (!filtroFechaFin.isEmpty()) sql += " AND fecha <= ?";
        
        try (Connection conn = null) {
        	PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, carId);
            
            int index = 2;
            if (!filtroFechaInicio.isEmpty()) {
                Date f1 = new SimpleDateFormat("dd/MM/yyyy").parse(filtroFechaInicio);
                ps.setDate(index++, new java.sql.Date(f1.getTime()));
            }
            if (!filtroFechaFin.isEmpty()) {
                Date f2 = new SimpleDateFormat("dd/MM/yyyy").parse(filtroFechaFin);
                ps.setDate(index, new java.sql.Date(f2.getTime()));
            }
            
            ResultSet rs = ps.executeQuery();
            System.out.println("Listado de gastos: ");
            while (rs.next()) {
            System.out.printf("Tipo: %s | Km: %d | Fecha: %s | Importe: %.2f | Desc: %s\n",
                    rs.getString("tipo"),
                    rs.getInt("kilometraje"),
                    rs.getDate("fecha").toString(),
                    rs.getDouble("importe"),
                    rs.getString("descripcion"));
        }
       } catch (Exception e) {
    	   System.out.println("Error al mostrar gastos: " + e.getMessage());
	}
}
}
