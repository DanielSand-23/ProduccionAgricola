package ProduccionAgricola;

public class PeriodoCosecha {

    private String nombrePeriodo;
    private double TonPorHect;

    public PeriodoCosecha(String nombrePeriodo, double cantidadEstimadaTonPorHectarea) {
        this.nombrePeriodo = nombrePeriodo;
        this.TonPorHect = cantidadEstimadaTonPorHectarea;}

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

    public void setTonPorHect (double toneladas){this.TonPorHect = toneladas;}


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
}
