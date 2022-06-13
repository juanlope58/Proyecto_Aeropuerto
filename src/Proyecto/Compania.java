package Proyecto;


public class Compania {
    private String name;
    private Vuelo listaVuelos[] = new Vuelo[10] ;
    private int numVuelo = 0;
    
    public Compania(String name){
        this.name = name;
    }
    
    public Compania(String name, Vuelo listaVuelos[]){
        this.name = name;
        this.listaVuelos = listaVuelos;
        numVuelo = listaVuelos.length;
    }
    
    public void insertarVuelo(Vuelo vuelo){
        listaVuelos[numVuelo] = vuelo;
        numVuelo++;
    }
    
    public String getName(){
        return name;
    }
    
    public int getNumVuelo(){
        return numVuelo;
    }
    
    public Vuelo getVuelo(int i){
        return listaVuelos[i];
    }
    
    public Vuelo getVuelo(String identificador){
        boolean encontrado = false;
        int i = 0;
        Vuelo vuel = null;
        while((!encontrado)&&(i < numVuelo)){
            if(identificador.equals(listaVuelos[i].getIdentificador())){
                vuel=listaVuelos[i];
                encontrado = true;
            }
            i++;
        }
        return vuel;
    }
}
