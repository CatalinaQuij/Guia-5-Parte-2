package listacantantesfamosos;

public class cantanteFamoso {
    private String nombre;
    private String discomasVentas;

    cantanteFamoso(String nombre, String discoConMasVentas) {
        this.nombre = nombre;
        this.discomasVentas = discoConMasVentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiscomasVentas() {
        return discomasVentas;
    }

    public void setDiscomasVentas(String discomasVentas) {
        this.discomasVentas = discomasVentas;
    }
}
    
