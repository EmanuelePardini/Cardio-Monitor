//CLASSE CardioFreq
package com.mycompany.cardiofreq;

import java.util.Scanner;
import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class CardioFreq {
Scanner tast=new Scanner(System.in);
Random rand=new Random();
private String dataAllenamento;
private int freq[];
private int nAcquisizioni=0;
private int sogliaMin;
private int sogliaMax;
public CardioFreq(){
    dataAllenamento=null;
    sogliaMin=0;
    sogliaMax=0;
    for(int i=0;i<nAcquisizioni;i++){
        freq[i]=0;
    }
}
public void setTz(){
    System.out.println("Impostare i dati dell'area di lavoro efficace");
    System.out.println("Soglia minima");
    sogliaMin=tast.nextInt();
    System.out.println("Soglia massima");
    sogliaMax=tast.nextInt();
}
public void AvviaAllenamento(String data, int minutiDurata){
    System.out.println("Impostare la data e avviare l'allenamento");
    tast.nextLine();
   data= tast.nextLine();
    System.out.println("Impostare i minuti per una durata massima di 120m");
    minutiDurata=tast.nextInt();
      nAcquisizioni=minutiDurata*60;
      freq=new int [nAcquisizioni];
      for(int i=0;i<nAcquisizioni;i++){
          freq[i]=rand.nextInt(161)+40;
          System.out.println(freq[i]);
      }
      dataAllenamento=data;
}
public void VisualizzaAllenamento(){
    int freqMedia=0;
    int freqMin=99999999;
    int freqMax=0;
    int z=0;
    int target = 0;
    float perc;
    System.out.println("Data allenamento:" + dataAllenamento);
    System.out.println("Durata in minuti: "+(nAcquisizioni/60));
    for(int j=0;j<nAcquisizioni;j++)
    {
        z=freq[j]+z; //z qui viene usato per il totale
      if(freq[j]<freqMin){
           freqMin=freq[j];
      }
            if(freq[j]>freqMax){
           freqMax=freq[j];  
} 
    }
    freqMedia=z/nAcquisizioni;
    System.out.println("Frequenza media: "+ freqMedia);
     System.out.println("Frequenza minima: "+ freqMin);
     System.out.println("Frequenza massima: "+ freqMax);
     for (int j=0;j<nAcquisizioni;j++){
         if(freq[j]>sogliaMin && freq[j]<sogliaMax){
             target=target+1;
         }
     }
     System.out.println(target);
     perc=(target*100)/nAcquisizioni;
     System.out.println("La percentuale di lavoro nella Target Zone �: "+ perc+"%");
}}
//----------------------------------------------------------------------------------------------
//CLASSE Cardio_Main
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Cardio_Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CardioFreq metodo= new CardioFreq();
        metodo.setTz();
        metodo.AvviaAllenamento(null, 0);
        metodo.VisualizzaAllenamento();
    }
    
}
