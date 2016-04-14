public abstract class Personagem
{
    protected String nome;
    protected double vida;
    protected int experiencia;
    protected Status status;
    protected Inventario inventario = new Inventario();
    
    public Personagem (String nome) {
        this.nome = nome;
        this.status = Status.VIVO;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }
    
    public double getVida() {
        return this.vida;
    }
   
    public Status getStatus() {
        return this.status;
    }
    
    public Inventario getInventario() {
        return this.inventario;
    }
    
    public void adicionarItem(Item item) {
        this.getInventario().adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        this.getInventario().removerItem(item);
    }
    
    public abstract void tentarSorte();
}