import java.util.ArrayList;
public interface Estrategia {
    public ArrayList<Elfo> getOrdemDoUltimoAtaque();
    
    public abstract void estrategiaDeAtaque(ArrayList<Elfo> horda, ArrayList<Dwarf> alvos);
}
