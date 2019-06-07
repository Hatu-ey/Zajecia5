/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zajecia7;
import java.io.*;
/**
 *
 * @author Acer
 */
public class Lista implements Serializable{
    private int[] liczby;
    private int pojemnosc;
    private static int rozmiar = 0;
    
    Lista(int _pojemnosc)
    {
        pojemnosc = _pojemnosc;
        liczby = new int[pojemnosc];
        
    }
    
    public void DodajElement(int x)
    {
        try{
            liczby[rozmiar] = x;
            rozmiar++;
        }
        catch(ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("Lista jest Pełna! Próbowano dodać: " + x); 
        }
        
    }
    
    public int Znajdz(int x)
    {
        int poz = 0;
        
        for(int a : liczby)
        {
            if (a == x)
            {
                System.out.println(poz);
                return poz;
            }
            poz++;
        }
        
        System.out.println(-1);
        return -1;
    }
    
    public void Pisz()
    {
        System.out.printf("Lista: \n\tPojemnosc: %d \n\tRozmiar: %d  \n\tElementy: ", pojemnosc ,rozmiar);
        for(int a = 0; a < rozmiar; a++)
        {
            System.out.printf(liczby[a] + " ");
        }
        System.out.println("");
    }
    
    public void UsunPierwszy(int x)
    {
        int[] tmpArray = new int[rozmiar-1];
        
        for(int i = 0; i < rozmiar; i++)
        {
            if(liczby[i] == x)
            {
                for(int j = 0; j < i; j++)
                {
                    tmpArray[j] = liczby[j];
                }
                
                for(int k = i; k < rozmiar -1; k++)
                {
                    tmpArray[k] = liczby[k+1];
                }
                break;
            } 
        }
        rozmiar--;
        
        for(int i = 0; i < tmpArray.length;i++)
        {
            liczby[i] = tmpArray[i];
        }
    }
    
    public void UsunPowtorzenia()
    {
        
       for(int i = 0; i < rozmiar; i++)
       {
            for(int j = i+1; j < rozmiar; j++)
            {
                if(liczby[i] == liczby[j])
                {
                    for(int k = j; k < rozmiar-1; k++)
                    {
                        liczby[k] = liczby[k + 1];
                    }
                    j--;
                    rozmiar--;
                }
            }
        }   
    }
    
    public void Odwroc()
    {
        for (int i = 0; i < rozmiar/2; i++)
        {
            int tmp = liczby[i];
            liczby[i] = liczby[rozmiar-i];
            liczby[rozmiar-1] = tmp;
        }
    }
    
    public void ZapiszDoPliku(String plikWe, Lista x) throws IOException
    {
        ObjectOutputStream plik = null;
        try
        {
            plik = new ObjectOutputStream(new FileOutputStream(plikWe));
            plik.writeObject(x);
            plik.flush();
        } 
        finally
        {
            if (plik!=null)
            {
                plik.close();
            }
        }
    }
    
     public static Lista wczytajLista(String nazwaPliku) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ObjectInputStream plik = null;
        try {
            plik = new ObjectInputStream(new FileInputStream(nazwaPliku));
                Lista Z;
                Z = (Lista)plik.readObject(); 
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
