/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mongorestaurantes_228558;

import datos.DAORestaurantes;
import java.util.ArrayList;
import java.util.Arrays;
import modelos.Restaurante;

/**
 *
 * @author eduar
 */
public class MongoRestaurantes_228558 {

    public static void main(String[] args) {
        DAORestaurantes dao = new DAORestaurantes();

        /**
         * // Insertar 3 restaurantes con al menos 2 categorías cada uno
         * dao.insertarRestaurante(new Restaurante("La Buena Mesa", new
         * ArrayList<>(Arrays.asList("Española", "Tapas")), 4.5));
         * dao.insertarRestaurante(new Restaurante("Pizzería Gourmet", new
         * ArrayList<>(Arrays.asList("Pizza", "Italiana")), 4.2));
         * dao.insertarRestaurante(new Restaurante("Sushi World", new
         * ArrayList<>(Arrays.asList("Sushi", "Japonesa")), 4.8));
         *
         **/
         // Consultar los restaurantes con más de 4 estrellas de rating
         System.out.println("Restaurantes con más de 4 estrellas:");
         ArrayList<Restaurante> restaurantesConAltoRating =
         dao.consultarRestaurantesPorRating(4); for (Restaurante restaurante :
         restaurantesConAltoRating) { System.out.println(restaurante); }
         
         // Consultar los restaurantes que incluyan la categoría pizza
         System.out.println("\nRestaurantes que incluyen la categoría Pizza:"); ArrayList<Restaurante> restaurantesConPizza =
         dao.consultarRestaurantesPorCategoria("Pizza"); for (Restaurante
         restaurante : restaurantesConPizza) {
         System.out.println(restaurante); }
        
         // Consultar los restaurantes que incluyan sushi en su nombre
         System.out.println("\nRestaurantes que incluyen 'Sushi' en el nombre:"); ArrayList<Restaurante> restaurantesConSushiEnNombre =
         dao.obtenerTodosLosRestaurantes(); for (Restaurante restaurante :
         restaurantesConSushiEnNombre) { if
         (restaurante.getNombre().toLowerCase().contains("sushi")) {
         System.out.println(restaurante); } }
    }
}
