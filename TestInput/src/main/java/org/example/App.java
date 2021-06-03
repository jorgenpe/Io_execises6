package org.example;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class TestInput {


    public static void main(String[] args)throws IOException {
        // replace this with a known encoding if possible
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file),
                        Charset.forName("UTF-8")));
        int c;
        while((c = reader.read()) != -1) {
            char character = (char) c;
            // Do something with your character
        }


}
