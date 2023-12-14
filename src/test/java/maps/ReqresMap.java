package maps;

import java.util.HashMap;
import java.util.Map;

public class ReqresMap {

    private Map<String, Object> json;

    public Map<String, Object> getJson() {
        return json;
    }

    public void inicializaJson(){
        json = new HashMap<>();
        json.put("nome","morpheus");
        json.put("job","leader");
    }
}
