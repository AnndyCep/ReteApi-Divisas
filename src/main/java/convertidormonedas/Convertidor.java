
package convertidormonedas;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;


public class Convertidor {
    
    private String codigoBase;
    private String codigoDestino;
    private double cantidadConvetida;
    private double cantidadConvetir;
    private ApiConection apiConection;

    public Convertidor() {
        this.apiConection = new ApiConection();
//       
    }

    private Convertidor(TotuloOmbd tituloOmbd) {
        this.codigoBase = tituloOmbd.base_code();
        this.codigoDestino = tituloOmbd.target_code();
        this.cantidadConvetida = tituloOmbd.conversion_result();
    }

    public void setCantidadConvetir(double cantidadConvetir) {
        this.cantidadConvetir = cantidadConvetir;
    }
    
    public String getCodigoBase() {
        return codigoBase;
    }

    public String getCodigoDestino() {
        return codigoDestino;
    }

    public double getCantidadConvetida() {
        return cantidadConvetida;
    }
    
     public double getCantidadConvetir() {
        return cantidadConvetir;
    }
    
    public Convertidor convertirMoneda(String codigoBase, String codigoDestino, double cantidadConvertir) throws Exception{
       
        String key = "c3e6c40b014d54237261de43";
        String url = "https://v6.exchangerate-api.com/v6/" + key +"/pair/" + codigoBase+"/"+ codigoDestino +"/"+ cantidadConvertir ;
                
        String jsonRespuesta = apiConection.getApiResponse(url);    
        Gson gson = new Gson();
        
        TotuloOmbd tituloOmbd = gson.fromJson(jsonRespuesta, TotuloOmbd.class);
        Convertidor miConver = new Convertidor(tituloOmbd);
        
        if (validarRespuesta( miConver )) {
            miConver.setCantidadConvetir(cantidadConvertir);
            mostrarValor(miConver, cantidadConvertir);
        } else {
            System.out.println(" El codigo base o codigo destino no son parte de la lista...");
        }
        
        return miConver;
    }

    private void mostrarValor(Convertidor convertido, double  cantidad){
        System.out.println( "El valor " + cantidad + "| Codigo de: "+ convertido.codigoBase + " a " + convertido.codigoDestino);
        System.out.println( "Es igual a " + convertido.cantidadConvetida);
        
    }
    

    @Override
    public String toString() {
        return "Convertidor{" + "codigoBase=" + codigoBase + ", codigoDestino=" + codigoDestino + ", cantidadConvetida=" + cantidadConvetida +  '}';
    }

    private boolean validarRespuesta(Convertidor miConver) {
        boolean isVerdadero= false;
        if (miConver.getCodigoBase() != null &&   miConver.getCodigoDestino()!= null) {
            isVerdadero = true ; 
        }
        return isVerdadero;
    }
    
    
}
