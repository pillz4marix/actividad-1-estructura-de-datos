public class LinkedList {

    private Node head;

    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    //Insertar al inicio
    
    public void insertarAlInicio(String codigo, String titulo, String autor) {
        Node nuevo = new Node(codigo, titulo, autor);
        nuevo.setNext(head);
        head = nuevo;
        size++;
    }

    //Insertar al final
    
    public void insertarAlFinal(String codigo, String titulo, String autor) {
        Node nuevo = new Node(codigo, titulo, autor);

        if (head == null) {
            head = nuevo;
            size++;
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(nuevo);
        size++;
    }
    
    //Insertar en una posición
    
    public boolean insertarEnPosicion(int posicion, String codigo, String titulo, String autor) {
        if (posicion < 0 || posicion > size) {
            return false;
        }

        if (posicion == 0) {
            insertarAlInicio(codigo, titulo, autor);
            return true;
        }

        if (posicion == size) {
            insertarAlFinal(codigo, titulo, autor);
            return true;
        }

        Node anterior = head;
        for (int i = 0; i < posicion - 1; i++) {
            anterior = anterior.getNext();
        }

        Node nuevo = new Node(codigo, titulo, autor);
        nuevo.setNext(anterior.getNext());
        anterior.setNext(nuevo);
        size++;
        return true;
    }

    //Mostrar todos los libros

    public void mostrarLibros() {
        if (head == null) {
            System.out.println("La biblioteca no tiene libros registrados.");
            return;
        }

        Node current = head;
        int index = 0;
        while (current != null) {
            System.out.println(index + " -> " + current.obtenerInfo());
            current = current.getNext();
            index++;
        }
    }

    //Buscar un libro por codigo
    
    public Node buscarPorCodigo(String codigo) {
        Node current = head;
        while (current != null) {
            if (current.getCodigo().equalsIgnoreCase(codigo)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    //Obtener un libro por posicion
    
    public Node obtenerPorPosicion(int posicion) {
        if (posicion < 0 || posicion >= size) {
            return null;
        }

        Node current = head;
        for (int i = 0; i < posicion; i++) {
            current = current.getNext();
        }
        return current;
    }

    //Eliminar un libro por codigo
    
    public boolean eliminarPorCodigo(String codigo) {
        if (head == null) {
            return false;
        }
        if (head.getCodigo().equalsIgnoreCase(codigo)) {
            head = head.getNext();
            size--;
            return true;
        }

        Node anterior = head;
        Node actual = head.getNext();

        while (actual != null) {
            if (actual.getCodigo().equalsIgnoreCase(codigo)) {
                anterior.setNext(actual.getNext());
                size--;
                return true;
            }
            anterior = actual;
            actual = actual.getNext();
        }

        return false;
    }

    //Eliminar por posicion

    public boolean eliminarPorPosicion(int posicion) {
        if (posicion < 0 || posicion >= size) {
            return false;
        }

        if (posicion == 0) {
            head = head.getNext();
            size--;
            return true;
        }

        Node anterior = head;
        for (int i = 0; i < posicion - 1; i++) {
            anterior = anterior.getNext();
        }

        Node aEliminar = anterior.getNext();
        anterior.setNext(aEliminar.getNext());
        size--;
        return true;
    }

    //Obtener el tamaño de la lista

    public int tamano() {
        return size;
    }

    public boolean estaVacia() {
        return head == null;
    }
}