package ProduccionAgricola;
import Excepciones.ExcepcionCosechaEstimadaFueraDeLimites;

import java.util.Comparator;
import java.util.Objects;

public class PeriodoCosecha implements Comparable <PeriodoCosecha> {

    private String nombrePeriodo;
    private double TonPorHect;

    private final double MIN_EST_COSECHA = 0.5;
    private final double MAX_EST_COSECHA = 200;


    private static Comparator <PeriodoCosecha> c = new Comparator<PeriodoCosecha>() {
        public int compare(PeriodoCosecha o1, PeriodoCosecha o2) {
            return o1.compareTo(o2);
        }
    };

    public PeriodoCosecha(String nombrePeriodo, double cantidadEstimadaTonPorHectarea) throws ExcepcionCosechaEstimadaFueraDeLimites {
        if (cantidadEstimadaTonPorHectarea >= MIN_EST_COSECHA && cantidadEstimadaTonPorHectarea <= MAX_EST_COSECHA)
        {
            this.nombrePeriodo = nombrePeriodo;
            this.TonPorHect = cantidadEstimadaTonPorHectarea;
        }
        else
            throw new ExcepcionCosechaEstimadaFueraDeLimites("La estimacion de toneladas por hectareas esta fuera de los limites");
    }
    public double calcularProduccionTotal(Fruta fruta)
    {
        return fruta.getExtensionHect() * TonPorHect;
    }

    public double calcularCostoTotal(Fruta fruta)
    {
        return calcularProduccionTotal(fruta) * fruta.getCostoProduccionPorTon();
    }

    public double calcularGananciaEstimada(Fruta fruta)
    {
        return calcularProduccionTotal(fruta) * fruta.getPrecioVentaPorTon() - calcularCostoTotal(fruta);
    }

    public void setTonPorHect (double toneladas) throws ExcepcionCosechaEstimadaFueraDeLimites
    {
        if (toneladas > MIN_EST_COSECHA && toneladas < MAX_EST_COSECHA)
        this.TonPorHect = toneladas;
        else
            throw new ExcepcionCosechaEstimadaFueraDeLimites("La estimacion de toneladas por hectareas esta fuera de los limites");
    }


    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public double getTonPorHect() {
        return TonPorHect;
    }

    @Override
    public String toString() {
        return "PeriodoCosecha{" +
                "nombrePeriodo='" + nombrePeriodo + '\'' +
                ", TonEstimadasPorHectarea=" + TonPorHect +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PeriodoCosecha that)) return false;
        return Double.compare(TonPorHect, that.TonPorHect) == 0 && Objects.equals(nombrePeriodo, that.nombrePeriodo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(nombrePeriodo);
        result = 31 * result + Double.hashCode(TonPorHect);
        return result;
    }

    @Override
    public int compareTo(PeriodoCosecha o) {
        int r=0;
        if((r=this.nombrePeriodo.compareTo(o.nombrePeriodo))!=0)
            return r;
        return Double.compare(TonPorHect, o.TonPorHect);
    }
}
