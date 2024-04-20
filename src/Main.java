import java.util.Scanner;

public class Main {
    
    /**
     * El metodo menu es el metodo que se ejecuta al ejecutar el programa y es un menu que le permite al usuario usar las funcionalidades del programa
     */
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        usuarios Usuarios = new usuarios();
        juegos Juegos = new juegos();
        compras Compras = new compras();
        while (true) {
            System.out.println("\n--- Opciones: ---");
            System.out.println("1. Consultar o modificar Juegos");
            System.out.println("2. Consultar o modificar Usuarios");
            System.out.println("3. Consultar o Realizar compra");
            System.out.println("4. Cerrar el programa");
            System.out.println("Seleccione una opcion: ");
            String opcion = scanner.nextLine();
            if (opcion.equals("1")) {
                while (true){
                    System.out.println("\n--- Opciones: ---");
                    System.out.println("1. Buscar Juego");
                    System.out.println("2. Agregar Juego");
                    System.out.println("3. marcar como obsoleto");
                    System.out.println("4. Volver al menu");
                    System.out.println("Seleccione una opcion: ");
                    String opcion_2 = scanner.nextLine();
                    if (opcion_2.equals("1")){
                        System.out.println("Introduzca el numero de serie: ");
                        String numSerie = scanner.nextLine();
                        String linea = Juegos.busqueda(numSerie);
                        if (linea == null){
                            System.out.println("Introduciste un identificador inexistente \nVuelva a elejir una opcion");
                        }
                        else {
                            Juegos.imprimir_datos(linea);
                        }
                    }
                    else if (opcion_2.equals("2")){
                        Juegos.pedir_datos(scanner);
                        Juegos.agregar();
                    }
                    else if (opcion_2.equals("3")){
                        System.out.println("Introduzca el numero de serie: ");
                        String numSerie = scanner.nextLine();
                        Juegos.eliminar(numSerie);
                    }
                    else if (opcion_2.equals("4")){
                        break;
                    }
                }
            }
            else if (opcion.equals("2")){
                while (true){
                    System.out.println("\n--- Opciones: ---");
                    System.out.println("1. Buscar usuario por DNI");
                    System.out.println("2. Agregar usuario");
                    System.out.println("3. Eliminar usuario");
                    System.out.println("4. Volver al menu");
                    System.out.println("Seleccione una opcion: ");
                    String opcion_3 = scanner.nextLine();
                    if (opcion_3.equals("1")) {
                        System.out.println("Introduzca el dni: ");
                        String dni = scanner.nextLine();
                        String linea = Usuarios.busqueda(dni);
                        if (linea == null){
                            System.out.println("Introduciste un identificador inexistente \nVuelva a elejir una opcion");
                        }
                        else {
                            Usuarios.imprimir_datos(linea);
                        }
                    }
                    else if(opcion_3.equals("2")){
                        Usuarios.pedir_datos(scanner);
                        Usuarios.agregar();
                    }
                    else if (opcion_3.equals("3")){
                        System.out.println("Introduzca el dni: ");
                        String dni = scanner.nextLine();
                        Usuarios.eliminar(dni);
                    }
                    else if(opcion_3.equals("4")){
                        break;
                    }
                }
            }
            else if (opcion.equals("3")){
                while (true) {
                    System.out.println("\n--- Opciones: ---");
                    System.out.println("1. Revisar compras");
                    System.out.println("2. Realizar compras");
                    System.out.println("3. Volver al menu");
                    System.out.println("Seleccione una opcion: ");
                    String opcion_4 = scanner.nextLine();
                    if (opcion_4.equals("1")){
                        System.out.println("Introduzca el dni: ");
                        String dni = scanner.nextLine();
                        String linea = Compras.busqueda(dni);
                        Compras.imprimir_Juegos(linea, Juegos);
                    }
                    else if (opcion_4.equals("2")){
                        Compras.pedir_datos(scanner);
                        Compras.agregar();
                    }
                    else if (opcion_4.equals("3")){
                        break;
                    }
                }
            }
            else if (opcion.equals("4")){
                scanner.close();
                return;
            }
        }
    }

    public static void main(String[] args){
        menu();
    }
}

