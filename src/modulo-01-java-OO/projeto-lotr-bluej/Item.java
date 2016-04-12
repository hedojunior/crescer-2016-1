public class Item {
    private int quantidade;
    private String descricao;
    
    public Item(int quantidade, String descricao) {
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
       
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade) {
     this.quantidade = quantidade;
    }
    
    public String getDescricao() {
        return this.descricao;
    }    
    
    public boolean equals(Object obj) {
        Item outro = (Item)obj;
        return this.getQuantidade() == outro.getQuantidade() &&
            this.getDescricao() != null && outro !=null && 
            this.descricao.equals(outro.getDescricao());
    }
}
