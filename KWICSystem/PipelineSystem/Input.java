package KWICSystem.PipelineSystem;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Input extends Filter {
    private String filename;
    public Input(String filename, Pipe output) {
        super(null, output);
        this.filename = filename;
    }

    @Override
    protected void transform() {
        BufferedReader inputFile = null;
        try {
            inputFile = new BufferedReader(new FileReader(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String line;
        try {
            while ((line = inputFile.readLine()) != null) {
                output.writerLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        output.closeWriter();
    }
}
