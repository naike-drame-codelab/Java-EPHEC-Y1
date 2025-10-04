import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Votre code doit être APRES de ce commentaire
        // 1. cb de chaque ?
        // 
        System.out.println("Quelle est la quantité du produit 1 ?  :" );
        int qtt1 = readNextInt();
        System.out.println("Quelle est la quantité du produit 2 ?  :" );
        int qtt2 = readNextInt();
        System.out.println("Quelle est la quantité du produit 3 ?  :" );
        int qtt3 = readNextInt();
        
        // 2. sous-totaux
        int sub1 = qtt1 * 10;
        int sub2 = qtt2 * 15;
        int sub3 = qtt3 * 25;
        
        // 3. ajouter la TVA sur les sous-totaux
        // double subWithTVA = sub1 + sub1 * 0.06
        double subWithTVA1 = sub1 * 1.06;
        double subWithTVA2 = sub2 * 1.06;
        double subWithTVA3 = sub3 * 1.21;
        
        // 4. total ?
        double total = 0;
        total += subWithTVA1;
        total += subWithTVA2;
        total += subWithTVA3;

        // 5. promotion
        if(total > 25000) {
            // double promotion = total * 0.04;
            total -= total * 0.04;
            // alternative
            // total *= 0.96;
            System.out.println("Une réduction de 4% est disponible !");
        } 
        
        // 6. affichage
        // Valeurs test : 10 - 25 - 50 ; 200 - 10000 - 500 pour provoquer la réduction.
        System.out.println("Le total est de : " + total + "€.");

        
        
        
        
        
        
        
        
        
        
        
        
        
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
