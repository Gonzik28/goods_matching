package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.ListUpdate.getList;


public class Main {

    public static void main(String[] args) {
        String path = "D:\\0\\goods_matching\\input.txt"; //TODO указать путь к исходному файлу
        Scanner sc = null;

        try {
            sc = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> lines = new ArrayList<>();

        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        List<String> firstLines = new ArrayList<>();
        List<String> secondLines = new ArrayList<>();

        int sizeFirstLines = Integer.parseInt(lines.get(0));

        int i = 1;
        while (i <= sizeFirstLines) {
            firstLines.add(lines.get(i));
            i++;
        }

        int sizeSecondLines = Integer.parseInt(lines.get(firstLines.size() + 1));

        int a = firstLines.size() + 2;
        int exit = sizeSecondLines + a - 1;
        while (a <= exit) {
            secondLines.add(lines.get(a));
            a++;
        }

        if (firstLines.size() < secondLines.size()) {
            getList(secondLines, firstLines);
        } else {
            getList(firstLines, secondLines);
        }
    }

}