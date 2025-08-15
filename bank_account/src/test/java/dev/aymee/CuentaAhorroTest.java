package dev.aymee;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaAhorroTest {
    CuentaAhorro cuentaActiva;
    CuentaAhorro cuentaInactiva;

     @BeforeEach
    void setUp() {
         cuentaActiva = new CuentaAhorro(15000f, 12f);
         cuentaInactiva = new CuentaAhorro(500f, 12f);
    }

    @Test
    void ConsignarCuentaActivaTest() {
        float saldoFinal = cuentaActiva.consignar(2000f);

        assertThat(saldoFinal, is(17000f));
        assertThat(cuentaActiva.getConsignaciones(), is(1));
    }

    @Test
    void ConsignarCuentaInactivaTest() {
        float resultado = cuentaInactiva.consignar(1000f);

        assertThat(resultado, is(-1f));
        assertThat(cuentaInactiva.getConsignaciones(), is(0));
    }
     @Test
    void retirarCuentaActivaTest() {
        float saldoFinal = cuentaActiva.retirar(3000f);

        assertThat(saldoFinal, is(12000f));
        assertThat(cuentaActiva.getRetiros(), is(1));
    }

    @Test
    void retirarCuentaInactivaTest() {
        float resultado = cuentaInactiva.retirar(500f);

        assertThat(resultado, is(-1f));
        assertThat(cuentaInactiva.getRetiros(), is(0));
    }

    @Test
    void extractoMensualSinComisionExtraTest() {
        cuentaActiva.retirar(1f);
        float saldoFinal = cuentaActiva.extractoMensual();

        assertThat(cuentaActiva.isActiva(), is(true));
        assertThat(cuentaActiva.getComision_mensual(), is(0f));
    }
    
    @Test
    void extractoMensualConComisionExtraTest(){
        for (int i = 0; i < 6; i++) {
            cuentaActiva.retirar(1f);
        }
        cuentaActiva.extractoMensual();
        assertThat(cuentaActiva.getComision_mensual(), is(2000f));
    }

    }
