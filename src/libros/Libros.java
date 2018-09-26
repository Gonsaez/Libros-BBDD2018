/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Gonzalo Sáez Martí
 */
public class Libros {

    public void EscribeFicheroTextoFileWriter() {
        //Crea el String con la cadena XML
        String texto = "<Libros><Libro><Titulo>El Capote</Titulo></Libro></Libros>";
//Guarda en la variable nombre el nombre del archivo que se creará.
        String nombre = "src\\libros\\libros.xml";
        try {
//Se crea un Nuevo objeto FileWriter
            FileWriter fichero = new FileWriter(nombre);
//Se escribe el fichero
            fichero.write(texto + "\r\n");
//Se cierra el fichero
            fichero.close();
        } catch (IOException ex) {
            System.out.println("error al acceder al fichero");
        }
    }

    public int LeerFicheroTextoFileReader() {
        try {
            FileReader fr = new FileReader("src\\libros\\libros.xml");
            int valor = fr.read();
            while (valor != -1) {
                System.out.print((char) valor);
                valor = fr.read();
            }
        } catch (IOException ex) {
            System.out.println("Error al leer el fichero");
        }
        return -1;
    }

    public void EscribeFicheroTextoBufferedWriter() {
        //Crea el String con la cadena XML
        String texto = "<Libros><Libro><Titulo>El Capote</Titulo></Libro></Libros>";
//Guarda en la variable nombre el nombre del archivo que se creará.
        String nombre = "src\\libros\\libros1.xml";
        try (BufferedWriter fichero1 = new BufferedWriter(new FileWriter(nombre))) {

            fichero1.write("<Libros>");
            fichero1.newLine();
            fichero1.write("<Libro>");
            fichero1.newLine();
            fichero1.write("<Titulo>");
            fichero1.newLine();
            fichero1.write("El Capote");
            fichero1.newLine();
            fichero1.write("<Titulo>");
            fichero1.newLine();
            fichero1.write("<Libro>");
            fichero1.newLine();
            fichero1.write("<Libros>");
            
            fichero1.close();
        } catch (IOException ex) {
            System.out.println("error al acceder al fichero");
        }
    }

    public int LeerFicheroTextoBufferedReader() {
        try {
            BufferedReader fr1 = new BufferedReader(new FileReader("src\\libros\\libros1.xml"));
            String valor = fr1.readLine();
            while (valor != null) {
                System.out.println(valor);
                valor = fr1.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error al leer el fichero");
        }
        return -1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File f = new File("src\\libros\\libros.xml");
        if (f.exists()) {
            System.out.println("nombre: " + f.getName());
            System.out.println("Directorio padre: " + f.getParent());
            System.out.println("Ruta relativa: " + f.getPath());
            System.out.println("Ruta absoluta: " + f.getAbsolutePath());
        }
        System.out.println("--------------------------------------------------------------------------------------------------");

        Libros obj_libros = new Libros();

        System.out.println("Escritura y lectura del fichero libros.xml con File...");
        obj_libros.EscribeFicheroTextoFileWriter();
        obj_libros.LeerFicheroTextoFileReader();

        System.out.println("-----------------------------------------");

        System.out.println("Escritura y lectura del fichero libros.xml con Buffered");
        obj_libros.EscribeFicheroTextoBufferedWriter();
        obj_libros.LeerFicheroTextoBufferedReader();

    }
}
