package KWICSystem.EventSystem;

import java.util.ArrayList;
import java.util.Iterator;

public class Output implements Observer{
    private ArrayList<String> kwicList;
    private String filename;
    String content = new String();
    public Output(ArrayList<String> kwicList,String filename) {
        this.kwicList = kwicList;
        this.filename = filename;
    }
    @Override
    public void toDo(){
        Iterator<String> it = kwicList.iterator();
        while (it.hasNext()) {
            content = content+it.next()+"\n";
        }
    }
}
