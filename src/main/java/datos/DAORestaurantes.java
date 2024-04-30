package datos;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import modelos.Restaurante;
import java.util.ArrayList;
import java.util.Arrays;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.types.ObjectId;

public class DAORestaurantes {

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;

    public DAORestaurantes() {
        mongoClient = MongoClients.create();
        database = mongoClient.getDatabase("restaurantes_228558");
        collection = database.getCollection("restaurantes");
    }
    
    public Restaurante insertarRestaurante(Restaurante restaurante) {
    Document doc = new Document("nombre", restaurante.getNombre())
        .append("categorias", restaurante.getCategorias())
        .append("rating", restaurante.getRating());
    collection.insertOne(doc);// Inserta el documento
    restaurante.setId(doc.getObjectId("_id")); 
    return restaurante; 
}


 public ArrayList<Restaurante> consultarRestaurantesPorRating(double minRating) {
    ArrayList<Restaurante> restaurantes = new ArrayList<>();
    try (MongoCursor<Document> cursor = collection.find(gt("rating", minRating)).iterator()) {
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            Restaurante restaurante = new Restaurante(doc.getString("nombre"), (ArrayList<String>) doc.getList("categorias", String.class), doc.getDouble("rating"));
            restaurante.setId(doc.getObjectId("_id")); // Asigna el ID
            restaurantes.add(restaurante);
        }
    }
    return restaurantes;
}

public ArrayList<Restaurante> consultarRestaurantesPorCategoria(String categoria) {
    ArrayList<Restaurante> restaurantes = new ArrayList<>();
    try (MongoCursor<Document> cursor = collection.find(all("categorias", Arrays.asList(categoria))).iterator()) {
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            Restaurante restaurante = new Restaurante(doc.getString("nombre"), (ArrayList<String>) doc.getList("categorias", String.class), doc.getDouble("rating"));
            restaurante.setId(doc.getObjectId("_id")); // Asigna el ID
            restaurantes.add(restaurante);
        }
    }
    return restaurantes;
}

public ArrayList<Restaurante> obtenerTodosLosRestaurantes() {
    ArrayList<Restaurante> restaurantes = new ArrayList<>();
    try (MongoCursor<Document> cursor = collection.find().iterator()) {
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            Restaurante restaurante = new Restaurante(doc.getString("nombre"), (ArrayList<String>) doc.getList("categorias", String.class), doc.getDouble("rating"));
            restaurante.setId(doc.getObjectId("_id")); // Asigna el ID
            restaurantes.add(restaurante);
        }
    }
    return restaurantes;
}

    public void agregarCategoriaARestaurante(String id, String nuevaCategoria) {
        ObjectId objectId = new ObjectId(id);
        collection.updateOne(eq("_id", objectId), push("categorias", nuevaCategoria));
    }

    public boolean eliminarRestaurantePorId(String id) {
        ObjectId objectId = new ObjectId(id);
        DeleteResult result = collection.deleteOne(eq("_id", objectId));
        return result.getDeletedCount() > 0;
    }

    public long eliminarRestaurantesPorRating(double maxRating) {
        DeleteResult result = collection.deleteMany(lte("rating", maxRating));
        return result.getDeletedCount();
    }
}
