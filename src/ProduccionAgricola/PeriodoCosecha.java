package ProduccionAgricola;

public class PeriodoCosecha {

    private String nombrePeriodo;
    private double TonEstimadasPorHectarea;
    private Fruta fruta;

    public PeriodoCosecha(String nombrePeriodo, double cantidadEstimadaTonPorHectarea, Fruta f) {
        this.nombrePeriodo = nombrePeriodo;
        this.TonEstimadasPorHectarea = cantidadEstimadaTonPorHectarea;
        this.fruta = f;
        fruta.agregarPeriodo(this);
    }

    // Getters
    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public double getTonEstimadasPorHectarea() {
        return TonEstimadasPorHectarea;
    }

    // Cálculos

    public double calcularProduccionTotal(double hectareas) {
        return hectareas * TonEstimadasPorHectarea;
    }

    public double calcularCostoTotal(double hectareas, double costoTon)
    {
        return calcularProduccionTotal(hectareas) * costoTon;
    }

    public double calcularGananciaEstimada(double hectareas, double costoTon, double precioTon)
    {
        double ingreso = calcularProduccionTotal(hectareas) * precioTon;
        double costo = calcularProduccionTotal(hectareas) * costoTon;

        return ingreso - costo;
    }

    @Override
    public String toString() {
        return "PeriodoCosecha{" +
                "nombrePeriodo='" + nombrePeriodo + '\'' +
                ", TonEstimadasPorHectarea=" + TonEstimadasPorHectarea +
                '}';
    }
}
