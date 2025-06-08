import java.util.Scanner;

public class SpentView {
    private Scanner scanner;

    public SpentView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarTiposGasto() {
        System.out.println("Tipos de gasto permitidos: gasolina, revision, itv, cambio_aceite, otros");
    }

    public String leerTipoGasto() {
        System.out.print("Ingrese el tipo de gasto: ");
        return scanner.nextLine();
    }

    public int leerKilometraje() {
        System.out.print("Ingrese el kilometraje: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String leerFecha() {
        System.out.print("Ingrese la fecha (dd/MM/yyyy): ");
        return scanner.nextLine();
    }

    public double leerImporte() {
        System.out.print("Ingrese el importe: ");
        return Double.parseDouble(scanner.nextLine());
    }

    public String leerDescripcion() {
        System.out.print("Ingrese una descripción (opcional): ");
        return scanner.nextLine();
    }

    public String leerFiltroFechaInicio() {
        System.out.print("Ingrese la fecha de inicio para filtrar (dd/MM/yyyy): ");
        return scanner.nextLine();
    }

    public String leerFiltroFechaFin() {
        System.out.print("Ingrese la fecha de fin para filtrar (dd/MM/yyyy): ");
        return scanner.nextLine();
    }

    public void mostrarListadoGastos(ResultSet rs) throws SQLException {
        System.out.println("Listado de gastos: ");
        while (rs.next()) {
            System.out.printf("Tipo: %s | Km: %d | Fecha: %s | Importe: %.2f | Desc: %s\n",
                    rs.getString("tipo"),
                    rs.getInt("kilometraje"),
                    rs.getDate("fecha").toString(),
                    rs.getDouble("importe"),
                    rs.getString("descripcion"));
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
