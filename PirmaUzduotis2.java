package Laboratoriniai;
import java.util.Random;

public class PirmaUzduotis2 {
    public static void main(String[] args) {

        boolean uzd = false;
        int suma1,suma2 = 0;
        int nrRand = 0;
        int kartai = 0;
        Random rand = new Random();
        while ( uzd == false) {
            nrRand = rand.nextInt(99999)+((rand.nextInt(9)+1)*100000);
            //nrRand = 628745; //Laimingasis skaicius pagal pavyzdi
            System.out.println(nrRand);
            String nrString = Integer.toString(nrRand);
            int[] nrMas = new int[nrString.length()];
            for(int i=0; i<nrString.length(); i++){
                nrMas[i] = Character.getNumericValue(nrString.charAt(i));
            }
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
                if(count == nrMas.length){
                    uzd=true;
                }
            }
            kartai++;
        }
        System.out.println("Reikejo bandymu = "+kartai+ " Laimingasis skaicius "+ nrRand);

    }
}
