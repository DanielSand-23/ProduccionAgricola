package ProduccionAgricola;

import java.util.ArrayList;
import java.util.List;

public class Fruta {

    private String nombre;
    private double extensionHect;
    private double costoProduccionPromedioTon;
    private double precioVentaPromedioTon;
    private List<PeriodoCosecha> periodos;

    public Fruta(String nombre, double extensionHectareas, double costoProduccionPromedioTon, double precioVentaPromedioTon) {

        this.nombre = nombre;
        this.extensionHect = extensionHectareas;
        this.costoProduccionPromedioTon = costoProduccionPromedioTon;
        this.precioVentaPromedioTon = precioVentaPromedioTon;
        this.periodos = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getExtensionHect() {
        return extensionHect;
    }

    public double getCostoProduccionPromedioTon() {
        return costoProduccionPromedioTon;
    }

    public double getPrecioVentaPromedioTon() {
        return precioVentaPromedioTon;
    }

    public List<PeriodoCosecha> getPeriodos() {
        return periodos;
    }

    // Métodos de gestión
    public void agregarPeriodo(PeriodoCosecha periodo) {
        periodos.add(periodo);
    }

    public void eliminarPeriodo(PeriodoCosecha periodo) {
        periodos.remove(periodo);
    }

    @Override
    public String toString() {
        return "Fruta{" +
                "nombre='" + nombre + '\'' +
                ", extensionHect=" + extensionHect +
                ", costoProduccionPromedioTon=" + costoProduccionPromedioTon +
                ", precioVentaPromedioTon=" + precioVentaPromedioTon +
                ", periodos=" + getPeriodos() +
                '}';
    }
}
