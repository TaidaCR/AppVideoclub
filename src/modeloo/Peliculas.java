package src.modeloo;

public class Peliculas {
    private int id;

    private String titulo;
    private String director;
    private int id_director;
    private int id_genero;
    private int anyo;
    private String urlCaratula;
    private int esAnimacion;
    private Generos genero; 

    public Peliculas(String titulo){
        this.titulo=titulo;
    }

    public Peliculas(String titulo, String director, int anyo, Generos genero){
        this.titulo=titulo;
        this.director=director;
        this.anyo=anyo;
        this.genero=genero;
    }

    public Peliculas(int id, String titulo, int id_director, int anyo, int id_genero, String urlCaratula, int esAnimacion){
        this.id=id;
        this.titulo=titulo;
        this.id_director=id_director;
        this.anyo=anyo;
        this.id_genero=id_genero;
        this.urlCaratula=urlCaratula;
        this.esAnimacion=esAnimacion;
    }

    public Generos getGenero() {
        return genero;
    }

    public int getAnyo() {
        return anyo;
    }

    public String getDirector() {
        return director;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlCaratula() {
        return urlCaratula;
    }

    public int getEsAnimacion() {
        return esAnimacion;
    }

    public int getId_director() {
        return id_director;
    }

    public int getId_genero() {
        return id_genero;
    }
}
