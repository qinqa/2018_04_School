/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koe_18_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thomas
 */
public class Koe_18_4 {
    Scanner lukija = new Scanner(System.in);
    List<Matka> lista = new ArrayList<>();
    List<Varaus> varausLista = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Koe_18_4().ohjelma();
    }
    
    public void ohjelma() {
        
        System.out.println("\n1) lisaa matka");
        System.out.println("2) listaa matkat");
        System.out.println("3) varaa liput matkalle");
        System.out.println("4) listaa matkan liput");
        System.out.println("5) lopeta");
        System.out.println("(muut tulostavat valikon)");
    
        while(true) {
            
            
            
            System.out.print("\nSyötä komento: ");
            Integer komento = Integer.valueOf(lukija.nextLine());
            
            if(komento == 5) {
                break;
            } else if(komento == 1) {
                //Matkojen luonti
                System.out.print("Mistä: ");
                String mista = lukija.nextLine();
                System.out.print("Minne: ");
                String minne = lukija.nextLine();
                System.out.print("Paikkoja: ");
                Integer paikkoja = Integer.valueOf(lukija.nextLine());
                
                //Ohjeissa ei käsketty tarkistamaan, että paikkamäärä ei ole negatiivinen tai nolla
                //näin ollen kaikki kelpaa ja laitetaan listalle.
                
                if(lista.isEmpty()) {
                    Matka matka = new Matka(0, mista, minne, paikkoja);
                    lista.add(matka);
                } else {
                    Matka matka = new Matka(lista.size(), mista, minne, paikkoja);
                    lista.add(matka);
                }
                
                
            } else if(komento==2) {
                //Tulostetaan matkat
                for(int i=0;i<lista.size();i++) {
                    System.out.println(lista.get(i).getId() + ": " + lista.get(i).getMista() + "-" 
                    + lista.get(i).getMinne() + ", paikkoja jäljellä " + lista.get(i).getPaikkoja());
                }
            } else if(komento==3) {
                //Varataan matka
                System.out.print("Mikä matka: ");
                Integer matka = Integer.valueOf(lukija.nextLine());
                //Tehtävässä ei käsketty tarkistaa onko annettu matkanumero olemassa. Koska näin ei ole käsketty
                //ajetaan koko varaus osio läpi emailin kanssa vaikka id:tä ei olisi olemassa.
                System.out.print("Sähköposti: ");
                String email = lukija.nextLine();
                
                for(int i=0;i<lista.size();i++) {
                    if(lista.get(i).getId().intValue() == matka) {
                        //Tarkistetaan istumapaikat
                        if(lista.get(i).getPaikkoja()>=1) {
                            //Luodaan ja lisätään varaus listalle
                            Varaus varaus = new Varaus(email, lista.get(i));
                            varausLista.add(varaus);
                            //Vähennetään yksi paikka
                            lista.get(i).setPaikkoja();
                        }
                    }
                }
            } else if(komento==4) {
                System.out.print("Minkä matkan liput listataan?");
                Integer matka = Integer.valueOf(lukija.nextLine());
                
                if(matka <= varausLista.size()) {
                    for(int i=0;i<varausLista.size();i++) {
                        if(varausLista.get(i).getMatka().getId().intValue() == matka) {
                            System.out.println(varausLista.get(i).getEmail());
                        }
                    }
                }
            }
        }
    }
    
}
