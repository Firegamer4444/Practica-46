import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

abstract class fichero {
    String ruta;
    ArrayList<String> datos;
    
    public fichero(){
        this.ruta = "ruta.txt";
        this.datos = new ArrayList<String>();
    }

    /**
     * Este metodo agrega en el fichero los datos que se han almacenado en el objeto fichero
     */
    public void agregar(){ 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.ruta, true));){
            String linea = this.datos.get(0);
            for (int i = 1 ; i < this.datos.size() ; i++){
                linea = (linea + ", " + this.datos.get(i));
            }
            writer.write(linea);
            writer.newLine();
        }
        catch (IOException e) {
            System.out.print("Error al leer el archivo");
        }
    }

    /**
     * A este metodo se le pasa un identificador y busca en el fichero la linea con esa id , y devuelve la linea
     * @param id identificador del fichero 
     * @return 
     */
    public String busqueda(String id){
        String linea = null; 
        try (FileReader fileReader = new FileReader(this.ruta);
        BufferedReader bufferedReader = new BufferedReader(fileReader);){
        while((linea=bufferedReader.readLine()) != null) {
            String[] linea_c = linea.split(", ");
            if (linea_c[0].equals(id)){
                return linea;
            }
        }
        return linea;
        }
        catch (IOException e) {
            System.out.print("Error al leer el archivo");
            return linea;
        }
    }

    /**
     * este metodo elimina un registro mediante el id pasado por parametro
     * @param id identificador del fichero
     */
    public void eliminar(String id){
        // se crea un archivo temporal
        File arhchivoOriginal = new File(this.ruta);
        File archivoTemp = new File("ficheros/temp.txt");
        String linea = null;
        try (FileReader fileReader = new FileReader(this.ruta); BufferedReader bufferedReader = new BufferedReader(fileReader); 
        BufferedWriter writer = new BufferedWriter(new FileWriter("ficheros/temp.txt"))){
        // se escribe en el archivo temporal todo el contenido del original menos la linea de la que coincida el id
        while((linea=bufferedReader.readLine()) != null) {
            String[] linea_c = linea.split(", ");
            if (!linea_c[0].equals(id)){
                writer.write(linea);
                writer.newLine();
            }
        }  
        }
        catch (IOException e) {
            System.out.print("Error al leer el archivo");
        }
        // se borra el archivo original y se renombra el archivo temporal
        arhchivoOriginal.delete();
        archivoTemp.renameTo(arhchivoOriginal);
    }

    abstract void pedir_datos(Scanner scanner);

    abstract void imprimir_datos(String linea);
    
}
