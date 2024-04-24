
package convertidormonedas;

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

    @Override
    public String toString() {
        return "Aplicacion{" + ", listaConverticiones=" + listaConverticiones + '}';
    }
    
}
