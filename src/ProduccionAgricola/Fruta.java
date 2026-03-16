package ProduccionAgricola;

import java.util.ArrayList;
import java.util.List;

public class Fruta {

    private String nombre;
    private double extensionHect;
    private double costoProduccionPorTon;
    private double precioVentaPorTon;
    private List<PeriodoCosecha> periodos;

    public Fruta(String nombre, double extensionHectareas, double costoProduccionPromedioTon, double precioVentaPromedioTon) {

        this.nombre = nombre;
        this.extensionHect = extensionHectareas;
        this.costoProduccionPorTon = costoProduccionPromedioTon;
        this.precioVentaPorTon = precioVentaPromedioTon;
        this.periodos = new ArrayList<>();
    }

    public void agregarPeriodo(PeriodoCosecha periodo) {
        periodos.add(periodo);
    }

    public void eliminarPeriodo(PeriodoCosecha periodo) {
        periodos.remove(periodo);
    }

    public void setExtensionHect (double hectareas){this.extensionHect = hectareas;}

    public  void setCostoProduccionPorTon (double costo){this.costoProduccionPorTon = costo;}

    public void setPrecioVentaPorTon (double precio){this.precioVentaPorTon = precio;}

    public String getNombre() {return nombre;}

    public double getExtensionHect() {return extensionHect;}

    public double getCostoProduccionPorTon() {return costoProduccionPorTon;}

    public double getPrecioVentaPorTon() {
        return precioVentaPorTon;
    }

    public List<PeriodoCosecha> getPeriodos() {return periodos;}

    @Override
    public String toString() {
        return "Fruta{" +
                "nombre='" + nombre + '\'' +
                ", extensionHect=" + extensionHect +
                ", costoProduccionPorTon=" + costoProduccionPorTon +
                ", precioVentaPorTon=" + precioVentaPorTon +
                ", periodos=" + periodos +
                '}';
    }
}
