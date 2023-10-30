package KWICSystem.ObjectOrientedSystem;

import java.util.ArrayList;
import java.util.Iterator;

public class Output {
    private ArrayList<String> kwicList;
    public Output(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }
    public String output(){
        Iterator<String> it = kwicList.iterator();
        String content = new String();
        while (it.hasNext()) {
            content = content+it.next()+"\n";
        }
        return content;
    }
}
