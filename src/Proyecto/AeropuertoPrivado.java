package Proyecto;

public class AeropuertoPrivado extends Aeropuerto{
    private String listaEmpresas[] = new String[3];
    private int numEmpresa;

    public AeropuertoPrivado(String name, String ciudad, String pais) {
        super(name, ciudad, pais);
    }
    
    public AeropuertoPrivado(String name, String ciudad, String pais, Compania[] comp, String empresas[] ){
        super(name, ciudad, pais, comp);
        this.listaEmpresas = empresas;
        numEmpresa = empresas.length;
    }
    
    public void insertarEmpresas(String empresas[]){
        this.listaEmpresas = empresas;
        this.numEmpresa = empresas.length;
    }
    
    public void insertarEmpresa(String empresa){
        this.listaEmpresas[numEmpresa] = empresa;
        numEmpresa++;
    }
    
    public String[] getListaEmpresas(){
        return(this.listaEmpresas);
    }
    
    public int getNumEmpresa(){
        return numEmpresa;
    }
    
}
