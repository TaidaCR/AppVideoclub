package src.modeloo;

public class Directores {

    private int id;
    private String nombre;
    private String urlFoto;
    private String urlWeb;

    public Directores(int id, String nombre){
        this.id=id;
        this.nombre=nombre;
    }

    public Directores(int id, String nombre, String urlFoto, String urlWeb){
        this.id = id;
        this.nombre = nombre;
        this.urlFoto=urlFoto;
        this.urlWeb=urlWeb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlWeb() {
        return urlWeb;
    }

    public void setUrlWeb(String urlWeb) {
        this.urlWeb = urlWeb;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

}
