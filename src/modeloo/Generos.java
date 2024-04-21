package src.modeloo;

public enum Generos {
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
    
    public static String getNombreGenero(int id){
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
