package dev.aymee;

public class CuentaCorriente extends Cuenta{
    private float sobregiro=0;

    public CuentaCorriente(float saldo, float tasa_anual) {
        super(saldo, tasa_anual);
    }

    @Override
    public float consignar(float cantidad) {
        if (cantidad <= 0) {
            System.out.println("ERROR: La cantidad debe ser positiva");
            return -1;
        }
       if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                cantidad -= sobregiro;
                sobregiro = 0;
                saldo += cantidad;
            } else {
                sobregiro -= cantidad;
            }
            consignaciones++;
            } else {
            super.consignar(cantidad);
        }
       return saldo; 
    }

    @Override
    public float extractoMensual() {
        return super.extractoMensual();
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comision_mensual);
        System.out.println("Transacciones: " + (consignaciones + retiros));
        System.out.println("Sobregiro: " + sobregiro);
    }

    @Override
    public float retirar(float cantidad) {
        if (cantidad <= 0) {
            System.out.println("ERROR: La cantidad debe ser positiva");
            return -1;
        }
        if(cantidad>saldo){
            sobregiro+=cantidad-saldo;
            saldo=0;
            retiros++;
           
        }else{
            super.retirar(cantidad);
        }
        return saldo;
        
    }

    
    
}
