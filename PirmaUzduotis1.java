package Laboratoriniai;
import java.util.Scanner;

public class PirmaUzduotis1 {
    public static void main(String[] args) {

        int suma1,suma2 = 0;
        Scanner skeneris = new Scanner(System.in);
        System.out.println("Įveskite šešiaženklį skaičių");
            String nr = skeneris.nextLine();
            int[] nrMas = new int[nr.length()];
            for(int i=0; i<nr.length(); i++){
                nrMas[i] = Character.getNumericValue(nr.charAt(i));
            }
            if(nrMas.length == 6){
            suma1 = nrMas[0]+nrMas[1]+nrMas[2];
            suma2 = nrMas[3]+nrMas[4]+nrMas[5];
            if (suma1 == suma2){
                int count=0;
                for (int i = 0; i < nrMas.length; i++){
                    for (int j = 0; j < nrMas.length; j++) {
                       if(nrMas[i]==nrMas[j]){
                           count++;
                       }
                    }
                }
                if(count == nrMas.length) System.out.println(nr + " yra laimingasis skaičius!");
                else System.out.println(nr + " nėra laimingasis skaičius!");
            }else System.out.println(nr + " nėra laimingasis skaičius!");

        }else System.out.println(nr + " tai nėra šešiaženklis skaičius");
    }

    }

