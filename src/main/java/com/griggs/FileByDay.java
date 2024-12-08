package main.java.com.griggs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.function.Consumer;

public abstract class FileByDay implements FileByDayInterface {
    
    private String sampleInputFilePath = "";
    private String problemInputFilePath = "";

    @Override
    public String getProblemInputFilePath() {
        return this.problemInputFilePath;
    }

    @Override
    public void setProblemInputFilePath(String s) {
        this.problemInputFilePath = s;
    }

    @Override
    public String getSampleInputFilePath() {
        return this.sampleInputFilePath;
    }

    @Override
    public void setSampleInputFilePath(String s) {
        this.sampleInputFilePath = s;
    }

    //This will read in the sample filepath
    @Override
    public File getSampleInput() {
        String sampleFilePath = getSampleInputFilePath();

        //
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL testFiles = classLoader.getResource(sampleFilePath);

        assert testFiles != null;
        return new File(testFiles.getFile());
    }

    //This will read in the problem filepath
    @Override
    public File getProblemInput() {
        String problemFilePath = getProblemInputFilePath();

        //
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL inputFiles = classLoader.getResource(problemFilePath);

        assert inputFiles != null;
        return new File(inputFiles.getFile());
    }

    @Override
    public void problemOne() {
        System.out.println("Problem One not implemented");
    }

    @Override
    public void problemOneSample() {
        System.out.println("Problem One Sample not implemented");
    }

    @Override
    public void problemTwo() {
        System.out.println("Problem Two not implemented");
    }

    @Override
    public void problemTwoSample() {
        System.out.println("Problem Two Sample not implemented");
    }

    //this will read the Sample File in line by line
    @Override
    public void readSampleFile(Consumer<String> reader) {
        try(BufferedReader br = new BufferedReader(new FileReader(getSampleInput()))) {
            String line;
            while((line = br.readLine()) != null) {
                reader.accept(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //this will read in the Problem File in line by line
    @Override
    public void readProblemFile(Consumer<String> reader) {
        try(BufferedReader br = new BufferedReader(new FileReader(getProblemInput()))) {
            String line;
            while((line = br.readLine()) != null) {
                reader.accept(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}