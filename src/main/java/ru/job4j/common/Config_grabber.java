package ru.job4j.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Config_grabber {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config_grabber() {
        this.path = "C:\\projects\\job4j_grabber\\rabbit.properties";
    }

    public Config_grabber(String path) {
        this.path = path;
    }

    private void parse(String str) {
        if (str.length() >= 1 && str.charAt(0) != '#') {
            int index = str.indexOf("=");
            if (index != str.lastIndexOf("=") || index == 0 || (index + 1) == str.length()) {
                throw new IllegalArgumentException();
            }
            values.put(str.substring(0, index), str.substring(index + 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(System.getProperties());
        Config_grabber configGrabber = new Config_grabber();
        configGrabber.load();
    }

    public void load() {

        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read
                    .lines()
                    .forEach(this::parse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }
/*
    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }
*/
}


