import java.util.*;

public class SindarinParaPortugues implements TradutorSindarin {
    
    
    private HashMap<String, String> dicionario = new HashMap<String, String>()
    {
        {
            put("naur", "fogo");
            put("amar", "terra");
            put("gwaew", "vento");
            put("nem", "água");
            put("gûr", "coração");
        }
    };
    
    public String traduzir(String palavraEmSindarin) {
        if(!(dicionario.containsKey(palavraEmSindarin))){
            return "nada, pois não está no nosso dicionário.";
        } else{
            return dicionario.get(palavraEmSindarin);
          }
    }
}