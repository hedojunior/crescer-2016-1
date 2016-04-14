import java.util.*;

public class SindarinParaPortugues implements TradutorSindarin {
    
    
    private HashMap<String, String> dicionario = new HashMap<String, String>()
    {
        {
            put("naur", "fogo");
            put("terra", "amar");
            put("fogo", "naur");
            put("vento", "gwaew");
            put("água", "nem");
            put("coração", "gûr");
        }
    };
    
    public String traduzir(String palavraEmSindarin) {
        return dicionario.get(palavraEmSindarin);
    }

}