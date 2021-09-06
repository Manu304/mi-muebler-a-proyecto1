package com.mrojas.pruebas.mi_muebleria.util;

public class DataValidator {

    /**
     * Metodo que valida un string como entero positivo mayor a cero
     * 
     * @param valor El String a validar
     * @return Retorna true si es entero mayor a cero, de lo contrario retorna
     *         false.
     */

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

    /**
     * Metodo que valida un string como double positivo mayor a cero
     * 
     * @param valor El String a validar
     * @return Retorna true si es un double mayor a cero, de lo contrario retorna
     *         false
     */

    public static boolean isDouble(String valor) {
        boolean valido = false;
        if (!valor.endsWith(".")) {
            try {
                double cantidad = Double.parseDouble(valor);
                if (cantidad > 0) {
                    valido = true;
                }
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("No es un caracter double");
            }
        }

        return valido;
    }

    /**
     * Metodo que valida un string como no vacío
     * 
     * @param valor El String a validar
     * @return Retorna true si el string no es vacio o null.
     */

    public static boolean isValidString(String valor) {
        boolean valido = true;
        if (valor == null || valor.isBlank()) {
            valido = false;
        }
        return valido;
    }

    /**
     * Metodo que valida un String como alfanumerico
     * 
     * @param valor El String a validar
     * @return Retorna true si el string contiene solo letras del abecedario inglés,
     *         espacios y números, de lo contrario retorna false.
     */

    public static boolean isAlfanumerico(String valor) {
        boolean valido = true;
        for (int i = 0; i < valor.length(); i++) {
            char char1 = valor.toLowerCase().charAt(i);

            if (!((char1 >= 'a' && char1 <= 'z') || (char1 >= '0' && char1 <= '9')) && char1 != ' ') {
                valido = false;
            }
        }
        return valido;
    }

    /**
     * Método para redondear un double a dos decimales significativos.
     * 
     * @param numero    El número que se desea aproximar
     * @param decimales La cantidad de decimales que se desan en el número
     * @return Devuelve un número con la cantidad de decimales indicada.
     */

    public static double redondearNumero(double numero, int decimales) {
        double cantidadCero = Math.pow(10.0, decimales);
        double valor = Math.round(numero * cantidadCero) / cantidadCero;
        return valor;
    }

}
