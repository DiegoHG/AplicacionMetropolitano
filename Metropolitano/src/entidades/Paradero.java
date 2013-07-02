package entidades;

public class Paradero {
	private String titulo;
    private String ubicacion;
 
    public Paradero(String tit, String ubi){
        titulo = tit;
        ubicacion = ubi;
    }
 
    public String getTitulo(){
        return titulo;
    }
 
    public String getUbicacion(){
        return ubicacion;
    }
}
