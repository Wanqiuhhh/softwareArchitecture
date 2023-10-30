package demo3;

public class Main {
    public static void main(String[] args) {
        //创建主题
        KWIC kwicSubject = new KWIC();
        //创建观察者
        Input input = new Input("D:\\mess\\Homework\\softStructure\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        Output output = new Output(alphabetizer.getKwicList(), "D:\\mess\\Homework\\softStructure\\outputDemo3.txt");

        // 将观察者加入主题
        kwicSubject.addObserver(input);
        kwicSubject.addObserver(shift);
        kwicSubject.addObserver(alphabetizer);
        kwicSubject.addObserver(output);
        // 逐步调用各个观察者
        kwicSubject.startKWIC();
    }
}
