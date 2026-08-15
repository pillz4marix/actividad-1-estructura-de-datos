import java.util.Scanner;
public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static LinkedList biblioteca = new LinkedList();

    public static void main(String[] args) {

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Selecciona una opción: ");

            switch (opcion) {
                case 1:
                    agregarAlInicio();
                    break;
                case 2:
                    agregarAlFinal();
                    break;
                case 3:
                    insertarEnPosicion();
                    break;
                case 4:
                    mostrarLibros();
                    break;
                case 5:
                    buscarLibro();
                    break;
                case 6:
                    consultarPorPosicion();
                    break;
                case 7:
                    eliminarLibro();
                    break;
                case 8:
                    eliminarPorPosicion();
                    break;
                case 9:
                    mostrarCantidad();
                    break;
                case 10:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
                    break;
            }

        } while (opcion != 10);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("--- BIBLIOTECA ---");
        System.out.println("1. Agregar libro al inicio");
        System.out.println("2. Agregar libro al final");
        System.out.println("3. Insertar libro en posición");
        System.out.println("4. Mostrar libros");
        System.out.println("5. Buscar libro");
        System.out.println("6. Consultar libro por posición");
        System.out.println("7. Eliminar libro");
        System.out.println("8. Eliminar libro por posición");
        System.out.println("9. Mostrar cantidad de libros");
        System.out.println("10. Salir");
    }
    
    // Opciones del menu

    private static void agregarAlInicio() {
        String[] datos = leerDatosLibro();
        biblioteca.insertarAlInicio(datos[0], datos[1], datos[2]);
        System.out.println("Libro agregado al inicio correctamente.");
    }

    private static void agregarAlFinal() {
        String[] datos = leerDatosLibro();
        biblioteca.insertarAlFinal(datos[0], datos[1], datos[2]);
        System.out.println("Libro agregado al final correctamente.");
    }

    private static void insertarEnPosicion() {
        int pos = leerEntero("Posición donde insertar (0 a " + biblioteca.tamano() + "): ");
        String[] datos = leerDatosLibro();
        boolean ok = biblioteca.insertarEnPosicion(pos, datos[0], datos[1], datos[2]);
        if (ok) {
            System.out.println("Libro insertado correctamente en la posición " + pos + ".");
        } else {
            System.out.println("Posición inválida. No se pudo insertar el libro.");
        }
    }

    private static void mostrarLibros() {
        System.out.println("--- Libros registrados ---");
        biblioteca.mostrarLibros();
    }

    private static void buscarLibro() {
        System.out.print("Código del libro a buscar: ");
        String codigo = sc.nextLine();
        Node encontrado = biblioteca.buscarPorCodigo(codigo);
        if (encontrado != null) {
            System.out.println("Libro encontrado: " + encontrado.obtenerInfo());
        } else {
            System.out.println("El libro con código \"" + codigo + "\" no existe.");
        }
    }

    private static void consultarPorPosicion() {
        int pos = leerEntero("Posición a consultar: ");
        Node nodo = biblioteca.obtenerPorPosicion(pos);
        if (nodo != null) {
            System.out.println("Libro en posición " + pos + ": " + nodo.obtenerInfo());
        } else {
            System.out.println("Posición inválida.");
        }
    }

    private static void eliminarLibro() {
        System.out.print("Código del libro a eliminar: ");
        String codigo = sc.nextLine();
        boolean ok = biblioteca.eliminarPorCodigo(codigo);
        if (ok) {
            System.out.println("Libro eliminado correctamente.");
        } else {
            System.out.println("No se encontró un libro con ese código.");
        }
    }

    private static void eliminarPorPosicion() {
        int pos = leerEntero("Posición a eliminar: ");
        boolean ok = biblioteca.eliminarPorPosicion(pos);
        if (ok) {
            System.out.println("Libro en posición " + pos + " eliminado correctamente.");
        } else {
            System.out.println("Posición inválida.");
        }
    }

    private static void mostrarCantidad() {
        System.out.println("Cantidad de libros registrados: " + biblioteca.tamano());
    }
    
    // Utilidades de lectura

    private static String[] leerDatosLibro() {
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        return new String[]{codigo, titulo, autor};
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa un número válido: ");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }
}