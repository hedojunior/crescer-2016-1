public class IrishDwarf extends Dwarf {
 
    public IrishDwarf(String nome)
    {
         super(nome);
    }
        
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento)
    {
        super(nome,dataNascimento);
    }
    
    public void tentarSorte() 
    {
        int soma = 0, i = 0,quantidade = 0;
        if(this.getNumeroSorte() == 101.0 * -33) {
            while ( i < this.getInventario().getItens().size()){
                 quantidade = this.getInventario().getItens().get(i).getQuantidade();
                 soma = ((1 + quantidade) * quantidade) / 2;
                 this.inventario.getItens().get(i).setQuantidade(quantidade + (1000 * soma));
                 soma = 0;
                 i++;
            }
        }
    }
}