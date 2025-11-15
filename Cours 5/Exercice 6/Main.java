import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Votre code doit être APRES de ce commentaire
        // demander d'encoder les prix à l'user
        
        int total = 0;
        int price;
        int received = 0;
        int change = 0;
        
        // enregistrer les prix
        // tant que chiffre != 0, on continue à demander
        do{
            System.out.println("Veuillez encoder le prix de l'article : ");
            price = readNextInt();
            total += price;
        }while(price != 0);
        
        // afficher montant total
        System.out.println("Le montant total vaut : " + total + "€.");
        // demander la somme donnée par le client
        System.out.print("Montant reçu : ");
        received = readNextInt();
        
        // rendre la monnaie  
        // calculer la différence
        change = received - total;
        System.out.println("La somme à rendre vaut : " + change + "€.");
        // cb de billets de 10
        System.out.println("Billets de 10€ à rendre : " + (change/10));
        change = change % 10;
        // cb de pièces de 2
        System.out.println("Pièces de 2€ à rendre : " + (change/2));
        change = change % 2;
        // cb de pièces de 1
        System.out.println("Pièces de 1€ à rendre : " + change);
        
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
