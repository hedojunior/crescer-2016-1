public class Dwarf {
    
    private int vida, experiencia;
    private String nome;
    private Status status;
    private Inventario inventario;
    private DataTerceiraEra dataNascimento;
    
    public Dwarf(String nome){
         this.vida = 110;
         this.nome = nome;
         this.status = Status.VIVO;
         this.inventario = new Inventario();
         this.dataNascimento = new DataTerceiraEra(1,1,1);
    }
        
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
       this(nome);
        this.dataNascimento = dataNascimento;
    }
    
    public int getVida() {
        return vida;
    }
    
    public String getNome () {
        return nome;
    }
    
    public Status getStatus() {
        return status;
    }
    
    public Inventario getInventario() {
        return inventario;
    }
    
    public int getExperiencia() {
        return experiencia;
    }
    
    public DataTerceiraEra getDataNascimento() {
        return dataNascimento;
    }
    
    public void setNome(String novoNome) {
        nome = novoNome;
    }
    
    public void danoRecebido() {       
        double resultado = this.getNumeroSorte();
        if(resultado < 0) {
            this.experiencia += 2;
        }   else if(this.status != Status.MORTO && resultado > 100) { 
                this.vida -= 10;
                if (vida <= 0){
                    this.estaMorto();
                }
            }
    }
           
    private void estaMorto(){
        this.status = Status.MORTO;
        this.vida = 0;
    }
    
    public void adicionarItem(Item item) {
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        this.inventario.removerItem(item);
    }
    
    public Double getNumeroSorte(){
        boolean ehMeireles = this.nome == "Meireles";
        boolean ehSeixas = this.nome == "Seixas";
        if( this.getDataNascimento().ehBissexto() && this.vida >=80 && this.vida <=90){
            return 101.0 * -33;
        }else if( this.getDataNascimento().ehBissexto() == false && ehMeireles || this.getDataNascimento().ehBissexto() == false && ehSeixas){
            return (101.0 * 33) % 100;
        }else{
            return 101.0;
        }
    }
    
    public void tentarSorte() {
        if(this.getNumeroSorte() == -3333.0)
            inventario.temSorte();
    }
}


    

// Diferenças

// Declarar um objeto:
// Dwarf gimli = null;

// Criação (instanciação):
// new Dwarf();
// Dwarf d1 = new Dwarf();