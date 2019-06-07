/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zajecia7;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Zamowienie implements Serializable{
    Pozycja[] pozycje = new Pozycja[10];
    static int ileDodanych = 0;
    int maksRozmiar = 10;
    
    
    Zamowienie()
    { 
        pozycje = new Pozycja[maksRozmiar];       
    }
    
    Zamowienie(int _maksRozmiar)
    {
        this.maksRozmiar = _maksRozmiar;
        pozycje = new Pozycja[maksRozmiar];      
    }
    void Pokaz()
    {
        for (Pozycja x: pozycje)
        {
            if(x != null)
            { 
                System.out.println(x.ToString());
            }
        }
    }
    
    void DodajPozycje(Pozycja p)
    {
        for(Pozycja x : pozycje)
        {
            if ( x != null && x.nazwaTowaru.equals(p.nazwaTowaru))
            {
                x.ileSztuk += p.ileSztuk;
                System.out.printf("Dodano %d sztuk do %s", p.ileSztuk, x.nazwaTowaru);
                System.out.println("razem: " + x.ileSztuk);
                return;              
            }
        } 
        
        if (ileDodanych <= maksRozmiar)
        {
            System.out.println("dodano pozycje: " + p.nazwaTowaru + "indeks: " + ileDodanych);
            pozycje[ileDodanych] = p;
            ileDodanych++;
        } else System.out.println("Osiągnięto maksymalną ilość!");
    }
    
    void UsunPozycje(int indeks)
    {
        int j = 0;
        for (int i = 0; i < pozycje.length; i++)
        {
           if (i != indeks)
           {
               pozycje[j] = pozycje[i];
               j++;
           }
        }
        ileDodanych--;
        // lub do listy i usunąć z listy ew. pozycje[indeks] = null;
    }
    
    void edytujPozycje(int indeks)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nazwa");
        pozycje[indeks].nazwaTowaru = in.nextLine();
        System.out.println("Cena double");
        pozycje[indeks].cena = in.nextDouble();
        System.out.println("ilosc int");
        pozycje[indeks].ileSztuk = in.nextInt();
        
    }
    
    double ObliczWartosc()
    {
        double wynik = 0;
        for (Pozycja x : pozycje)
        {
            if (x != null)
            {
                wynik += x.obliczWartoscZRabatem();
            }
        }
        return wynik;
    }
    
    public String ToString()
    {
        StringBuilder sb = new StringBuilder();
        for(Pozycja x : pozycje)
        {
            if (x != null)
            {
                sb.append(String.format("Nazwa towaru: %s łączna wartość: %.2f\n", x.nazwaTowaru, (float)x.ObliczWartosc()));
            }
        }
        String z = sb.toString();
        System.out.println(z);
        return z;
    }
    
    public static void zapiszZamowienie(Zamowienie z, String nazwaPliku) throws IOException
    {
        ObjectOutputStream plik = null;
        try
        {
            plik = new ObjectOutputStream(new FileOutputStream(nazwaPliku));
            plik.writeObject(z);
            plik.flush();
        }
        finally
        {
            if(plik!=null)
            {
                plik.close();
            }
        }
    }
    
    public static Zamowienie wczytajZamowienie(String nazwaPliku) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ObjectInputStream plik = null;
        try {
            plik = new ObjectInputStream(new FileInputStream(nazwaPliku));
                Zamowienie Z;
                Z = (Zamowienie)plik.readObject(); 
                return Z;
        }
        finally{
            if(plik!=null)
            {
                plik.close();
            }
        }
    }
    
}
