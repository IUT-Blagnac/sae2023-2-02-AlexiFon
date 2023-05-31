package exercice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String texte = "Il fait beau aujourd’hui comme en aout";
        List<Character> ordre = List.of('f', 'I', 'z', 'u', 'k', 'a', 'b', 'o');

        List<String> sortedWords = Exercice.solution(texte, ordre);
        System.out.println(sortedWords);
    } 
}
