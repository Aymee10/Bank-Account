# Sistema de Cuentas Bancarias en Java

Este proyecto implementa un sistema de cuentas bancarias con herencia en Java

## Clases principales

- **Cuenta**  
  Clase base con saldo, consignaciones, retiros, tasa anual y comisión mensual.  
  Métodos para consignar, retirar, calcular intereses, generar extracto mensual e imprimir datos.

- **CuentaAhorro** (extiende Cuenta)  
  Añade control de cuenta activa/inactiva según el saldo.  
  Aplica comisiones por retiros excesivos.

- **CuentaCorriente** (extiende Cuenta)  
  Permite sobregiro y gestión de consignaciones que reduzcan dicho sobregiro.

## Tecnologías

- Java 21
- JUnit 5.12
- Hamcrest 3.0
- Maven 21

 ## Diagrama de clases
 <img width="565" height="525" alt="diagrama de clases" src="https://github.com/user-attachments/assets/01a759bb-1ed7-4439-8e9c-c64386efcff4" />

 ## Test
 
<img width="310" height="156" alt="test" src="https://github.com/user-attachments/assets/49cce093-be61-470c-ad01-f0e3b98dd9c1" />
