/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listacantantesfamosos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ListaCantantesFamosos {
    private ArrayList<cantanteFamoso> listacantantesFamosos;

    // Constructor de la clase
    public ListaCantantesFamosos() {
        listacantantesFamosos = new ArrayList<cantanteFamoso>();
    }

    public ArrayList<cantanteFamoso> get() {
    return listacantantesFamosos;
    }
    
    public void add(String nombre, String discomasVentas) {
        cantanteFamoso cantanteFamoso = new cantanteFamoso(nombre, discomasVentas);
        listacantantesFamosos.add(cantanteFamoso);
    }

    public cantanteFamoso delete(String nombre) {
        boolean find=false;
        Iterator<cantanteFamoso> iterator = listacantantesFamosos.iterator();
        while (iterator.hasNext()) {
            cantanteFamoso cantante = iterator.next();
            if (cantante.getNombre().equals(nombre)) {
                iterator.remove();
                System.out.println(nombre + " ha sido eliminado de la lista.");
                find=true;
        }
    }
        if (find!=true) {
            System.out.println(nombre + " no se encontro en la lista.");
        }
        return null;
    }
    
    public void modifier(String nombre, String nuevoNombre) {
    boolean encontrado = false;
        for (cantanteFamoso cantante : listacantantesFamosos) {
            if (cantante.getNombre().equals(nombre)) {
                cantante.setNombre(nuevoNombre);
                System.out.println("Nombre modificado correctamente.");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró el cantante en la lista.");
        }
    }
    
   
        
    public void mostrarListaCantantesFamosos() {
        Iterator<cantanteFamoso> iterador = listacantantesFamosos.iterator();
        while (iterador.hasNext()) {
            cantanteFamoso cantanteFamoso = iterador.next();
            System.out.println("Nombre: " + cantanteFamoso.getNombre() + ". Disco con mas ventas: " + cantanteFamoso.getDiscomasVentas());
        }
    }
    
    public void OrdenarVentas() {
    ArrayList<cantanteFamoso> listaOrdenada = new ArrayList<cantanteFamoso>(listacantantesFamosos);
    Collections.sort(listaOrdenada, (cantante1, cantante2) -> {
        int ventasCantante1 = Integer.parseInt(cantante1.getDiscomasVentas());
        int ventasCantante2 = Integer.parseInt(cantante2.getDiscomasVentas());
        return ventasCantante2 - ventasCantante1;
    });
    System.out.print("\n");
    for (cantanteFamoso cantante : listaOrdenada) {
        System.out.println("Nombre: " + cantante.getNombre() + ", Disco con mas ventas: " + cantante.getDiscomasVentas());
    }
}


    
    public cantanteFamoso buscar(String nombre) {
    Iterator<cantanteFamoso> iterator = listacantantesFamosos.iterator();
    while (iterator.hasNext()) {
        cantanteFamoso cantante = iterator.next();
        if (cantante.getNombre().equals(nombre)) {
            return cantante;
        }
    }
    return null;
}
    
}



