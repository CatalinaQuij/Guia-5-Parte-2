/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cantantesdiscos;

/**
 *
 * @author Catalina Quijano L
 */
public class Disco {
    private int codigo;
    private String nombre;
    private String idCantante;
    private int cantidadVentas;

    public Disco(int codigo, String nombre, String idCantante, int cantidadVentas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idCantante = idCantante;
        this.cantidadVentas = cantidadVentas;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdCantante() {
        return idCantante;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdCantante(String idCantante) {
        this.idCantante = idCantante;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }
}

