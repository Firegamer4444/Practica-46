import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class compras extends fichero {

    public compras(){
        super();
        this.ruta = "ficheros/compras.txt";
    }

    // no defino el metodo imprimir datos ya que compras nesecita un parametro más que no esta definido en imprimir datos
    @Override
    public void imprimir_datos(String linea){
        return ;
    }

    @Override
    /**
     * Este metodo sirve para buscar los juegos del usuario pasado por parametro
     * @param id El id del usuario
     */
    public String busqueda(String id){
        String linea = null;
        String lineas = null;
        Boolean existe = false;
        try (FileReader fileReader = new FileReader(this.ruta);
        BufferedReader bufferedReader = new BufferedReader(fileReader);){
        while((linea=bufferedReader.readLine()) != null) {
            String[] linea_c = linea.split(", ");
            if (linea_c[0].equals(id)){
                lineas = (lineas + "," + linea_c[1]);
                existe = true;
            }
        }
        if (existe == false) {
            System.out.print("El dni introducido no existe");   
        }
        return lineas;
        }
        catch (IOException e) {
            System.out.print("Error al leer el archivo");
            return lineas;
        }
    }

    /**
     * Este metodo pide los datos que se van a introducir en el momento para agregarlos al fichero
     */
    public void pedir_datos(Scanner scanner){
        this.datos.clear();
        System.out.println("Introduzca el dni del usuario: ");
        String dni = scanner.nextLine();
        System.out.println("Introduzca el numero de serie: ");
        String numSerie = scanner.nextLine();
        this.datos.add(dni);
        this.datos.add(numSerie);
    }

    /**
     * Este metodo imprime
     * @param linea Los numero de serie de los juegos 
     * @param juego El objeto juego para poder buscar los juegos e imprimir sus datos
     */
    public void imprimir_Juegos(String linea , juegos juego){
        String[] linea_c = linea.split(",");
        System.out.println("Juegos comprados por el usuario: ");
        for (int i = 1 ; i < linea_c.length ; i++){
            System.out.println("");
            String lineaJuego = juego.busqueda(linea_c[i]);
            juego.imprimir_datos(lineaJuego);
        }
    }

}
