package dev.aymee;

public class CuentaAhorro extends Cuenta {
   protected boolean activa;

    public CuentaAhorro(float saldo, float tasa_anual) {
        super(saldo, tasa_anual);
        if (saldo>1000) {
           this.activa=true; 
        }
        else
        this.activa=false;
        
          
    }

    @Override
    public float consignar(float cantidad) {
        if(!activa){
            System.out.println("Cuenta inactiva. No se puede consignar.");
            return -1;
        }
        return super.consignar(cantidad);
    }

    @Override
    public float extractoMensual() {
      if(retiros>4){
        comision_mensual+=(retiros-4)*1000;
      }
      float saldoFinal=super.extractoMensual();
      activa=saldoFinal>=1000;

      return super.extractoMensual();
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comision_mensual);
        System.out.println("Transacciones realizadas: " + (consignaciones + retiros));
        System.out.println("Cuenta activa: " + activa);
    }

    @Override
    public float retirar(float cantidad) {
           if(!activa){
            System.out.println("Cuenta . No se puede retirar.");
            return -1;
        }
        return super.retirar(cantidad);
    }

    public boolean isActiva() {
        return activa;
    }

    

}
