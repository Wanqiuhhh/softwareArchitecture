package KWICSystem.PipelineSystem;

import java.io.IOException;

public class Output extends Filter{
    public Output(Pipe input) {
        super(input, null);
    }
    String content = new String();
    @Override
    protected void transform(){
        while (input.hashNextLine()) {
            content = content+input.readerLine()+"\n";
        }
        input.closeReader();
    }
}
