/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.moravian;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author Mr. Bin
 */
public class Grid {

   private final int[][] grid;

    /**
     Create a new grid with all values set to zero.
    */
    public Grid()
    {
        grid = new int[9][9];
//        for (int row = 0; row < 9; row ++)
//        {
//            for (int col = 0; col < 9; col++)
//            {
//                grid[row][col] = 0;
//            }
//        }
    }

    /**
    Create a grid based on the contents of the specified file.  The file 
    is assumed to be made up of 9 row with each row containing 9 values
    separated by spaces.  Any row beginning with a # character is treated
    as a comment and ignored.
    
    @param filename the file to read
    @throws FileNotFoundException if the file cannot be opened.
    @throws FileFormatException if the file does not match the described
            format (too many rows, too few rows, or wrong number of values
            in a row) - or if the data in the file does not represent a
            valid Sudoku grid.
    */
    public Grid(String filename) throws FileNotFoundException, IOException, FileFormatException
    {
        grid = new int[9][9];
        
        BufferedReader infile = new BufferedReader (new FileReader (filename));
        
        String line;
        int value = 0;
        
        while ((line = infile.readLine()) != null)
        {
            line = line.trim();

            if(line.length() == 0)
                continue;

            if(line.startsWith("#"))
                continue;

            if(line.length() != 17)
            {
                throw new FileFormatException("Wrong number of values in a row");
            }

            Scanner s = new Scanner(line);
            try
            {
                for (int j = 0; j < 9; j ++)
                {
                    int number = s.nextInt();
                    grid[value][j] = number;
                    if (number != 0 && !isLegalSet(value, j, number))
                    {
                        throw new FileFormatException("The file can invalidate the grid");
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException | IllegalArgumentException ex)
            {
                throw new FileFormatException("Too many rows");
            }                   
            value ++;
        }
        if (value < 9)
        {
            throw new FileFormatException("Too few rows");
        }
    }
    
    /**
    Get the current value in the specified cell of the grid.
    @param row the row in the range [0, 9)
    @param col the column in the range [0, 9)
    @return The value in the cell, a number in the range [1, 9] or the value 
            0 if the cell is empty.
    @throws IndexOutOfBoundsException if row or col are outside the range [0, 9).
    */
    public int getValue(int row, int col)
    {
        int value;
        if (row < 0 || row > 8 || col < 0 || col > 8)
        {
            throw new IndexOutOfBoundsException("Index should be from 0 to 8");
        }
        value = grid[row][col];
        if (value > 0 && value <10)
        {
            return value;
        }
        else
        {
            return 0;
        }
    }

    /**
    Determine if the specified cell can legally be set to the specified
    value.
    @param row the row in the range [0, 9)
    @param col the column in the range [0, 9)
    @param value the value to check.
    @return True if it is legal to set the cell to the value, false
            otherwise.
    @throws IndexOutOfBoundsException if row or col is outside the range [0, 9).
    @throws IllegalArgumentException if value is outside the range [1, 9].
    */
    public boolean isLegalSet(int row, int col, int value)
    {
        boolean rowCheck = true;
        boolean colCheck = true;
        boolean squareCheck = true;
        
        int initRow = 0;
        int endRow = 0;
        int initCol = 0;
        int endCol = 0;
        
        if (row < 0 || row > 8 || col < 0 || col > 8)
        {
            throw new IndexOutOfBoundsException("Index must be from 0 to 8");
        }
        if (value < 1 || value > 9)
        {
            throw new IllegalArgumentException("Value must be from 1 to 9");
        }
        
        for (int j = 0; j < 9; j++)
        {
            int rowValue = grid[row][j];
            if(j != col)
            {
                if (rowValue == value)
                {
                    rowCheck = false;
                    break;
                }
            }
        }
        
        for (int i = 0; i < 9; i ++)
        {
            int colValue = grid[i][col];
            if(i != row)
            {
                if (colValue == value)
                {
                    colCheck = false;
                    break;
                }
            }
        }
        
        if (row < 9)
        {
            initRow = 6;
            endRow = 9;
            if (row < 6)
            {
                initRow = 3;
                endRow = 6;
                if (row < 3)
                {
                    initRow = 0;
                    endRow = 3;
                }
            }
        }
        
        if (col < 9)
        {
            initCol = 6;
            endCol = 9;
            if (col < 6)
            {
                initCol = 3;
                endCol = 6;
                if (col < 3)
                {
                    initCol = 0;
                    endCol = 3;
                }
            }
        }
        
        for (int i = initRow; i < endRow; i++)
        {
            for (int j = initCol; j < endCol; j++)
            {
                int squareValue = grid[i][j];
                if (i!= row && j!= col)
                {
                    if (squareValue == value)
                    {
                        squareCheck = false;
                        break;
                    }
                }
            }
        }
        
        return rowCheck && colCheck && squareCheck;
    }

    /**
    Set the specified cell in the grid with the specified value.  Values 
    should be in the range [0, 9)

    @param row the row in the range [0, 9)
    @param col the column in the range [0, 9)
    @param value the value in the range [1, 9]
    @throws IndexOutOfBoundsException if row or col is outside the range [0, 9).
    @throws IllegalArgumentException if value is outside the range [1, 9].
    @throws IllegalArgumentException if setting the value would invalidate
            the grid.
    */
    public void setValue(int row, int col, int value)
    {
        if (row < 0 || row > 8 || col < 0 || col > 8)
        {
            throw new IndexOutOfBoundsException("Index must be from 0 to 8");
        }
        else if (value < 1 || value > 9)
        {
            throw new IllegalArgumentException("Value must be from 1 to 9");
        }
        else if (isLegalSet(row,col,value) == false)
        {
            throw new IllegalArgumentException("The value would invalidate the grid");
        }
        else
            grid[row][col] = value;
    }

    /**
    Clear the specified cell by settings its value to 0.
    @param row the row in the range [0, 9)
    @param col the column in the range [0, 9)
    @throws IndexOutOfBoundsException if row or col is outside the range [0, 9).
    */
    public void clearValue(int row, int col)
    {
        if (row < 0 || row > 8 || col < 0 || col > 8)
        {
            throw new IndexOutOfBoundsException("Index should be from 0 to 8");
        }
        grid[row][col] = 0;
    }

    /**
    This method saves the grid to the specified file.  The format of the file
    is 9 lines, with each line containing 9 values separated by spaces.
    @param filename the file to write to.
    @throws IOException if the file cannot be opened for write or if an 
            error occurs while writing.
    */
    public void save(String filename) throws IOException
    {
        PrintWriter out = new PrintWriter(filename);
        
        try
        {
            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j ++)
                {
                    out.print(grid[i][j] + " ");
                }
                out.println();
            }

            if (out.checkError())
            {
                throw new IOException("Error while writing file");
            }
        }
        finally
        {
            out.close();
        }
    }
    
    public String toString()
    {
        StringBuilder b = new StringBuilder();
        b.append("\n");
        
        for(int row = 0; row < 9; row++)
        {
            if(row % 3 == 0 && row != 0)
            {
                b.append("-----------\n");
            }

            for(int col = 0; col < 9; col++)
            {
                if(col % 3 == 0 && col != 0)
                {
                    b.append("|");
                }
                b.append(grid[row][col]);
            }

            b.append("\n");
        }
        return b.toString();
    }
}

