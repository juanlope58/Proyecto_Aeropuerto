package Proyecto;

public class Aeropuerto {
    private String name;
    private String ciudad;
    private String pais;
    private Compania listaCompanias[]= new Compania[10];
    private int numCompania;
    
    public Aeropuerto(String name, String ciudad, String pais){
        this.name = name;
        this.ciudad = ciudad;
        this.pais = pais;
        this.numCompania = 0;
    }
    
    public Aeropuerto(String name, String ciudad, String pais, Compania listaCompanias[]){
        this.name = name;
        this.ciudad = ciudad;
        this.pais = pais;
        this.listaCompanias = listaCompanias;
        this.numCompania = listaCompanias.length;
    }
    
    public void insertarCompania(Compania company){
        this.listaCompanias[numCompania] = company;
        numCompania++;
    }

    public String getName() {
        return name;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public Compania[] getListaCompanias() {
        return listaCompanias;
    }

    public int getNumCompania() {
        return numCompania;
    }
    
    public Compania getCompania(int i){
        return listaCompanias[i];
    }
    
    public Compania getCompania(String name){
        boolean encontrada = false;
        int i=0;
        Compania comp = null;
        while ((!encontrada)&&(i<numCompania)){
            if(listaCompanias[i].getName() == name){
                encontrada = true;
                comp = listaCompanias[i];
            }
            i++;
        }
        return comp;
    }
}
