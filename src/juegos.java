import java.util.Scanner;
import java.util.UUID;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class juegos extends fichero {

    public juegos(){
        super();
        this.ruta = "ficheros/juegos.txt";
    }

    
    @Override
    /**
     * Este metodo sirve para marcar como obsoleto el videojuego
     */
    public void eliminar(String id){
        File arhchivoOriginal = new File(this.ruta);
        File archivoTemp = new File("ficheros/temp.txt");
        String linea = null;
        try (FileReader fileReader = new FileReader(this.ruta); BufferedReader bufferedReader = new BufferedReader(fileReader); 
        BufferedWriter writer = new BufferedWriter(new FileWriter("ficheros/temp.txt"))){
        // se escribe en el archivo temporal todo el contenido del original menos la linea de la que coincida el numero de serie
        while((linea=bufferedReader.readLine()) != null) {
            String[] linea_c = linea.split(", ");
            if (!linea_c[0].equals(id)){
                writer.write(linea);
                writer.newLine();
            }
            else{
                writer.write(linea_c[0] + ", " + linea_c[1] + ", " + linea_c[2] + ", Obsoleto");
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

    /**
     * Este metodo pide los datos que se van a introducir en el momento para agregarlos al fichero
     */
    public void pedir_datos(Scanner scanner){
        this.datos.clear();
        UUID id = UUID.randomUUID();
        System.out.println("Introduzca el nombre del Juego: ");
        String nombre = scanner.nextLine();
        System.out.println("En cuantas plataformas esta disponible: ");
        int cantidad_consolas = scanner.nextInt();
        System.out.println("Cuales son: ");
        String plataformas = scanner.nextLine();
        String plataforma = scanner.nextLine();
        plataformas = ("[" + plataforma);
        for (int i = 1; i < cantidad_consolas; i++){
            plataforma = scanner.nextLine();
            plataformas = (plataformas + "," + plataforma);
        }
        plataformas = (plataformas + "]");
        System.out.println("El Juego esta en venta (y/n): ");
        String estado = scanner.nextLine();
        if (estado.equals("y")){
            estado = ("En venta");
        }
        else if(estado.equals("n")){
            estado = ("Obsoleto");
        }
        this.datos.add(id.toString());
        this.datos.add(nombre);
        this.datos.add(plataformas);
        this.datos.add(estado);
    }

    /**
     * Este metodo imprime los datos de la linea que se le pasa
     * @param linea la linea que se va a imprimir
     */
    public void imprimir_datos(String linea){
        String[] linea_c = linea.split(", ");
        System.out.println("nombre: " + linea_c[1]);
        System.out.println("consolas: " + linea_c[2]);
        System.out.println("estado: " + linea_c[3]);
    }
}
