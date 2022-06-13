package Proyecto;

public class AeropuertoPublico extends Aeropuerto{
    private double subvencion;
    
    public AeropuertoPublico(String name, String ciudad, String pais){
        super(name, ciudad, pais);
    }
    public AeropuertoPublico(String name, String ciudad, String pais, double subvencion) {
        super(name, ciudad, pais);
        this.subvencion = subvencion;
    }
    
    public AeropuertoPublico(String name, String ciudad, String pais, Compania[] listaCompanias, double subvencion) {
        super(name, ciudad, pais, listaCompanias);
        this.subvencion = subvencion;
    }
    
    public double getSubvencion(){
        return this.subvencion;
    }
}
