/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zajecia7;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class Pozycja implements Serializable{
    String nazwaTowaru;
    int ileSztuk;
    double cena;
    double rabat = 1;
    Pozycja(String _nazwaTowaru, int _ileSztuk, double _cena)
    {
        this.nazwaTowaru = _nazwaTowaru;
        this.ileSztuk = _ileSztuk;
        this.cena = _cena;
    }
    
    public double ObliczWartosc()
    {
        double f = ileSztuk * cena;
        return f;
    }
    
    public String ToString()
    {   
        double razem = obliczWartoscZRabatem();
        String x = String.format("%-20s %10.2f zł za sztukę %4d szt. łącznie: %10.2f zł %10.2f Rabatu" , nazwaTowaru,cena,ileSztuk,razem,(1 - rabat));
        return x;
    }
    
    double obliczWartoscZRabatem()
    {
        double f = ileSztuk * cena;
        if (ileSztuk >= 5)
        {
            rabat = 0.95;
        } else 
            if(ileSztuk >= 10 && ileSztuk < 20 )
            {
                rabat = 0.90;
            } else 
                if(ileSztuk >= 20)
                {
                    rabat = 0.85;
                }
        return f * rabat;
    }
}
