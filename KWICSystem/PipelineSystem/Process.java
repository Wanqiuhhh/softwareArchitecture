package KWICSystem.PipelineSystem;

public class Process {
    public static String process(String fileName) {
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(fileName, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(pipe3);
        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();
        return output.content;
    }
}
