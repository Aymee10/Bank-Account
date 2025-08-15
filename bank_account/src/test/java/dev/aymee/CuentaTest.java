package dev.aymee;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CuentaTest {
    Cuenta cuenta;

    @BeforeEach
    void setUp(){
        cuenta = new Cuenta(1500f, 12f);
    }

    @Test
    void consignarValidoTest(){
       float saldo=cuenta.consignar(200f);
       assertThat(saldo, equalTo(1700f));
       assertThat(1, equalTo(cuenta.getConsignaciones()));
    } 

    @Test
    void consignarNoValidoTest(){
       assertThat(-1f, equalTo(cuenta.consignar(-20f)));
       assertThat(0, equalTo(cuenta.getConsignaciones()));
    } 


     @Test
    void retirarValidoTest(){
       float saldo=cuenta.retirar(500f);
       assertThat(saldo, equalTo(1000f));
       assertThat(1, equalTo(cuenta.getRetiros()));
    } 

    @Test
    void retirarNoValidoTest(){
       assertThat(-1f, equalTo(cuenta.retirar(-20f)));
       assertThat(-1f, equalTo(cuenta.retirar(2000f)));
       assertThat(0, equalTo(cuenta.getRetiros()));
    } 
   
    @Test
    void CalcularInteresTest() {
        float interes = cuenta.calcularInteres();
        assertThat(15f, equalTo(interes));
        assertThat(1515f, equalTo(cuenta.getSaldo()));
    }

    @Test
    void extractoMensualTest(){
        cuenta.comision_mensual=5f;
        float saldo=cuenta.extractoMensual();
        assertThat(1509.95f, equalTo(saldo));
    }
    }
