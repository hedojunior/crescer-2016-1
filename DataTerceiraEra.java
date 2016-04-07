public class DataTerceiraEra {
    private int dia, mes, ano;
    
    public DataTerceiraEra(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
        
    public int getDia() {
        return dia;
    }
    
    public int getMes() {
        return mes;
    }
    
    public int getAno() {
        return ano;
    }
    
    public Boolean ehBissexto() {
        return (ano % 4 == 0 && ano % 100 != 0) 
            || (ano % 4 == 0 && ano % 100 == 0 && ano % 400 == 0); 
    }

}