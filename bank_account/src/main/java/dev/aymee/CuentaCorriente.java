package dev.aymee;

public class CuentaCorriente extends Cuenta{
    protected float sobregiro=0;

    public CuentaCorriente(float saldo, float tasa_anual) {
        super(saldo, tasa_anual);
    }

    @Override
    public float consignar(float cantidad) {
        // TODO Auto-generated method stub
        return super.consignar(cantidad);
    }

    @Override
    public float extractoMensual() {
        // TODO Auto-generated method stub
        return super.extractoMensual();
    }

    @Override
    public void imprimir() {
        // TODO Auto-generated method stub
        super.imprimir();
    }

    @Override
    public float retirar(float cantidad) {
        // TODO Auto-generated method stub
        return super.retirar(cantidad);
    }
    
    
}
