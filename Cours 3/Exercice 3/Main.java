import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Votre code doit être APRES de ce commentaire
        // demander un caractère minuscule comme input
        System.out.println("Veuillez entrer une lettre minuscule : ");
        char c = readNextChar();

        boolean lowercase = c >= 'a' && c <= 'z';
        boolean uppercase = c >= 'A' && c <= 'Z';
        boolean vowel = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';

        // vérifier que ce n'est pas un symbole
        // vérifier que c'est bien une minuscule
        if(lowercase){
            // si la lettre est une voyelle
            if(vowel){
                // afficher que la lettre entrée est une voyelle
                System.out.println("La lettre " + c + " est une voyelle.");
                // sinon
            } else {
                // afficher que c'est une consonne
                System.out.println("La lettre " + c + " est une consonne.");
            }             
        } else if (uppercase){
            // afficher que ce n'est pas une minuscule
            System.out.println("La lettre doit être une minuscule !");
        } else {
            System.out.println("L'entrée ne doit pas être un symbole !!!");
        }              
        // Votre code doit être AVANT de ce commentaire
    }

    /*
     * Aides mises à votre dispositons:
     * readNextInt()    : lis le nombre entier entré par l'utilisateur et retourne sa valeur
     * readNextDouble() : lis le nombre à virgule entré par l'utilisateur et retourne sa valeur
     * readNextChar()   : lis le prochain caractere entré par l'utilisateur et le retourne
     * readNextString() : lis la ligne de texte entrée parl l'utilisateur
     */

    // ************************************************************
    // ******************** ATTENTION !!! *************************
    // ************************************************************
    // Si BlueJ sous signale une erreur après ce commentaire, cela
    // signifie que vous avez fait une erreur d'accolades; ce ne
    // signifie PAS qu'il y a une erreur dans le code ci dessous
    // (cfr slides cours 2)

    /***
     * Cette fonction lis et retourne le prochain int entré par l'utilisateur
     */
    private static int readNextInt() {
        boolean valid;
        int res = 0;

        do {
            valid = true;
            try {
                res = s.nextInt();
            } catch (NoSuchElementException e) {
                System.out.println("Entrée non reconnue, essayez encore !");
                s.next();
                valid = false;
            } catch (IllegalStateException e){
                s = new Scanner(System.in);
                System.out.println("Problème technique interne. Si il persiste, contactez le prof");
                valid = false;
            }
        } while (!valid);
        return res;
    }

    /***
     * Cette fonction lis et retourne le prochain double entré par l'utilisateur
     */
    private static double readNextDouble() {
        double res = Double.NaN;

        do {
            try {
                res = s.nextDouble();
            } catch (NoSuchElementException e) {
                DecimalFormat df = (DecimalFormat)DecimalFormat.getInstance();
                char separator = df.getDecimalFormatSymbols().getDecimalSeparator();
                System.out.println("Entrée non reconnue, essayez encore ! (les nombres a virgule doivent utiliser le charactere \""+separator+"\" comme separateur");
                s.next();
            } catch (IllegalStateException e){
                s = new Scanner(System.in);
                System.out.println("Problème technique interne. Si il persiste, contactez le prof");
            }
        } while (Double.isNaN(res));
        return res;
    }

    /***
     * Cette fonction lis et retourne le prochain char entré par l'utilisateur
     */
    private static char readNextChar() {
        char res = s.next(".").charAt(0);
        return res;
    }

    /***
     * Cette fonction lis et retourne la ligne entrée par l'utilisateur
     */
    private static String readNextString() {
        try {
            return s.nextLine();
        } catch (NoSuchElementException e){
            return s.next();
        }
    }

    // Ne pas enlever ceci, c'est utilisé !
    private static Scanner s = new Scanner(System.in).useLocale(Locale.FRENCH);
}
