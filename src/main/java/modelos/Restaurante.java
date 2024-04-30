package modelos;

import java.util.ArrayList;
import org.bson.types.ObjectId;

public class Restaurante {
    private ObjectId id;
    private String nombre;
    private ArrayList<String> categorias;
    private double rating;

    public Restaurante(String nombre, ArrayList<String> categorias, double rating) {
        this.nombre = nombre;
        this.categorias = categorias;
        this.rating = rating;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<String> categorias) {
        this.categorias = categorias;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Restaurante{" + "id=" + id + ", nombre=" + nombre + ", categorias=" + categorias + ", rating=" + rating + '}';
    }
}
