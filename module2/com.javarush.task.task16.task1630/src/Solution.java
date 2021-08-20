package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static{
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));){
            firstFileName = bufferedReader.readLine();
            secondFileName = bufferedReader.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        default void join() throws InterruptedException{}

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        
        private String fullFileName;
        private String fileData;
        
        public ReadFileThread(){
            fullFileName = "";
            fileData = "";
        }
        
        public void setFileName(String fullFileName){
            this.fullFileName = fullFileName;    
        }

        public String getFileContent(){
            return fileData;
        }


        public void start(){
            start();
        }
        
        @Override
        public void run(){
            try{
                BufferedReader bf = new BufferedReader(new FileReader(fullFileName));
                StringBuilder stringBuilder = new StringBuilder();
                while(bf.ready()){
                    stringBuilder.append(bf.readLine() + " ");
                    if(stringBuilder.toString().contains("\n")){
                        stringBuilder = new StringBuilder(stringBuilder.toString().replace("\n", ""));
                    }
                }
                fileData = stringBuilder.toString();
                bf.close();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}