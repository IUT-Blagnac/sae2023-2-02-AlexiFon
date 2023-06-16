package exercice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sobriete_meilleur {
    
    public static List<String> Sobriete(String str, char[] ordre) {
        List<String> mots=new ArrayList<>();
        StringBuilder motCourant=new StringBuilder();//Mutable
        /*String motCourant2=new String();//Immutable*/

        int tailleOrdre = ordre.length;
        int[] indiceOrdre = new int[26];


        for (int i = 0; i < tailleOrdre; i++) {
            indiceOrdre[ordre[i]-'a']= i;
        }
        for(char caractere:str.toCharArray()){
            if(Character.isWhitespace(caractere)){
                if(motCourant.length()>0){
                    insererMotN(mots,motCourant.toString(),indiceOrdre);
                    motCourant.setLength(0);
                }
            }else{
                motCourant.append(caractere);//Rajoute le caractere courant au mot courant
            }
        }if(motCourant.length()>0){
            insererMotN(mots,motCourant.toString(),indiceOrdre);
        }
        return mots;

    }
    public static void insererMotN(List<String> mots,String mot,int[] indiceOrdre) {
        int indice=0;
        while(indice<mots.size() && comparerMotsN(mot,mots.get(indice),indiceOrdre)>0 ){
            indice++;
        }
        mots.add(indice,mot);
    }
    private static int comparerMotsN(String word1, String word2, int[] indiceOrdre) {
        int minLength = Math.min(word1.length(), word2.length());
        for (int i = 0; i < minLength; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            int index1 = indiceOrdre[c1 - 'a'];
            int index2 = indiceOrdre[c2 - 'a'];
            if (index1 != index2) {
                return index1 - index2;
            }
        }
        return word1.length() - word2.length();
    }



}