package src.modeloo;

public enum DirectoresEnum {
    ANTOINE(1),
    SOFIA(2),
    QUENTIN(3),
    JANE(4),
    AGNES(5),
    ALICE(6);


    public int getId(){
        return id;
    }
    
    private int id;

    private DirectoresEnum (int id){
        this.id=id;
    }
}
