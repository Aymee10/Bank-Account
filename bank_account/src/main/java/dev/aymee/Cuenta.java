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

    public float consignar(float cantidad){
        if (cantidad>0) {
           saldo+=cantidad;
           consignaciones++;
         return saldo;  
        }
        else{
               System.out.println("ERROR: La cantidad a consignar no puede ser negativa");
         return -1;
        }
    }

    public float retirar(float cantidad){
        if(cantidad<=saldo && cantidad>0){
            saldo-=cantidad;
            retiros++;
            return saldo;
        }
        else{
            System.out.println("ERROR: La cantidad a retirar no puede ser mayor que el saldo ni negativa");
         return -1;
        }
        
    }
    
    public float calcularInteres(){
        float interesMensual= saldo*(tasa_anual/12/100);
        saldo+=interesMensual;
        return interesMensual;
    }

    public float extractoMensual(){
        saldo-=comision_mensual;
        calcularInteres();
       return saldo;
    }

    public void imprimir(){
        System.out.println("Saldo: "+ saldo);
        System.out.println("Consignaciones: "+ consignaciones);
        System.out.println("Retiros: "+ retiros);
        System.out.println("Comisión mensual: "+comision_mensual);
    }

}
