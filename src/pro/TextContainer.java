package pro;

import pro.annotations.SaveTo;
import pro.annotations.Saver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextContainer {
    @SaveTo(path = "TestSaver.txt")
    private String text = "";

    public TextContainer() {
    }

    public TextContainer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Saver
    public void save(String path) {
        File file = new File(path);
        try(FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
