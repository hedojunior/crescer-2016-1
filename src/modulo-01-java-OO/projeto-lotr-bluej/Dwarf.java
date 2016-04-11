public class Dwarf extends Personagem {
    private DataTerceiraEra dataNascimento;
    
    public Dwarf(String nome){
         super(nome);
         this.dataNascimento = new DataTerceiraEra(1,1,1);
         this.vida = 110;
    }
        
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this(nome);
        this.dataNascimento = dataNascimento;
    }
    
    public DataTerceiraEra getDataNascimento() {
        return dataNascimento;
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
