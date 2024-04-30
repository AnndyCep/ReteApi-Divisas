
package convertidormonedas;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Aplicacion {
    
    private ArrayList<Convertidor> listaConverticiones;
    

    public Aplicacion() {
        this.listaConverticiones = new ArrayList<>();
    }
    
    public void agragarRegistro(Convertidor registro){
        if (registro.getCodigoBase() != null && registro.getCodigoDestino()!= null) {
            listaConverticiones.add(registro);
        }
    }
    
    public void mostrarLista(){
        for (Convertidor listaConverticione : listaConverticiones) {
            System.out.println(" Codigo Base: " + listaConverticione.getCodigoBase() + " |\tCodigo Destino "+listaConverticione.getCodigoDestino() + "\t Cantidad " + listaConverticione.getCantidadConvetir() + " |\tValor final "+ listaConverticione.getCantidadConvetida());
            }        
        }

    public void listaTxt() throws IOException{
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        FileWriter escritura = new FileWriter("archivo.json");
        escritura.write(gson.toJson(listaConverticiones));
        escritura.close();
    }
    
    @Override
    public String toString() {
        return "Aplicacion{" + ", listaConverticiones=" + listaConverticiones + '}';
    }
    
}
