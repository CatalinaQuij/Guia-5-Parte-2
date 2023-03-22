/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cantantesfamosos;

/**
 *
 * @author Catalina Quijano L
 */
public class Disco {
    private int fecha;
    private String titulo;
    private int ventas;

    public Disco(int fecha, String titulo, int ventas) {
        this.fecha = fecha;
        this.titulo = titulo;
        this.ventas = ventas;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
}
