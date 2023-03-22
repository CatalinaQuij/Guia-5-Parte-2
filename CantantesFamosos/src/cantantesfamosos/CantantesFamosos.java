/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cantantesfamosos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CantantesFamosos {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Cantante> listaCantantes = new ArrayList<>();
    HashMap<Integer, Disco> discosCantantes = new HashMap<>();
    
    // DOS CANTANTES AGREGADOS MANUALMENTE
    Cantante cantante1 = new Cantante(1, "Pxndx");
    Cantante cantante2 = new Cantante(2, "Miranda!");
    listaCantantes.add(cantante1);
    listaCantantes.add(cantante2);

    Disco disco1 = new Disco(2000, "Pathetica", 1000);
    Disco disco2 = new Disco(2005, "Prisionero", 500);
    discosCantantes.put(1, disco1);
    discosCantantes.put(2, disco2);

    boolean salir = false;
    while (!salir) {
        System.out.print("Ingrese el nombre del cantante famoso: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el codigo numerico del cantante: ");
        int codigo = sc.nextInt();

        Cantante cantante = new Cantante(codigo, nombre);
        listaCantantes.add(cantante);

        System.out.print("Ingrese la fecha de publicacion del disco: ");
        int fecha = sc.nextInt();
        System.out.print("Ingrese el titulo del disco: ");
        String titulo = sc.next();
        System.out.print("Ingrese la cantidad de ventas del disco: ");
        int ventas = sc.nextInt();

        Disco disco = new Disco(fecha, titulo, ventas);
        discosCantantes.put(codigo, disco);

        System.out.println("\nDesea ingresar otro cantante famoso? (si/no)");
        String respuesta = sc.next();

        if (respuesta.equalsIgnoreCase("no")) {
            salir = true;
        }
    }

    boolean out = false;
    while (!out){
        System.out.print("""

                           Menu Principal
                           1. Agregar Cantante
                           2. Modificar nombre del cantante
                           3. Eliminar Cantante
                           4. Generar lista de cantantes por discos vendidos
                           5. Salir
                           Seleccione una opcion:  """);
        int option = sc.nextInt();
                
        switch (option) {
            case 1:
            System.out.print("\nIngrese el nombre del cantante famoso: ");
            String nombre = sc.next();
            System.out.print("Ingrese el codigo numerico del cantante: ");
            int codigo = sc.nextInt();
            Cantante cantante = new Cantante(codigo, nombre);
            listaCantantes.add(cantante);

            System.out.print("Ingrese la fecha de publicaciOn del disco: ");
            int fecha = sc.nextInt();
            System.out.print("Ingrese el titulo del disco: ");
            String titulo = sc.next();
            System.out.print("Ingrese la cantidad de ventas del disco: ");
            int ventas = sc.nextInt();

            Disco disco = new Disco(fecha, titulo, ventas);
            discosCantantes.put(codigo, disco);

            System.out.println("\nCantante y disco agregados exitosamente.");
            break;
        case 2:
            System.out.print("\nIngrese el codigo numerico del cantante que desea modificar: ");
            int codModificar = sc.nextInt();

            if (discosCantantes.containsKey(codModificar)) {
                System.out.print("Ingrese el nuevo nombre del cantante: ");
                String nuevoNombre = sc.next();
                listaCantantes.get(codModificar-1).setNombre(nuevoNombre);

                System.out.println("\nCantante modificado exitosamente.");
            } else {
                System.out.println("\nEl cantante ingresado no existe.");
            }
            break;
        case 3:
            System.out.print("\nIngrese el codigo numerico del cantante que desea eliminar: ");
            int codEliminar = sc.nextInt();

            if (discosCantantes.containsKey(codEliminar)) {
                listaCantantes.remove(codEliminar-1);
                discosCantantes.remove(codEliminar);

                System.out.println("\nCantante eliminado exitosamente.");
            } else {
                System.out. println("\nEl cantante no pudo ser eliminado");
            }
       
        case 4:
            System.out.println("\nLista de cantantes por discos vendidos:");
            List<Map.Entry<Integer, Disco>> discosVendidos = new ArrayList<>(discosCantantes.entrySet());
            Collections.sort(discosVendidos, (d1, d2) -> d2.getValue().getVentas() - d1.getValue().getVentas());
        for (Map.Entry<Integer, Disco> discoss : discosVendidos) {
            int codigoCantante = discoss.getKey();
            String nombreCantante = listaCantantes.get(codigoCantante-1).getNombre();
            String tituloDisco = discoss.getValue().getTitulo();
            int ventasDisco = discoss.getValue().getVentas();

            System.out.println(nombreCantante + " - " + tituloDisco + ": " + ventasDisco + " ventas.");
        }
        break;
    case 5:
        System.out.println("\nSaliendo del programa...");
        out = true;
        break;
    default:
        System.out.println("\nOpción inválida, intente de nuevo.");
        break;
    }
    }
    }
}
