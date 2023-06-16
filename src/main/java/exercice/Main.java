package exercice;

import java.util.*;

public class Main {

      
    
    public static void main(String[] args) {
        float[] test = Chrono.calculTempsExecution(100);
        long mem= Memoire.calculerMemoire();

         for(int i = 0; i < test.length; i++)
         {
             System.out.println(test[i]);
         }
        
        System.out.println("Mémoire : "+mem);
        String texte = "Il fait beau aujourd’hui comme en aout";
        List<Character> ordre = List.of('f', 'I', 'z', 'u', 'k', 'a', 'b', 'o');

        List<String> sortedWords = Exercice.solution(texte, ordre);
        System.out.println(sortedWords);
    } 
}
