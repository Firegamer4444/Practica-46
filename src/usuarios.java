import java.util.Scanner;

public class usuarios extends fichero {

    public usuarios(){
        super();
        this.ruta = "usuarios.txt";
    }

    /**
     * Este metodo pide los datos que se van a introducir en el momento para agregarlos al fichero
     */
    public void pedir_datos(){
        this.datos.clear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el dni: ");
        String dni = scanner.nextLine();
        System.out.println("Introduzca el nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Introduzca los apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.println("Introduzca el telefono: ");
        String telefono = scanner.nextLine(); 
        System.out.println("Introduzca el correo: ");
        String correo = scanner.nextLine();
        scanner.close();
        this.datos.add(dni);
        this.datos.add(nombre);
        this.datos.add(apellidos);
        this.datos.add(telefono);
        this.datos.add(correo);
    }

    /**
     * Este metodo imprime los datos de la linea que se le pasa
     * @param linea La linea que va a imprimir
     */
    public void imprimir_datos(String linea){
        String[] linea_c = linea.split(", ");
        System.out.println("nombre: " + linea_c[1]);
        System.out.println("apellidos: " + linea_c[2]);
        System.out.println("telefono: " + linea_c[3]);
        System.out.println("correo: " + linea_c[4]);
    } 
}
