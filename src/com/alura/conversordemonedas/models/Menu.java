package com.alura.conversordemonedas.models;

import javax.swing.*;

public class Menu {
    public void mostrarMenu() {
        Object[] opciones = {"Conversor de monedas"};
        Object seleccion = JOptionPane.showInputDialog(null, "Elige una opción:",
                "Menu",
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion != null) {
            ConversorDeMonedas conversor = new ConversorDeMonedas();
            conversor.convertirMonedas();
            // Aquí pasamos la moneda de cambio al constructor de ConsultaDeMonedas
            ConsultaDeMonedas consultaDeMonedas = new ConsultaDeMonedas(conversor.monedaBase, conversor.monedaCambio);
            Monedas monedas = consultaDeMonedas.obtenerTasasDeCambio();
            System.out.println(monedas);

            double totalConvertido = conversor.convertirCantidad(monedas.conversion_rate());
            JOptionPane.showMessageDialog(null, "el valor " + conversor.getCantidad() + " " + "[" +conversor.monedaBase + "]" +" convertido a " + "[" +conversor.monedaCambio + "]" +" es de: " + totalConvertido);


        }
    }
}
