
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.CarModel;
import model.ISpentModel;
import vista.CarView;

class SpentController {
    
    private SpentView spentView;
    private ISpentModel spentModel;
    
    public SpentController(String uuid) throws ClassNotFoundException, SQLException, IOException {
		carView = new CarView();
		this.carModel = new CarModel();
		this.uuid = uuid;
	}

    public void agregarSpent(int carId) {
        spentView.mostrarTiposGasto(); // Muestra los tipos de gasto permitidos
        String tipo = spentView.leerTipoGasto(); // Obtiene el tipo de gasto del usuario

        // Validar tipo de gasto
        if (!isTipoValido(tipo)) {
            spentView.mostrarMensaje("Tipo de gasto no válido.");
            return;
        }

        int kilometraje = spentView.leerKilometraje(); // Obtiene el kilometraje
        String fechaStr = spentView.leerFecha(); // Obtiene la fecha
        double importe = spentView.leerImporte(); // Obtiene el importe
        String descripcion = spentView.leerDescripcion(); // Obtiene la descripción

        try {
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
            String sql = "INSERT INTO gastos (car_id, tipo, kilometraje, fecha, importe, descripcion) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, carId);
                ps.setString(2, tipo);
                ps.setInt(3, kilometraje);
                ps.setDate(4, new java.sql.Date(fecha.getTime()));
                ps.setDouble(5, importe);
                ps.setString(6, descripcion);
                ps.executeUpdate();
                spentView.mostrarMensaje("Gasto añadido correctamente.");
            }
        } catch (ParseException e) {
            spentView.mostrarMensaje("Error en el formato de la fecha: " + e.getMessage());
        } catch (SQLException e) {
            spentView.mostrarMensaje("Error al añadir gasto: " + e.getMessage());
        }
    }

    public void filterSpent(int carId) {
        String filtroFechaInicio = spentView.leerFiltroFechaInicio(); // Obtiene la fecha de inicio
        String filtroFechaFin = spentView.leerFiltroFechaFin(); // Obtiene la fecha de fin

        String sql = "SELECT * FROM gastos WHERE car_id = ?";
        if (!filtroFechaInicio.isEmpty()) sql += " AND fecha >= ?";
        if (!filtroFechaFin.isEmpty()) sql += " AND fecha <= ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
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

            try (ResultSet rs = ps.executeQuery()) {
                spentView.mostrarListadoGastos(rs); // Muestra el listado de gastos
            }
        } catch (ParseException e) {
            spentView.mostrarMensaje("Error en el formato de la fecha: " + e.getMessage());
        } catch (SQLException e) {
            spentView.mostrarMensaje("Error al mostrar gastos: " + e.getMessage());
        }
    }

    // Método para validar el tipo de gasto
    private boolean isTipoValido(String tipo) {
        String[] tiposValidos = {"gasolina", "revision", "itv", "cambio_aceite", "otros"};
        for (String t : tiposValidos) {
            if (t.equalsIgnoreCase(tipo)) {
                return true;
            }
        }
        return false;
    }
}
