package exercice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercice {


    public static List<String> solution(String str, List<Character> ordre) {

        if (str.equals("")){
            return List.of("");
        }
        
        List<String> mots = stringToWords(str);

        List<String> nonTriables = new ArrayList<String>();

        for (int i =0; i< mots.size()*mots.size()*10000; i++){
            if (i<mots.size() && getPosition(ordre,mots.get(i).charAt(0))==-1){
                nonTriables.add(mots.get(i));
                mots.remove(i);
                i--;
            }
        }

        mots = triAleatoire(mots, ordre);

        for (int i=0; i<nonTriables.size();i++){
            mots.add(nonTriables.get(i));
        }

        return mots;
        
    }

    public static List<String> triAleatoire(List<String> liste, List<Character> ordre) {

        Collections.shuffle(liste);

        while (! estTrie(liste, ordre)){
            Collections.shuffle(liste);
        }


        return liste;
        
        
    }

    public static boolean estTrie (List<String> liste, List<Character> ordre){
        

        for (int i=0; i<liste.size()-1; i++){
            if (compare(liste.get(i), liste.get(i+1), ordre)>0){
                return false;
            }
        }

        return true;
    }


    public static int compare (String chaine1, String chaine2, List<Character> ordre){
        int position1;
        int position2; 

        if (chaine1.equals(chaine2)){
            return 0;
        }
        if (chaine1.equals("")){
            return -1;
        }
        if (chaine2.equals("")){
            return 1;
        }
        if (chaine1.charAt(0)==(chaine2.charAt(0))){
            return compare(chaine1.substring(1),chaine2.substring(1), ordre);
        }

        position1 = getPosition(ordre, chaine1.charAt(0));
        position2 = getPosition(ordre, chaine2.charAt(0));
        
        if (position1 == -1 && position2 != -1){
            return 1;
        }
        if (position2 == -1){
            return -1;
        }
        if ( position1 > position2 ){
            return 1;
        }
        else {
            return -1;
        }
    }


    public static int getPosition(List<Character> ordre, char lettre) {
        return ordre.indexOf(lettre);
    }

    public static ArrayList<String> stringToWords(String chaine) {

        ArrayList<String> sousChaines = new ArrayList<String>();
        StringBuilder motCourant = new StringBuilder();
        int taille = chaine.length();
    
        for (int i = 0; i < taille; i++) {
            char character = chaine.charAt(i);
    
            if (Character.isLetterOrDigit(character)) {
                motCourant.append(character);
            } else {
                if (motCourant.length() > 0) {
                    sousChaines.add(motCourant.toString());
                    motCourant.setLength(0);
                }
            }
        }
    
        if (motCourant.length() > 0) {
            sousChaines.add(motCourant.toString());
        }
    
        return sousChaines;
    }
    
    

}
