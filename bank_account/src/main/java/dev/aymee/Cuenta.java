package dev.aymee;

public class Cuenta {
    protected float saldo;
    protected int consignaciones;
    protected int retiros;
    protected float tasa_anual;
    protected float comision_mensual;
    
    public Cuenta(float saldo, float tasa_anual) {
        this.saldo = saldo;
        this.tasa_anual = tasa_anual;
        this.consignaciones=0;
        this.retiros=0;
        this.comision_mensual=0;
    }

    

}
