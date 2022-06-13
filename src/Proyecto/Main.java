package Proyecto;

import java.util.Scanner;
import javax.xml.transform.OutputKeys;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    final static int numA = 4;      //Numero de aeropuertos
    static Aeropuerto aeropuertos[] = new Aeropuerto[numA]; 
    
    
    public static void main(String[] args){
        //Insertar datos de los aeropuertos
        insertarDatosAeropuerto(aeropuertos);
        menu();
    }
    
    public static void insertarDatosAeropuerto(Aeropuerto aero[]){
        aero[0] = new AeropuertoPublico("Jose Maria Cordoba", "Medellin", "Colombia", 80000000);
        aero[0].insertarCompania(new Compania("VivaAir"));
        aero[0].insertarCompania(new Compania("Avianca"));
        aero[0].getCompania("VivaAir").insertarVuelo(new Vuelo("AA01","Medellin","San Andres",50,150));
        aero[0].getCompania("VivaAir").insertarVuelo(new Vuelo("AA02","Medellin","Cartagena",45,140));
        aero[0].getCompania("Avianca").insertarVuelo(new Vuelo("BB01","Medellin", "Cancun", 200, 130));
        aero[0].getCompania("VivaAir").getVuelo("AA01").insertarPasajero(new Pasajero("Juan Lopera", "cc1032327", "Colombiana"));
        aero[0].getCompania("VivaAir").getVuelo("AA01").insertarPasajero(new Pasajero("Carolina Adarve", "cc1032328", "Colombiana"));
        aero[0].getCompania("VivaAir").getVuelo("AA02").insertarPasajero(new Pasajero("Juan Lopera", "cc1032327", "Colombiana"));
        aero[0].getCompania("Avianca").getVuelo("BB01").insertarPasajero(new Pasajero("Carolina Adarve", "cc1032328", "Colombiana"));
        
        aero[1] = new AeropuertoPrivado("Olaya Herrera", "Medellin", "Colombia");
        aero[1].insertarCompania(new Compania("LATAM"));
        aero[1].getCompania("LATAM").insertarVuelo(new Vuelo("CC01","Medellin", "Londres", 800, 100));
        aero[1].getCompania("LATAM").getVuelo("CC01").insertarPasajero(new Pasajero("Ximena Lopera","cc1001","Colombiana"));
        aero[1].getCompania("LATAM").getVuelo("CC01").insertarPasajero(new Pasajero("Eugenia Alvarez","cc21604","Colombiana"));
        
        aero[2] = new AeropuertoPrivado("Miami", "Miami", "USA");
        aero[2].insertarCompania(new Compania("American"));
        aero[2].insertarCompania(new Compania("United"));
        aero[2].getCompania("American").insertarVuelo(new Vuelo("AM01","Miami","Paris",1000,100));
        aero[2].getCompania("American").insertarVuelo(new Vuelo("AM02","Miami","Bogota",750,110));
        aero[2].getCompania("United").insertarVuelo(new Vuelo("UN01","Miami", "Cancun", 300, 120));
        aero[2].getCompania("American").getVuelo("AM01").insertarPasajero(new Pasajero("Elon Musk", "cc10327", "Sudafricana"));
        aero[2].getCompania("American").getVuelo("AM01").insertarPasajero(new Pasajero("Carolina Herrera", "cc10328", "Venezolana"));
        aero[2].getCompania("American").getVuelo("AM02").insertarPasajero(new Pasajero("Juan Lopera", "cc1032327", "Colombiana"));
        aero[2].getCompania("United").getVuelo("UN01").insertarPasajero(new Pasajero("Carolina Adarve", "cc1032328", "Colombiana"));
        
        aero[3] = new AeropuertoPublico("El Dorado", "Bogota", "Colombia", 80000000);
        aero[3].insertarCompania(new Compania("VivaAir"));
        aero[3].insertarCompania(new Compania("Avianca"));
        aero[3].getCompania("VivaAir").insertarVuelo(new Vuelo("VI01","Bogota","Pasto",30,150));
        aero[3].getCompania("VivaAir").insertarVuelo(new Vuelo("VI02","Bogota","Santa Marta",40,150));
        aero[3].getCompania("Avianca").insertarVuelo(new Vuelo("AV01","Bogota", "Madrid", 823, 110));
        aero[3].getCompania("VivaAir").getVuelo("VI01").insertarPasajero(new Pasajero("Elizabeth Lopera", "cc2327", "Colombiana"));
        aero[3].getCompania("VivaAir").getVuelo("VI01").insertarPasajero(new Pasajero("Alejandra Adarve", "cc2328", "Colombiana"));
        aero[3].getCompania("VivaAir").getVuelo("VI02").insertarPasajero(new Pasajero("Carlos Lopera", "cc2327", "Colombiana"));
        aero[3].getCompania("Avianca").getVuelo("AV01").insertarPasajero(new Pasajero("Manuela Adarve", "cc328", "Colombiana"));
    }
    
    public static void menu(){
        int opcion;
        String nombreAeropuerto, nombreCompania;
        Aeropuerto aerop;
        Vuelo vuelos[];
        
        do{
            System.out.println("\t..MENU..");
            System.out.println("1. Ver aeropuertos gestionados(Publicos o privados).");
            System.out.println("2. Ver empresas(Privado) o subvención(Público).");
            System.out.println("3. Lista de compañias de un aeropuerto.");
            System.out.println("4. Lista de vuelos por compañia.");
            System.out.println("5. Listar posibles vuelos de origen a destino");
            System.out.println("6. Salir.");
            System.out.println("Opcion: ");
            opcion = entrada.nextInt();
            
            switch(opcion){
                
                case 1://Ver aeropuertos gestionados(Publicos o privados)
                    System.out.println("");
                    mostrarDatosAeropuertos(aeropuertos);
                    break;
                case 2://Ver empresas(Privado) o subvención(Público)
                    System.out.println("");
                    mostrarPatrocinio(aeropuertos);
                    break;
                case 3://Lista de compañias de un aeropuerto
                    entrada.nextLine();
                    System.out.println("Ingrese el nombre del aeropuerto");
                    nombreAeropuerto = entrada.nextLine();
                    aerop = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    if (aerop==null){
                        System.out.println("Elaeropuerto no existe");
                    }else{
                        mostrarCompanias(aerop);
                    }                    
                    break;
                case 4://Lista de vuelos por compañia
                    entrada.nextLine();
                    System.out.println("Ingrese el nombre del aeropuerto: ");
                    nombreAeropuerto = entrada.nextLine();
                    aerop = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    if(aerop==null){
                        System.out.println("El aeropuerto no existe.");
                    }else{
                        mostrarCompanias(aerop);
                        System.out.println("\nElija una.");
                        opcion = entrada.nextInt();
                        mostrarVuelos(opcion-1, aerop);
                        
                    }
                    break;
                case 5://Listar posibles vuelos de origen a destino
                    entrada.nextLine();
                    System.out.println("Ciudad de origen: ");
                    String origen = entrada.nextLine();
                    System.out.println("Ciudad destino: ");
                    String destino = entrada.nextLine();
                    mostrarVuelosOrigenDestino(origen, destino, aeropuertos);
                    break;
                case 6://salir
                    break;
                default:
                    System.out.println("Se equivocó de opción");
            }
            System.out.println(""); 
            
        }while(opcion != 6);
    }
    
    public static void mostrarDatosAeropuertos(Aeropuerto aeropuertos[]){
        for(int i=0;i<aeropuertos.length;i++){
            if(aeropuertos[i] instanceof AeropuertoPrivado){
                System.out.println("Aeropuerto Privado: ");
            }
            else{
                System.out.println("Aeropuerto Público: ");
            }
            System.out.println("Nombre: " + aeropuertos[i].getName());
            System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
            System.out.println("Pais: " + aeropuertos[i].getPais());
            System.out.println("");
            
        }
    }
    
    public static void mostrarPatrocinio(Aeropuerto aeropuertos[]){
        String empresas[];
        for(int i=0;i<aeropuertos.length;i++){
            if(aeropuertos[i] instanceof AeropuertoPrivado){
                System.out.println("Aeropuerto Privado: " + aeropuertos[i].getName());
                empresas = ((AeropuertoPrivado)aeropuertos[i]).getListaEmpresas();
                for(int j=0;j<empresas.length;j++){
                    System.out.println("empresa " + (j+1)+ ": "+ empresas[j]+".");
                }
            }else{
                System.out.println("Aeropuerto público: "+ aeropuertos[i].getName());
                System.out.println("Con subvención de: "+ ((AeropuertoPublico)aeropuertos[i]).getSubvencion());
            }
            System.out.println("");
        }
    }
    
    public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto aeropuertos[]){
        for(int i = 0; i<aeropuertos.length; i++){
            if(nombre.equals(aeropuertos[i].getName())){
                return aeropuertos[i];
            }
        }
        return null;
    }
    
    public static void mostrarCompanias(Aeropuerto aeropuerto){
        System.out.println("Las compañias del aeropuerto "+(char)34+aeropuerto.getName()+(char)34+" son:" );
        for(int i=0; i<aeropuerto.getNumCompania();i++){
            System.out.println((i+1)+". "+aeropuerto.getCompania(i).getName());
        }        
    }
    
    public static void mostrarVuelos(int compania, Aeropuerto aeropuerto){
        for(int i=0; i<aeropuerto.getCompania(compania).getNumVuelo();i++){
            System.out.println("\nVuelo: "+aeropuerto.getCompania(compania).getVuelo(i).getIdentificador());
            System.out.println("Origen: "+aeropuerto.getCompania(compania).getVuelo(i).getCiudadOrigen());
            System.out.println("Destino: "+aeropuerto.getCompania(compania).getVuelo(i).getCiudadDestino());
            System.out.println("Precio: $"+aeropuerto.getCompania(compania).getVuelo(i).getPrecio());
        }
        
    }
    
    public static void mostrarVuelosOrigenDestino(String origen,String destino, Aeropuerto aerop[]){
        Vuelo vuelos[];
        vuelos = buscarVuelosOrigenDestino(origen, destino, aerop);      
        if (vuelos.length==0){
            System.out.println("No se encontraron vuelos");
        }else{
            for(int i=0;i<vuelos.length;i++){
                System.out.println("\nVuelo: "+vuelos[i].getIdentificador());
                System.out.println("Pasajeros: "+vuelos[i].getNumActualPasajeros());
                System.out.println("Puestos disponibles: "+(vuelos[i].getNumMaxPasajeros()-vuelos[i].getNumActualPasajeros()));
                System.out.println("Precio: $"+vuelos[i].getPrecio());
            }
        }
    }
    
    public static Vuelo[] buscarVuelosOrigenDestino(String origen, String destino, Aeropuerto aerop[]){
        Vuelo vuelos[];
        Vuelo vuelo;
        int contador = 0;
        for (int i=0;i<aerop.length;i++){
            for(int j=0;j<aerop[i].getNumCompania();j++){
                for(int k=0;k<aerop[i].getCompania(j).getNumVuelo();k++){
                    vuelo=aerop[i].getCompania(j).getVuelo(k);
                    if(origen.equals(vuelo.getCiudadOrigen()) && destino.equals(vuelo.getCiudadDestino())){
                        contador++;                    
                }
                    
                }
            }
        }
        vuelos = new Vuelo[contador];
        contador=0;
        for(int i=0;i<aerop.length;i++){
            for(int j=0;j<aerop[i].getNumCompania();j++){
                for(int k=0 ;k<aerop[i].getCompania(j).getNumVuelo();k++){
                    vuelo=aerop[i].getCompania(j).getVuelo(k);
                    if(origen.equals(vuelo.getCiudadOrigen())&& destino.equals(vuelo.getCiudadDestino())){
                        vuelos[contador] = vuelo;
                        contador++;
                    }
                }
            }
        }
        return vuelos;
    }
}
