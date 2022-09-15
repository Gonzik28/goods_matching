package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUpdate {

    public static void getList(List<String> firstLines, List<String> secondLines) {
        List<String> list = new ArrayList<>();
        List<String> listTemp = new ArrayList<>();

        for (String template : firstLines) {
            List<String> firstLinePiece = getWords(template);
            for (String pattern : firstLinePiece) {
                for (String source : secondLines) {
                    if (source.length() < pattern.length()) {
                        String box = source;
                        source = pattern;
                        pattern = box;
                    }
                    if (!SubstringFinder.pos(pattern, source)) {
                        listTemp.add(template + " : ?\n");
                    } else {
                        listTemp.add(template + " : " + source + "\n");
                    }

                    for (String result : listTemp) {
                        if (!list.contains(result)) {
                            list.add(result);
                        }
                    }
                }

            }
        }
        writerList(list);
    }


    private static List<String> getWords(String template) {
        List<String> firstLinePiece = new ArrayList<>();
        if (template.contains(" ")) {
            for (String retval : template.split(" ")) {
                firstLinePiece.add(retval);
            }
        } else {
            firstLinePiece.add(template);
        }
        return firstLinePiece;
    }

    private static void writerList(List<String> lists) {
        try (FileWriter writer = new FileWriter("ouput.txt", false)) {

            ArrayList<String> list = new ArrayList<>(lists);
            Collections.sort(list);

            for (int i = 0; i < list.size() - 1; i++) {
                if ((list.get(i).contains("?") && (list.get(i + 1).substring(0, list.get(i + 1).indexOf(":"))
                        .equals(list.get(i).substring(0, list.get(i).indexOf(":")))))) {
                    list.remove(i);
                }
            }

            for (int i = 0; i < lists.size(); i++) {
                if (list.contains(lists.get(i))) {
                    writer.write(lists.get(i));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
