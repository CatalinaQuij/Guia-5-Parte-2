
package listacantantesfamosos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaCantantesFamosos listaCantantes = new ListaCantantesFamosos();       
        String nombre;
        String discomasVentas;
        String respuesta;
        boolean salir = false;
        int option = 0;
        
        //DOS DATOS INGRESADOS MANUALMENTE        
        nombre = "Pxndx";
        discomasVentas = "2000";
        listaCantantes.add(nombre, discomasVentas);
        
        nombre = "Miranda!";
        discomasVentas="1500";
        listaCantantes.add(nombre, discomasVentas);
        
        //AGREGAR CANTANTES
        while (!salir) {
                System.out.print("Ingrese el nombre del cantante famoso: ");
                nombre = sc.nextLine();

                System.out.print("Ingrese el disco con mas ventas del cantante: ");
                discomasVentas = sc.nextLine();

                listaCantantes.add(nombre, discomasVentas);

                System.out.println("\nDesea ingresar otro cantante famoso? (si/no)");
                respuesta = sc.nextLine();
                
                if (respuesta.equalsIgnoreCase("si")) {
                    System.out.println("\nLista Actualizada!");
                    listaCantantes.mostrarListaCantantesFamosos();
                }
                
                if (respuesta.equalsIgnoreCase("no")) {
                    System.out.println("\nLista Actualizada!");
                    listaCantantes.mostrarListaCantantesFamosos();
                    salir = true;
                }
            }
        
        
        //MENU
        boolean out = false;
        while(!out){  
        System.out.print("""
                           
                           Menu Principal  
                           1. Agregar Cantante
                           2. Modificar nombre del cantante 
                           3. Eliminar Cantante
                           4. Generar lista de cantantes por discos vendidos
                           5. Salir
                           Seleccione una opcion:  """);
        
                           option = sc.nextInt();
                          
                         
        switch (option){
            case 1://AGREGAR CANTANTE
                String nombre1;
                String discomasVentas1;
                String respuesta1;
                
                System.out.print("\nIngrese el nombre del cantante famoso: ");
                nombre1 = sc.next();

                System.out.print("Ingrese el disco con mas ventas del cantante: ");
                discomasVentas1 = sc.next();

                listaCantantes.add(nombre1, discomasVentas1);

                System.out.println("\nLista Actualizada!");
                listaCantantes.mostrarListaCantantesFamosos();                               
                
                break;
                    
            case 2://MODIFICAR NOMBRE CANTANTE
                System.out.print("\nIngresa el nombre del cantante a modificar: ");
                String nombreModificar = sc.next();
                System.out.print("Ingresa el nuevo nombre: ");
                String nombreNuevo = sc.next();
                
                listaCantantes.modifier(nombreModificar, nombreNuevo);
                break;
                
            case 3://ELIMINAR CANTANTE
                System.out.print("\nIngrese el nombre del cantante que desea eliminar:");
                String delete = sc.next();
                listaCantantes.delete(delete);              
                break;
                
            case 4://ORDENAR CANTANTES DE MAYOR A MENOR
                listaCantantes.OrdenarVentas();
                break;
              
            case 5: //SALIR
                out = true;
                break;
            
            default:
                System.out.println("\nOpcion Invalida");
                break;
        }
    }
        System.out.println("\nPrograma finalizado");    
    }
}   

