package KWICSystem.ObjectOrientedSystem;

import java.util.ArrayList;

public class process {
    public static String process(String fileName) {
        Input input = new Input();
        input.input(fileName);
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        String result = output.output();
        // 处理文件的逻辑
        return result;
    }
}
