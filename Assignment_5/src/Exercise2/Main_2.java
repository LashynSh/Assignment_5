package Exercise2;

import java.util.HashMap;
import java.util.Map;
class Data {
    private String type;
    private Object content;

    public Data(String type, Object content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public Object getContent() {
        return content;
    }
}

abstract class DataProcessor {
    public abstract void process(Data data);
}

class TextDataProcessor extends DataProcessor {
    @Override
    public void process(Data data) {
        System.out.println("Processing text data: " + data.getContent());
    }
}

class AudioDataProcessor extends DataProcessor {
    @Override
    public void process(Data data) {
        System.out.println("Processing audio data: " + data.getContent());
    }
}

class VideoDataProcessor extends DataProcessor {
    @Override
    public void process(Data data) {
        System.out.println("Processing video data: " + data.getContent());
    }
}

class DataProcessorCreator {
    private Map<String, DataProcessor> processorMap;

    public DataProcessorCreator() {
        processorMap = new HashMap<>();
    }

    public void registerProcessor(String type, DataProcessor processor) {
        processorMap.put(type, processor);
    }

    public void processData(Data data) {
        DataProcessor processor = processorMap.get(data.getType());
        if (processor != null) {
            processor.process(data);
        } else {
            System.out.println("No processor found for data type: " + data.getType());
        }
    }
}

public class Main_2 {
    public static void main(String[] args) {
        DataProcessorCreator creator = new DataProcessorCreator();

        creator.registerProcessor("text", new TextDataProcessor());
        creator.registerProcessor("audio", new AudioDataProcessor());
        creator.registerProcessor("video", new VideoDataProcessor());

        Data textData = new Data("text", "This is a text message.");
        creator.processData(textData);

        Data audioData = new Data("audio", "Audio content");
        creator.processData(audioData);

        Data videoData = new Data("video", "Video content");
        creator.processData(videoData);

    }
}
