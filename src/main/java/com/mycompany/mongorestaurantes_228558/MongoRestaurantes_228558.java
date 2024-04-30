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
         *
         */
        // Consultar los restaurantes con más de 4 estrellas de rating
        System.out.println("Restaurantes con más de 4 estrellas:");
        ArrayList<Restaurante> restaurantesConAltoRating
                = dao.consultarRestaurantesPorRating(4);
        for (Restaurante restaurante
                : restaurantesConAltoRating) {
            System.out.println(restaurante);
        }

        // Consultar los restaurantes que incluyan la categoría pizza
        System.out.println("\nRestaurantes que incluyen la categoría Pizza:");
        ArrayList<Restaurante> restaurantesConPizza
                = dao.consultarRestaurantesPorCategoria("Pizza");
        for (Restaurante restaurante : restaurantesConPizza) {
            System.out.println(restaurante);
        }

        // Consultar los restaurantes que incluyan sushi en su nombre
        System.out.println("\nRestaurantes que incluyen 'Sushi' en el nombre:");
        ArrayList<Restaurante> restaurantesConSushiEnNombre
                = dao.obtenerTodosLosRestaurantes();
        for (Restaurante restaurante
                : restaurantesConSushiEnNombre) {
            if (restaurante.getNombre().toLowerCase().contains("sushi")) {
                System.out.println(restaurante);
            }
        }

        /**
         * Restaurante sushilito = new Restaurante("Sushilito", new
         * ArrayList<>(Arrays.asList("Sushi", "Japonesa")), 4.2); sushilito =
         * dao.insertarRestaurante(sushilito); // Guardar y obtener el ID
         * asignado por MongoDB System.out.println("Categorías originales: " +
         * sushilito.getCategorias());
        *
         */
        // Agregar una categoría extra
        // dao.agregarCategoriaARestaurante(sushilito.getId().toString(), "Fusión");
        System.out.println("\nRestaurantes actualizados:");
        ArrayList<Restaurante> rA
                = dao.obtenerTodosLosRestaurantes();
        for (Restaurante restaurante
                : rA) {
            System.out.println(restaurante);
        }
        
        /**
        // Eliminar el restaurante con ID específico
        String idAEliminar = "66315542cd38e973f5fa7593";
        if (dao.eliminarRestaurantePorId(idAEliminar)) {
            System.out.println("Restaurante eliminado con éxito.");
        } else {
            System.out.println("El restaurante no se pudo eliminar o no se encontró.");
        }
        **/
        
        System.out.println("\nRestaurantes actualizados después de eliminar/no eliminar:");
        ArrayList<Restaurante> rae
                = dao.obtenerTodosLosRestaurantes();
        for (Restaurante restaurante
                : rae) {
            System.out.println(restaurante);
        }
        
        // Eliminar los restaurantes con 3 estrellas o menos
        dao.insertarRestaurante(new Restaurante("La Buena Mesa", new ArrayList<>(Arrays.asList("Española", "Tapas")), 2.4));
        System.out.println("\nRestaurantes (con 3 estrellas o menos incluidas)");
        ArrayList<Restaurante> rest
                = dao.obtenerTodosLosRestaurantes();
        for (Restaurante restaurante
                : rest) {
            System.out.println(restaurante);
        }
        long eliminados = dao.eliminarRestaurantesPorRating(3);
        System.out.println("\nRestaurantes (con 3 estrellas o menos eliminadas)");
        ArrayList<Restaurante> el
                = dao.obtenerTodosLosRestaurantes();
        for (Restaurante restaurante
                : el) {
            System.out.println(restaurante);
        }
        System.out.println("Número de restaurantes eliminados con 3 estrellas o menos: " + eliminados);

    }
}
