/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zajecia7;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Acer
 */
public class Czas {
    private int godz;
    private int min;
    private void Zmien()
    {
        if(min>=60) 
        {
            int a  =(int)(min/60);
            min -= (a * 60);
            godz += a;
	}
    }
    public Czas(int _godz, int _min)
    {
        godz = _godz;
        min = _min;
        if(min>=60) 
        {
            Zmien();
	} 
    }
    
    public Czas(String czasSlownie)
    {
        czasSlownie = czasSlownie.replaceAll("[^0-9]+", " ");
        String[] x = (czasSlownie.trim().split(" "));
        if (x.length == 2)
        {
            godz = Integer.parseInt(x[0]);
            min = Integer.parseInt(x[1]);
        }
        if(min>=60) 
        {
            Zmien();
	}   
    }
    
    public String ToString()
    {
        String a = String.format("%d h %d min", godz,min);
        return a;
    }
    
    public Czas Dodaj(Czas t)
    {   
        int x = godz + t.godz;
        int y = min + t.min;      
        Czas z = new Czas(x,y);
       if(min>=60) 
        {
            Zmien();
	}
        return z;
    }
    
    public Czas Odejmij(Czas t)
    {   
        int x = godz - t.godz;
        int y = min - t.min;    
        if(min>=60) 
        {
            Zmien();
	}
        Czas z = new Czas(x,y);
        
        return z;
    }
     
    public Czas Pomnoz(int ile)
    {
        int x = godz * ile;
        int y = min * ile;
        if(min>=60) 
        {
            Zmien();
	}
        Czas z = new Czas(x,y);
        return z;
    }
    
    static Czas Sumuj(Czas [] tab, int n)
    {
        int a = 0;
        int b = 0;
        for(Czas x : tab)
        {
            a += x.godz;
            b += x.min; 
            if(x.min>=60) 
            {
               int z  =(int)(x.min/60);
               a = x.min -= (a * 60);
               b = x.godz += a;
            }
        }
        Czas z = new Czas(a,b);
        return z;
    }
}

