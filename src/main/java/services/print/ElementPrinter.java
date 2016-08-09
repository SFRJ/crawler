package services.print;

import java.util.List;

public class ElementPrinter {
    public void printElements(List<String> list) {
        for (String element : list) {
            System.out.println(element);
        }
    }

}
