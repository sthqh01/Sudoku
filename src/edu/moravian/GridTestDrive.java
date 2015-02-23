/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.moravian;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Mr. Bin
 */
public class GridTestDrive {
    public static void main (String[] args)
    {
        Grid a = new Grid();
        for (int i = 0; i < 0; i++)
        {
            for (int j = 0; j < 0; j++)
            {
                a.setValue(i,j,5);
            }
        }
//        Grid a = new Grid();
//        a.setValue (1,1 ,2);
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                System.out.print((a.getValue(i,j)+" "));
            }
            System.out.println();
        }
    }
//        System.out.println(a.isLegalSet(0, , 2));
//        try
//        {
//            Grid a = new Grid("src/data.dat");
//            a.setValue(1, 1, 2);
//            for (int i = 0; i < 9; i++)
//            {
//                for (int j = 0; j < 9; j++)
//                {
//                    System.out.print((a.getValue(i,j)+" "));
//                }
//                System.out.println();
//            }
//            System.out.println(a.isLegalSet(0,6,5));
//        }
//        catch (FileNotFoundException | FileFormatException ex)
//        {
//            System.out.println(ex);
//        }
//        catch (IOException ex)
//        {
//            System.out.println(ex);
//        }
//        try
//        {
//        Grid b = new Grid();
//        b.save("src/data2.dat");
//        }
//        catch (IOException ex)
//        {
//            System.out.println("There is a saving problem");
//        }
    
}
