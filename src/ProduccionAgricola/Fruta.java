package ProduccionAgricola;

import Excepciones.ExcepcionExtensionFueraDeLimites;
import Excepciones.ExcepcionLimiteDeExtensionInvalido;
import Excepciones.ExcepcionPrecioDeCosechaFueraDeLimites;
import Excepciones.ExcepcionTiempoDeCosechaFueraDeLimites;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Fruta implements Comparable <Fruta> {

    private String nombre;
    private double extensionHect;
    private int tiempoCosecha;
    private double costoProduccionPorTon;
    private double precioVentaPorTon;
    private List<PeriodoCosecha> periodos;

    private final int MIN_TIEMPO_COSECHA = 1;
    private final int MAX_TIEMPO_COSECHA = 6;
    private final double MIN_EXT = 0.5;
    private final double MAX_EXT = 10;

    private double limiteExtension;

    private final double MIN_PORCENTAJE_GANANCIA = 0.05;
    private final double MAX_PORCENTAJE_GANANCIA = 0.3;





    private static Comparator<Fruta> c = new Comparator<Fruta>() {
        public int compare(Fruta o1, Fruta o2) {
            return o1.compareTo(o2);
        }
    };

    public Fruta(String nombre, double limiteExtension, double extensionHectareas, int tiempoCosecha,
                 double costoProduccionPromedioTon, double precioVentaPromedioTon)
            throws ExcepcionTiempoDeCosechaFueraDeLimites, ExcepcionLimiteDeExtensionInvalido, ExcepcionExtensionFueraDeLimites,
            ExcepcionPrecioDeCosechaFueraDeLimites{
        this.nombre = nombre;
        this.limiteExtension = limiteExtension;
        this.extensionHect = extensionHectareas;
        this.tiempoCosecha = tiempoCosecha;
        this.costoProduccionPorTon = costoProduccionPromedioTon;
        this.precioVentaPorTon = precioVentaPromedioTon;
        this.periodos = new ArrayList<>();

        validacion();
    }

    public void validacion() throws ExcepcionTiempoDeCosechaFueraDeLimites, ExcepcionLimiteDeExtensionInvalido,
            ExcepcionExtensionFueraDeLimites, ExcepcionPrecioDeCosechaFueraDeLimites
    {
        if(tiempoCosecha < MIN_TIEMPO_COSECHA || tiempoCosecha > MAX_TIEMPO_COSECHA)
            throw new ExcepcionTiempoDeCosechaFueraDeLimites("El tiempo de cosecha esta fuera de los limites");

        if(limiteExtension < MIN_EXT || limiteExtension > MAX_EXT)
            throw new ExcepcionLimiteDeExtensionInvalido("El limite de extensión es invalido");

        if(extensionHect < MIN_EXT || extensionHect > limiteExtension)
            throw new ExcepcionExtensionFueraDeLimites("La extension de hectareas esta fuera de los limites");

        if(precioVentaPorTon < (costoProduccionPorTon + (costoProduccionPorTon * MIN_PORCENTAJE_GANANCIA)) ||
                precioVentaPorTon > (costoProduccionPorTon + (costoProduccionPorTon * MAX_PORCENTAJE_GANANCIA)))
            throw new ExcepcionPrecioDeCosechaFueraDeLimites("El precio de venta esta fuera de los limites");
    }

    public void agregarPeriodo(PeriodoCosecha periodo) {
        periodos.add(periodo);
    }

    public void eliminarPeriodo(PeriodoCosecha periodo) {
        periodos.remove(periodo);
    }

    public void setExtensionHect (double hectareas) throws ExcepcionExtensionFueraDeLimites
    {

        this.extensionHect = hectareas;
    }

    public  void setCostoProduccionPorTon (double costo){this.costoProduccionPorTon = costo;}

    public void setPrecioVentaPorTon (double precio){this.precioVentaPorTon = precio;}

    public String getNombre() {return nombre;}

    public double getLimiteExtension()
    {
        return limiteExtension;
    }

    public double getExtensionHect() {return extensionHect;}

    public int getTiempoCosecha() {return tiempoCosecha;}

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
                ", tiempoCosecha=" + tiempoCosecha +
                ", costoProduccionPorTon=" + costoProduccionPorTon +
                ", precioVentaPorTon=" + precioVentaPorTon +
                ", periodos=" + periodos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Fruta fruta)) return false;
        return Integer.compare(tiempoCosecha, fruta.tiempoCosecha) == 0 && Double.compare(extensionHect, fruta.extensionHect) == 0 && Double.compare(costoProduccionPorTon, fruta.costoProduccionPorTon) == 0 &&
                Double.compare(precioVentaPorTon, fruta.precioVentaPorTon) == 0 && Objects.equals(nombre, fruta.nombre) && Objects.equals(periodos, fruta.periodos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(nombre);
        result = 31 * result + Double.hashCode(extensionHect);
        result = 31 * result + Integer.hashCode(tiempoCosecha);
        result = 31 * result + Double.hashCode(costoProduccionPorTon);
        result = 31 * result + Double.hashCode(precioVentaPorTon);
        result = 31 * result + Objects.hashCode(periodos);

        return result;
    }

    @Override
    public int compareTo(Fruta o) {
        int r = 0;
        if ((r=this.nombre.compareTo(o.nombre))!=0)
            return r;
        if ((r=Double.compare(this.extensionHect, o.extensionHect))!=0)
            return r;
        if ((r=Integer.compare(this.tiempoCosecha, o.tiempoCosecha))!=0)
            return r;
        if ((r=Double.compare(this.costoProduccionPorTon, o.costoProduccionPorTon))!=0)
            return r;
        return Double.compare(this.precioVentaPorTon, o.precioVentaPorTon);
    }
}
