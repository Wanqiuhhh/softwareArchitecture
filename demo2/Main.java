package demo2;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        input.input("D:\\mess\\Homework\\softStructure\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("D:\\mess\\Homework\\softStructure\\outputDemo2.txt");

    }
}

