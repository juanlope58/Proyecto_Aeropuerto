package Proyecto;

public class Pasajero {
    private String name;
    private String pasaporte;
    private String nacionalidad;
    
    public Pasajero(String name, String pasaporte, String nacionalidad){
        this.name = name;
        this.pasaporte = pasaporte;
        this.nacionalidad = nacionalidad;
    }
    public String getName(){
        return name;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    
}
