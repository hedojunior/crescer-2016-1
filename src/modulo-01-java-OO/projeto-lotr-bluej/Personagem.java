public class Personagem
{
    protected String nome;
    protected int experiencia, vida;
    protected Status status;
    
    protected Inventario inventario = new Inventario();
    
    public Personagem (String nome)
    {
        this.nome = nome;
        this.status = Status.VIVO;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public int getExperiencia()
    {
        return this.experiencia;
    }
    
    public int getVida()
    {
        return this.vida;
    }
   
    public Status getStatus()
    {
        return this.status;
    }
    
    public Inventario getInventario()
    {
        return this.inventario;
    }
    
    public void adicionarItem(Item item) 
    {
        this.getInventario().adicionarItem(item);
    }
    
    public void perderItem(Item item)
    {
        this.getInventario().removerItem(item);
    }
    
}