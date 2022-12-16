import java.util.HashMap;
import java.util.Map;

public class Main {
    String model;
    String os;
    String color;
    int ssd;
    

    public Main(String model, String os, String color, int ssd) {
        this.model = model;
        this.os = os;
        this.color = color;
        this.ssd = ssd;
    }

    @Override
    public String toString() {
        return "По вашему запросу найдено: "+ model + " " + os + " " + color + " " + ssd + " Гб";
    }

    public  Map<Object,Object> parametrsMap() {
        Map<Object,Object> parametrsNotebook = new HashMap<>();
        parametrsNotebook.put("model", model);
        parametrsNotebook.put("os", os);
        parametrsNotebook.put("color", color);
        parametrsNotebook.put("ssd", ssd);
        return parametrsNotebook;
    }

}
