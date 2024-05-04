package com.alura.conversordemonedas.models;

import javax.swing.*;

public class ConversorDeMonedas {
    public String monedaBase;
    public String monedaCambio;
    private   int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void convertirMonedas() {
        JOptionPane.showMessageDialog(null, "Has seleccionado el Conversor de Monedas");

        // solicitar al usuario que seleccione las monedas y la cantidad a convertir
        Object[] opciones = {"USD =>> COP", "USD =>> MXN", "USD =>> EUR", "COP =>> USD", "MXN =>> USD", "EUR =>> USD"};
        String seleccion = (String) JOptionPane.showInputDialog(null, "Elige la moneda que desea convertir:",
                "Monedas",
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        // Separar la moneda de origen y destino


        if (seleccion != null) {
            String[] monedas = seleccion.split(" =>> ");
            monedaBase = monedas[0];
            monedaCambio = monedas[1];
            cantidad = mensaje();
        }
    }

    public int mensaje (){
        return  Integer.parseInt(JOptionPane.showInputDialog("Por favor, ingresa la cantidad de dinero que desea convertir:"));
    }
    // Luego, utilizar la clase ConsultaDeMonedas para obtener las tasas de cambio y realizar la conversión
    public double convertirCantidad(double conversionRate) {
        return cantidad * conversionRate;
    }
}
