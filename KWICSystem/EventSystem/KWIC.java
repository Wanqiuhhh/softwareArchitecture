package KWICSystem.EventSystem;

public class KWIC extends Subject{
    public void startKWIC(){
        for (int i = 0;i<4;i++){
            super.notifyOneObserver(i);
        }
    }
}
