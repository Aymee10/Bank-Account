package dev.aymee;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {
    CuentaCorriente cuenta;
    @BeforeEach
      void setUp() {
        cuenta = new CuentaCorriente(10000f, 12f); 
       }  
       
    @Test
    void retirarSinSobregiroTest() {
        float saldoFinal = cuenta.retirar(8000f);
        assertThat(saldoFinal, is(2000f));
        assertThat(cuenta.getSobregiro(), is(0f));
    }

    @Test
    void retirarConSobregiroTest(){
        float saldoFinal = cuenta.retirar(12000f);
        assertThat(saldoFinal, is(0f));
        assertThat(cuenta.getSobregiro(), is(2000f));
    } 

    @Test
    void consignarReduciendoSobregiroTest() {
        cuenta.retirar(12000f);
        float saldoFinal = cuenta.consignar(1500f);
        assertThat(saldoFinal, is(0f));
        assertThat(cuenta.getSobregiro(), is(500f));
    }
   @Test
    void consignarSinSobregiroTest() {
       float saldoFinal = cuenta.consignar(1000f);
       assertThat(saldoFinal, is(11000f));       
    }
}
