import java.util.*;

public class SindarinParaIngles implements TradutorSindarin {
    private HashMap<String, String> dicionario = new HashMap<String, String>()
    {
        {
            put("naur", "fire");
            put("nem", "water");
            put("gwaew", "wind");
            put("amar", "earth");
            put("gûr", "heart");
        }
    };
    
    public String traduzir(String palavraEmSindarin) {
         return dicionario.get(palavraEmSindarin);
    
    }
}