/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zajecia7;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Acer
 */
public class Zajecia7 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        // TODO code application logic here
        
        
        /* //Zadanie 1
        Pozycja p1 = new Pozycja("Chleb", 1, 3.5);
        System.out.println(p1.ToString());
        Pozycja p2 = new Pozycja("Cukier", 3, 4);
        System.out.print(p2.ToString()); 
        Zamowienie z = new Zamowienie();
        System.out.println("");
        z.DodajPozycje(p1);
        z.DodajPozycje(p2);
        System.out.println("\n" + z.ObliczWartosc() + " razem");
        System.out.println("Edytowanie cukru");
        z.edytujPozycje(1);
        System.out.println("\n" + z.ObliczWartosc() + " razem");
        
        System.out.println("Nowych chleb, dodaj chleb z rabatem");
        Pozycja p3 = new Pozycja("Chleb", 5, 3.5);
        z.DodajPozycje(p3);
        p3.obliczWartoscZRabatem();
        System.out.println(p3.ToString());
        
        System.out.println("Zamowienia do pliku");
        Zamowienie.zapiszZamowienie(z,"test.txt");
        System.out.println("");
        Zamowienie y = Zamowienie.wczytajZamowienie("test.txt");
        y.Pokaz();
        */ 
        
        
        /* Zadanie 2
        final int N = 10;
        Lista l = new Lista(N);
        
        for (int i = 0; i < N/2; ++i) 
        {
            l.DodajElement( (1 << i) );
        }

        l.DodajElement(2);
        l.DodajElement(8);
        l.Pisz();
        l.UsunPierwszy(2);
        l.Pisz();
        
        
        for (int i = 0; i < N/2; ++i) {
        l.DodajElement( (1 << i) );
        }
        l.Pisz();
        System.out.println("Po usunięciu powtórzeń:");
        l.UsunPowtorzenia();
        l.Pisz();
       l.Odwroc();
       l.Pisz();
       l.ZapiszDoPliku("Zapisz.txt", l);
        System.out.println("Z pliku");
        Lista x = Lista.wczytajLista("Zapisz.txt");
        x.Pisz();
        */
        
        /* //Zadanie 3
        Czas t1 = new Czas(10,56);
        Czas t2 = new Czas(0,123);
        System.out.println("t1 = " + t1.ToString());
        System.out.println("t2 = " + t2.ToString());
        System.out.println("t1 + t2 = " + t1.Dodaj(t2).ToString());
        System.out.println("t1 - t2 = " + t1.Odejmij(t2).ToString());
        Czas [] tab = { t1, t2, t2 };
        System.out.println("Czas.sumuj dla t1 + t2 + t2 = " +
        Czas.Sumuj(tab, 3).ToString());
        System.out.println("t1 * 2 = " + t1.Pomnoz(2).ToString());
        Czas t3("3 h 17 min");
        System.out.println("Konstruktor z łańcuchem: " + t3.ToString());
        */
        
        
       
        
       Zamowienie z = new Zamowienie();
        System.out.println("");Pozycja p1 = new Pozycja("Chleb", 1, 3.5);
        Pozycja p2 = new Pozycja("Cukier", 3, 4);
        z.DodajPozycje(p1);
        z.DodajPozycje(p2);
        
        z.ToString();
}
    
}
