package Floristeria.persistence;

import java.io.*;

/**
 * Clase de utilidad para serialización y deserialización de objetos.
 * Proporciona métodos estáticos para guardar y recuperar objetos a y desde archivos utilizando serialización de Java.
 */
public class SerializationUtil {

    /**
     * Serializa un objeto a un archivo especificado.
     * 
     * Este método toma un objeto y un nombre de archivo y escribe el objeto al archivo especificado
     * utilizando la serialización de objetos de Java. El archivo se crea si no existe, y se sobrescribe si ya existe.
     *
     * @param obj El objeto a serializar.
     * @param fileName El nombre del archivo donde se guardará el objeto serializado.
     * @throws IOException Si ocurre un error de entrada/salida durante la serialización.
     */
    public static void serialize(Object obj, String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
        }
    }

    /**
     * Deserializa un objeto desde un archivo especificado.
     * 
     * Este método lee un objeto desde el archivo dado, asumiendo que el archivo contiene un objeto serializado
     * mediante el método {@link #serialize(Object, String)}. Retorna el objeto Java recuperado.
     *
     * @param fileName El nombre del archivo desde donde deserializar el objeto.
     * @return El objeto deserializado.
     * @throws IOException Si ocurre un error de entrada/salida durante la deserialización.
     * @throws ClassNotFoundException Si la clase del objeto serializado no se encuentra.
     */
    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            return ois.readObject();
        }
    }
}



