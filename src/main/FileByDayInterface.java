package main;

import java.io.File;
import java.util.function.Consumer;

public interface FileByDayInterface {
    String getProblemInputFilePath();
    void setProblemInputFilePath(String problemInputFilePath);

    String getSampleInputFilePath();
    void setSampleInputFilePath(String sampleInputFilePath);

    File getSampleInput();
    void readSampleFile(Consumer<String> reader);
    void problemOneSample();
    void problemTwoSample();

    File getProblemInput();
    void readProblemFile(Consumer<String> reader);
    void problemOne();
    void problemTwo();

    //void asserTests();
}
