package com.ua;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainController {

    public void running() {
        try {
            Developer developer = createFactory(getString()).createDeveloper();
            developer.writeCode();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private DeveloperFactory createFactory(String type) {
        if(type.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if(type.equalsIgnoreCase("c++")) {
            return new CppDeveloperFactory();
        }
        throw new RuntimeException("Language of programming is no support");
    }

    private String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
