
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import DZ6.Main;

public class Notebook {
    public static void main(String[] args) {
        ArrayList<Main> notebook = new ArrayList<>();
        notebook.add(new Main("lenovo","windows", "black",  16));
        notebook.add(new Main("hp", "windows", "grey", 8));
        notebook.add(new Main("mac", "macOS", "grey", 8));
        notebook.add(new Main("asus", "windows","black", 4));
        notebook.add(new Main("asus", "windows","white",  32));
        notebook.add(new Main("lenovo","windows","grey", 16));

        seach(notebook, parametrs());
    }

    public static void seach(ArrayList<Main> listObj, Map<String, String> parametrsForSeach) {
        ArrayList<Main> result = new ArrayList<>();
        if (parametrsForSeach.isEmpty()) {
            System.out.println("Введите хотя бы один параметр поиска!\n");
            seach(listObj, parametrs());
        } 
        else {
            var fields = parametrsForSeach.keySet();
            for (Object field : fields) {
                for (Main obj : listObj) {
                    if (obj.parametrsMap().get(field.toString()).toString()
                            .equals(parametrsForSeach.get(field.toString()))) {
                        if (!result.contains(obj)) {
                            result.add(obj);
                        }
                    }
                }
            }
            for (Object field : fields) {
                ArrayList<Main> temp = new ArrayList<>(result);
                for (Main obj : temp) {
                    if (!obj.parametrsMap().get(field.toString()).toString()
                            .equals(parametrsForSeach.get(field.toString()))) {
                        result.remove(obj);
                    }
                }
            }
            if (result.isEmpty()) {
                System.out.println("По вашему запросу ничего не найдено");
            } else {
                for (Main obj : result) {
                    System.out.println(obj);
                }
            }
        }
    }

    public static Map<String, String> parametrs() {
        Map<String, String> parametrs = new HashMap<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Выберите модель mac/asus/hp/lenovo:");
        String temp = scan.nextLine();
        if (!temp.equals(""))
            parametrs.put("model", temp);

        System.out.println("Выберите операционную систему masOC/windows:");
        temp = scan.nextLine();
        if (!temp.equals(""))
            parametrs.put("os", temp);

        System.out.println("Выберите цвет black/grey/white:");
        temp = scan.nextLine();
        if (!temp.equals(""))
            parametrs.put("color", temp);

        System.out.println("Выберите ssd 4/8/16/32:");
        temp = scan.nextLine();
        if (!temp.equals(""))
            parametrs.put("ssd", temp);

        scan.close();
        return parametrs;
    }
}
