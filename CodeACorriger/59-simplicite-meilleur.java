package exercice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;





public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {	
        List<String> mots = new ArrayList<>();
        List<String> motsSansOrdre = new ArrayList<>();

        for (String mot : str.split(" ")) {
            if (ordre.contains(mot.charAt(0))) {
                mots.add(mot);
            } else {
                motsSansOrdre.add(mot);
            }
        }

        Collections.sort(mots, new Comparator<String>() {
            @Override
            public int compare(String mot1, String mot2) {
                int minLength = Math.min(mot1.length(), mot2.length());
                for (int i = 0; i < minLength; i++) {
                    char lettre1 = mot1.charAt(i);
                    char lettre2 = mot2.charAt(i);
                    int index1 = ordre.indexOf(lettre1);
                    int index2 = ordre.indexOf(lettre2);
                    if (index1 != index2) {
                        return Integer.compare(index1, index2);
                    }
                }
                return Integer.compare(mot1.length(), mot2.length());
            }
        });

        mots.addAll(motsSansOrdre);

        return mots;
    }
}