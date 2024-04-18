import java.util.Scanner;
import java.util.UUID;

public class juegos extends fichero {

    public juegos(){
        super();
        this.ruta = "juegos.txt";
    }


    @Override
    public void eliminar(String id){
        
    }

    /**
     * Este metodo pide los datos que se van a introducir en el momento para agregarlos al fichero
     */
    public void pedir_datos(){
        this.datos.clear();
        Scanner scanner = new Scanner(System.in);
        UUID id = UUID.randomUUID();
        System.out.println("Introduzca el nombre del Juego: ");
        String nombre = scanner.nextLine();
        System.out.println("En cuantas plataformas esta disponible: ");
        int cantidad_consolas = scanner.nextInt();
        System.out.println("Cuales son: ");
        String plataformas = scanner.nextLine();
        plataformas = ("[" + plataformas);
        for (int i = 0; i < cantidad_consolas; i++){
            plataformas = scanner.nextLine();
            plataformas = (plataformas + "," + plataformas);
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
        scanner.close();
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
