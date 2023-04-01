
package cantantesdiscos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CantantesDiscos {

    private static HashMap<String, String> cantantes = new HashMap<String, String>();
    private static HashMap<Integer, Disco> discos = new HashMap<Integer, Disco>();
    private static int codigoDiscos = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1. Agregar Cantante");
            System.out.println("2. Agregar Disco a un Cantante");
            System.out.println("3. Modificar Nombre del Cantante");
            System.out.println("4. Eliminar Cantante");
            System.out.println("5. Mostrar Informacion");
            System.out.println("6. Generar lista de Cantantes ordenada de mayor a menor");
            System.out.println("7. Ordenar discos de un cantantes de mayor a menor");
            System.out.println("8. Salir");

            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarCantante(sc);
                    break;
                case 2:
                    agregarDisco(sc);
                    break;
                case 3:
                    modificarCantante(sc);
                    break;
                case 4:
                    eliminarCantante(sc);
                    break;
                case 5:
                    mostrarInformacion();
                    break;
                case 6:
                    listaCantantesOrdenada();
                    break;
                case 7:
                    ordenarDiscosCantante();
                    break;
                case 8:
                    System.out.println("\nSaliendo...");
                    break;
                default:
                    System.out.println("\nOpcion no valida.");
                    break;
            }
            System.out.println();
        } while (opcion != 8);
    }

    private static void agregarCantante(Scanner sc) {
        System.out.print("\nIngrese el nombre del cantante: ");
        String nombre = sc.nextLine();

        Iterator<Map.Entry<String, String>> it = cantantes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            if (entry.getValue().equals(nombre)) {
                System.out.println("El cantante ya existe.");
                return;
            }
        }

        System.out.print("Ingrese la ID del cantante. Debe ser una letra con un numero (ej: A1): ");
        String id = sc.nextLine();

        if (cantantes.containsKey(id)) {
            System.out.println("La ID ya existe.");
            return;
        }

        cantantes.put(id, nombre);

        System.out.println("Cantante agregado correctamente.");
    }

    private static void agregarDisco(Scanner sc) {
        System.out.print("\nIngrese la ID del cantante: ");
        String id = sc.nextLine();

        if (!cantantes.containsKey(id)) {
            System.out.println("El cantante no existe.");
            return;
        }

        System.out.print("Ingrese el nombre del disco: ");
        String nombre = sc.nextLine();
        
        System.out.print("Ingrese la cantidad de ventas del disco: ");
        int ventas;
        ventas = sc.nextInt();

        Iterator<Map.Entry<Integer, Disco>> it = discos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Disco> entry = it.next();
            if (entry.getValue().getNombre().equals(nombre)) {
                System.out.println("El disco ya existe.");
                return;
            }
        }

        Disco disco = new Disco(codigoDiscos, nombre, id, ventas);
        discos.put(codigoDiscos, disco);
        codigoDiscos++;

        System.out.println("Disco agregado correctamente.");
    }

    
    
    private static void modificarCantante(Scanner sc) {
        System.out.print("\nIngrese la ID del cantante que desea modificar: ");
        String id = sc.next();

    if (!cantantes.containsKey(id)) {
        System.out.println("El cantante no existe.");
        return;
    }

    System.out.print("Ingrese el nuevo nombre del cantante: ");
    String nombre = sc.next();

    Iterator<Map.Entry<String, String>> it = cantantes.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry<String, String> entry = it.next();
        if (!entry.getKey().equals(id) && entry.getValue().equals(nombre)) {
            System.out.println("El nombre ya esta en uso por otro cantante.");
            return;
        }
    }

    cantantes.put(id, nombre);

    System.out.println("Nombre del cantante modificado correctamente.");
}

private static void eliminarCantante(Scanner sc) {
    System.out.print("\nIngrese la ID del cantante que desea eliminar: ");
    String id = sc.nextLine();

    if (!cantantes.containsKey(id)) {
        System.out.println("El cantante no existe.");
        return;
    }

    // Eliminar discos relacionados
    Iterator<Map.Entry<Integer, Disco>> itDiscos = discos.entrySet().iterator();
    while (itDiscos.hasNext()) {
        Map.Entry<Integer, Disco> entry = itDiscos.next();
        if (entry.getValue().getIdCantante().equals(id)) {
            itDiscos.remove();
        }
    }

    cantantes.remove(id);

    System.out.println("Cantante eliminado correctamente.");
}

private static void mostrarInformacion() {
    System.out.println("\nInformacion de la base de datos:");
    System.out.println("\nCantantes:");
    System.out.println("ID\tNombre");

    Iterator<Map.Entry<String, String>> itCantantes = cantantes.entrySet().iterator();
    while (itCantantes.hasNext()) {
        Map.Entry<String, String> entry = itCantantes.next();
        System.out.println(entry.getKey() + "\t" + entry.getValue());
    }

    System.out.println("\nDiscos:");
    System.out.println("Codigo\tNombre\t\tID Cantante\tVentas");

    Iterator<Map.Entry<Integer, Disco>> itDiscos = discos.entrySet().iterator();
    while (itDiscos.hasNext()) {
        Map.Entry<Integer, Disco> entry = itDiscos.next();
        System.out.println(entry.getValue().getCodigo() + "\t" + entry.getValue().getNombre() + "\t\t"
                + entry.getValue().getIdCantante() + "\t\t" + entry.getValue().getCantidadVentas());
    }
}



    private static void listaCantantesOrdenada() {
    System.out.println("\nLista de Cantantes ordenada de mayor a menor:");
    System.out.println("ID\tNombre\t\tDiscos\tVentas");

    // Crear un nuevo HashMap para almacenar los cantantes ordenados por sus ventas totales.
    HashMap<String, Integer> cantantesOrdenados = new HashMap<>();

    // Iterar a través de la lista de cantantes y, para cada cantante, iterar a través de la lista de discos para sumar las ventas totales.
    Iterator<Map.Entry<String, String>> itCantantes = cantantes.entrySet().iterator();
    while (itCantantes.hasNext()) {
        Map.Entry<String, String> entry = itCantantes.next();
        int totalVentas = 0;
        int totalDiscos = 0;
        Iterator<Map.Entry<Integer, Disco>> itDiscos = discos.entrySet().iterator();
        while (itDiscos.hasNext()) {
            Map.Entry<Integer, Disco> entryDisco = itDiscos.next();
            if (entryDisco.getValue().getIdCantante().equals(entry.getKey())) {
                totalVentas += entryDisco.getValue().getCantidadVentas();
                totalDiscos++;
            }
        }
        // Insertar el cantante en el nuevo HashMap con las ventas totales como clave.
        cantantesOrdenados.put(entry.getKey(), totalVentas);
    }

    // Una vez que se hayan procesado todos los cantantes, iterar a través del nuevo HashMap en orden descendente de las ventas totales e imprimir los detalles del cantante.
    cantantesOrdenados.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .forEachOrdered(entry -> {
            int totalVentas = 0;
            int totalDiscos = 0;
            Iterator<Map.Entry<Integer, Disco>> itDiscos = discos.entrySet().iterator();
            while (itDiscos.hasNext()) {
                Map.Entry<Integer, Disco> entryDisco = itDiscos.next();
                if (entryDisco.getValue().getIdCantante().equals(entry.getKey())) {
                    totalVentas += entryDisco.getValue().getCantidadVentas();
                    totalDiscos++;
                }
            }
            System.out.println(entry.getKey() + "\t" + cantantes.get(entry.getKey()) + "\t\t" + totalDiscos + "\t" + totalVentas);
        });
}

private static void ordenarDiscosCantante() {
    Scanner sc = new Scanner(System.in);
    System.out.print("\nIngrese la ID del cantante: ");
    String idCantante = sc.next();

    if (!cantantes.containsKey(idCantante)) {
        System.out.println("El cantante no existe.");
        return;
    }

    // Creamos un HashMap temporal para almacenar los discos del cantante
    HashMap<Integer, Disco> discosTemp = new HashMap<Integer, Disco>();
    Iterator<Map.Entry<Integer, Disco>> itDiscos = discos.entrySet().iterator();
    while (itDiscos.hasNext()) {
        Map.Entry<Integer, Disco> entry = itDiscos.next();
        Disco disco = entry.getValue();
        if (disco.getIdCantante().equals(idCantante)) {
            discosTemp.put(disco.getCodigo(), disco);
        }
    }

    // Ordenamos los discos del cantante por cantidad de ventas de mayor a menor
    HashMap<Integer, Disco> discosOrdenados = new LinkedHashMap<Integer, Disco>();
    int cantDiscos = discosTemp.size();
    while (cantDiscos > 0) {
        int maxVentas = Integer.MIN_VALUE;
        Disco discoMax = null;
        Iterator<Map.Entry<Integer, Disco>> itDiscosTemp = discosTemp.entrySet().iterator();
        while (itDiscosTemp.hasNext()) {
            Map.Entry<Integer, Disco> entry = itDiscosTemp.next();
            Disco disco = entry.getValue();
            if (disco.getCantidadVentas() >= maxVentas) {
                maxVentas = disco.getCantidadVentas();
                discoMax = disco;
            }
        }
        discosOrdenados.put(discoMax.getCodigo(), discoMax);
        discosTemp.remove(discoMax.getCodigo());
        cantDiscos--;
    }

    // Imprimimos los discos ordenados del cantante
    System.out.println("\nDiscos del cantante " + cantantes.get(idCantante) + " ordenados de mayor a menor:");
    Iterator<Map.Entry<Integer, Disco>> itDiscosOrdenados = discosOrdenados.entrySet().iterator();
    while (itDiscosOrdenados.hasNext()) {
        Map.Entry<Integer, Disco> entry = itDiscosOrdenados.next();
        Disco disco = entry.getValue();
        System.out.println(disco.getNombre() + " - Ventas: " + disco.getCantidadVentas());
    }
}



private static void buscarDiscoPorCantante(Scanner sc) {
System.out.print("\nIngrese la ID del cantante: ");
String idCantante = sc.nextLine();
System.out.println("Discos del cantante " + cantantes.get(idCantante) + ":");
System.out.println("Codigo\tNombre\t\tVentas");

Iterator<Map.Entry<Integer, Disco>> itDiscos = discos.entrySet().iterator();
while (itDiscos.hasNext()) {
    Map.Entry<Integer, Disco> entry = itDiscos.next();
    if (entry.getValue().getIdCantante().equals(idCantante)) {
        System.out.println(entry.getValue().getCodigo() + "\t" + entry.getValue().getNombre() + "\t\t"
                + entry.getValue().getCantidadVentas());
    }
}
}
    
}
