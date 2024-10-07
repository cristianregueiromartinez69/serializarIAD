package serializacion1;

import java.io.*;

/**
 * clase main donde ejecutamos el programa
 * @author cristian
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        //instanciamos el objeto de una clase
        MClase obj1 = new MClase("ola", -7, 2.7E10);

        //introducimos una ruta
        String ruta_fichero = "/home/dam/Desktop/DAM2/Acceso a Datos/SerializacionI/serial.tmp";

        try {

            //usamos la clase ObjectOutputStream y usamos el metodo writeObject para escribir el objeto
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(ruta_fichero));
            ous.writeObject(obj1);

            //cerramos el fichero
            ous.close();

        } catch (IOException e) {
            System.out.println("Ups, ha ocurrido un error al escribir el objeto");
        }

        //creamos un objeto vacio
        MClase obj2 = new MClase();
        try{
            
            //usamos la clase ObjectInputStream con el metodo readObject y su posterior casteo para leer el objeto
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta_fichero));
            
            obj2 = (MClase) ois.readObject();
            System.out.println(obj2);
            
            //cerramos el fichero
            ois.close();
            
        }catch(IOException e){
            System.out.println("Ups, no se ha podido leer el archivo");
        }catch(ClassNotFoundException e2){
            System.out.println("ups, no se encontró la clase");
        }

    }

}
