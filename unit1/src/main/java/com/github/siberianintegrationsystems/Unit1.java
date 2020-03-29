package com.github.siberianintegrationsystems;


public class Unit1 {

    private static final String INPUT_STRING = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
        + "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";


    public static void main(String[] args) {
        StringBuilder result = revertString();
        checkResult(result);
    }
    private static StringBuilder revertString()
    {
        return INPUT_STRING.chars()
                .mapToObj(c -> (char)c)
                .reduce(new StringBuilder(),
                        (s,c) -> new StringBuilder(String.valueOf(c)).append(s),
                        (s1,s2) -> s2.append(s1));

    }

    private static void checkResult(StringBuilder result) {
        if (INPUT_STRING.equals(new StringBuilder(result).reverse().toString())) {
            System.out.println("Строка изменена корректно");
        } else {
            throw new RuntimeException("Ошибка, строка изменена неверно");
        }
    }
}
