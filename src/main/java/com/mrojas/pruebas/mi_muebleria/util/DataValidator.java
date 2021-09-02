package com.mrojas.pruebas.mi_muebleria.util;

public class DataValidator {

    public static boolean isEntero(String valor) {
        boolean valido = false;

        try {
            int cantidad = Integer.parseInt(valor);
            if (cantidad > 0) {
                valido = true;
            }
        } catch (NumberFormatException e) {
            System.out.println("No es un caracter entero");
        }

        return valido;
    }

    public static boolean isDouble(String valor){
        boolean valido = false;

        try {
            double cantidad = Double.parseDouble(valor);
            if (cantidad > 0) {
                valido = true;
            }
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println("No es un caracter double");
        }

        return valido;
    }

    public static boolean isValidString(String valor){
        boolean valido = true;
        if (valor == null || valor.isBlank()) {
            valido = false;
        }
        return valido;
    }

    public static double redondearNumero(double numero, int decimales){
        double cantidadCero = Math.pow(10.0, decimales);
        double valor = Math.round(numero*cantidadCero)/cantidadCero;
        return valor;
    }

}
