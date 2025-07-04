/*
 Parte 2: Leer productos y calcular total
 */
package com.mycompany.practicasjava04.Registrodeproductosconprecios;

import java.io.BufferedReader;
import java.io.FileReader;

public class Leerproductosycalculartotal {

    public static void main(String[] args) {

        String fichero = "productos.txt";
        int total = 0;

        try (BufferedReader leer = new BufferedReader(new FileReader(fichero))) {
            String linea;
            int contador = 1;

            while ((linea = leer.readLine()) != null) {
                System.out.println(contador + "." + linea);

                // Extraer el precio desde la línea
                String[] partes = linea.split("precio: ");
                // Verifica que realmente se hayan creado dos partes al hacer el 
                // split, lo cual significa que el texto tenía "Precio: "
                if (partes.length == 2) {
                    // Convierte el texto "1.20" a un número decimal (double).
                    try {
                        double precio = Double.parseDouble(partes[1]);
                        // Va sumando el precio de cada producto para calcular el total acumulado.
                        total += precio;
                    } catch (NumberFormatException e) {
                        System.out.println("Error al interpretar el precio.");
                    }

                }
                contador++;
            }
            System.out.printf("\nTotal acumulado: %.2f€\n", total);

        } catch (Exception e) {
            System.out.println("Error de lectura " + e.getMessage());
        }

    }

}
