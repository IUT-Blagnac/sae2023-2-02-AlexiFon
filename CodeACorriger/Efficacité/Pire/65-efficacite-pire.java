package concours_algo;
import java.util.*;
public class efficacite-pire {
	
		public static List<String> extractWords(String phrase) {
        List<String> mots = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (char c : phrase.toCharArray()) {
        if (Character.isLetter(c)) {
        word.append(c);
        } else if (word.length() > 0) {
        mots.add(word.toString());
        word.setLength(0);
        }
        }
        if (word.length() > 0) {
        mots.add(word.toString());
        }
        return mots;
    }

	
		
		
		
		
		
		
		
		
		
		
		
		
	
		public static boolean comparateur(String text1, String text2,List<Character> lettres) {
		int i;
		int un =999;
		int deux =999;
		for(i=0;i<lettres.size();i++) {
		if (text1.charAt(0)==(lettres.get(i))) {
		un=i;
		}
		if (text2.charAt(0)==(lettres.get(i))) {
		deux=i;
		}
		}
		if (un>=deux) {
		return true;
		}else {
		return false;
		}
		
	}
		public static void echange (List<String> mots,int i, int j) {
		String ech="";
		String echD="";
		ech=mots.remove(i);
		echD=mots.remove(j-1);
		mots.add(i, echD);
		mots.add(j, ech);
		
		
		
	}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public static void Trinul( List<String> mots,List<Character> pfordre) {
		int lenght =mots.size();
		for (int i=0; i<lenght-1;i++) {
		for (int j=i+1; j<lenght;j++) {
		if(comparateur(mots.get(i),mots.get(j), pfordre)) {
		echange(mots,i, j );
		}		
		}
		}
		}
		public static void main (String texte, List<Character> list) {
		 List<String> mots = new ArrayList<>();
		 mots=extractWords(texte);
		 Trinul(mots, list);
		 System.out.println(mots.toString());
		 }
	
	
}
