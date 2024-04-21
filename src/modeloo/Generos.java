package src.modeloo;

public enum Generos {
    /*
    private int id;
    private String descripcion;

    public Generos (int id, String descripcion ){
        this.id=id;
        this.descripcion=descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId() {
        return id;
    }
     */
    
    TERROR(1),
    ACCION(2),
    COMEDIA(3),
    ROMANCE(4),
    BIOGRAFICO(5),
    AVENTURA(6),
    DRAMA(7),
    FANTASIA(8),
    SCIFI(9),
    MUSICAL(10),
    SUSPENSE(11),
    WESTERN(12),
    DOCUMENTAL(13);
    
    private int id;

    private Generos (int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }
    
    public static String getNombre(int id){
        String gen="";
        for(Generos genero:Generos.values()){
            if (genero.getId()==id){
                gen=genero.name();
                break;
            }
        }
        return gen;

    }
    
    

    
}
