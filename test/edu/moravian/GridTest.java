/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.moravian;

import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Mr. Bin
 */
public class GridTest {
    
    public GridTest() {
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }

    /**
     * Test of getValue method, of class Grid.
     */
    @Test
    public void testNewGrid() 
    {
        Grid a = new Grid();
        int value = 0;
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j ++)
            {
                value = a.getValue(i,j);
                assertEquals(value, 0);
            }
        }
    }
    
    @Test
    public void testGridFromFile() throws IOException, FileNotFoundException, FileFormatException
    {
        Grid a = new Grid("src/gridfromfile.dat");
        int value = 0;
        for(int j = 0; j < 9; j++)
        {
            value = a.getValue(0,j);
            assertEquals(value, j+1);
        }        
    }
    
    @Test
    public void fileNotFound() throws IOException, FileFormatException
    {
        try
        {
            Grid a = new Grid("nonexistedfile.dat");
            fail ("did not throw FileNotFoundException");
        }
        catch (FileNotFoundException ex)
        {
        }
    }
    
    @Test
    public void fileTooManyRows() throws IOException, FileNotFoundException
    {
        try
        {
            Grid a = new Grid("src/toomanyrows.dat");
            fail("Do not throw FileFormatException");
        }
        catch(FileFormatException ex)
        {
        }
    }
    
    @Test
    public void fileTooFewRows() throws IOException, FileNotFoundException
    {
        try
        {
            Grid a = new Grid("src/toofewrows.dat");
            fail("Do not throw FileFormatException");
        }
        catch(FileFormatException ex)
        {
            
        }
    }
    
    @Test
    public void fileWrongNumberOfValues() throws IOException, FileNotFoundException
    {
        try
        {
            Grid a = new Grid("src/wrongnumberofvalues.dat");
            fail("Do not throw FileFormatException");
        }
        catch (FileFormatException ex)
        {

        }
    }
    
    @Test
    public void fileInvalidGrid() throws FileNotFoundException, IOException
    {
        try
        {
            Grid a = new Grid("src/invalidgrid.dat");
            fail("Do not throw FileFormatException");
        }
        catch(FileFormatException ex)
        {
            
        }
    }
    
    @Test
    public void fileHashTagsBetweenRows() throws IOException, FileNotFoundException, FileFormatException
    {
        Grid a = new Grid("src/commentbetweenrows.dat");
    }
    
    @Test
    public void fileSpacesBetweenRows() throws IOException, FileNotFoundException, FileFormatException
    {
            Grid a = new Grid("src/spacesbetweenrows.dat");
    }
    
    @Test
    public void fileEmptyFile() throws IOException
    {
        try
        {
            Grid a = new Grid("src/emptyfile.dat");
            fail("Do not throw FileFormatException");
        }
        catch (FileFormatException ex)
        {
        }
    }
            
    @Test
    public void fileNoSpaceBetweenNumbers() throws IOException, FileNotFoundException, FileFormatException
    {
        try
        {
            Grid a = new Grid("src/nospacebetweennumbers.dat");
        }
        catch(FileFormatException ex)
        {
        }
    }
    
    @Test
    public void fileOutOfRangeHighValue() throws IOException
    {
        try
        {
            Grid a = new Grid("src/outofrangehighvalue.dat");
            fail("Do nor throw FileFormatException");
        }
        catch (FileFormatException ex)
        {
        }
    }

    @Test
    public void fileOutOfRangeLowValue() throws IOException
    {
        try
        {
            Grid a = new Grid("src/outofrangelowvalue.dat");
            fail("Do not throw FileFormatException");
        }
        catch (FileFormatException ex)
        {
        }
    }
    @Test
    public void exceptionIndexOutOfBoundsPositiveClearValue()
    {
        try
        {
            Grid a = new Grid();
            a.clearValue(9, 9);
            a.clearValue(10, 10);
            a.clearValue(11, 11);
            fail("Do not throw IndexOutOfBoundsException");
        }
        catch (IndexOutOfBoundsException ex)
        {
        }
    }
    
    @Test
    public void exceptionIndexOutOfBoundsNegativeClearValue()
    {
        try
        {
            Grid a = new Grid();
            a.clearValue(-1, -1);
            a.clearValue(-2, -2);
            a.clearValue(-3, -3);
            fail("Do not throw IndexOutOfBoundsException");
        }
        catch (IndexOutOfBoundsException ex)
        {
            
        }
    }
    
    @Test
    public void exceptionIndexOutOfBoundsNegativeGetValue()
    {
        try
        {
            Grid a = new Grid();
            a.getValue(-1, -1);
            a.getValue(-2, -2);
            a.getValue(-3,-3);
            fail("Do not throw IndexOutOfBoundsException");
        }
        catch (IndexOutOfBoundsException ex)
        {
            
        }
    }
    
    @Test
    public void exceptionIndexOutOfBoundsPositiveGetValue()
    {
        try
        {
            Grid a = new Grid();
            a.getValue(9, 9);
            a.getValue(10,10);
            a.getValue(11,11);
            fail("Do not throw IndexOutOfBoundsException");
        }
        catch (IndexOutOfBoundsException ex)
        {
            
        }
    }
    
    @Test
    public void exceptionIndexOutOfBoundsNegativeIsLegalSet() throws IllegalArgumentException
    {
        try
        {
            Grid a = new Grid();
            a.isLegalSet(-1,-1,5);
            a.isLegalSet(-2, -2, 5);
            a.isLegalSet(-3, -3, 5);
            fail("Do not throw IndexOutOfBoundsException");
        }
        catch(IndexOutOfBoundsException ex)
        {
            
        }
        
    }
    
    @Test
    public void exceptionIndexOutOfBoundsPositiveIsLegalSet() throws IllegalArgumentException
    {
        try
        {
            Grid a = new Grid();
            a.isLegalSet(10,10,5);
            a.isLegalSet(9, 9, 5);
            a.isLegalSet(11, 11, 5);
            fail("Do not throw IndexOutOfBoundsException");
        }
        catch(IndexOutOfBoundsException ex)
        {
            
        }
        
    }
    
    @Test
    public void exceptionOutOfRangePositiveIsLegalSet() throws IndexOutOfBoundsException
    {
        try
        {
            Grid a = new Grid();
            a.isLegalSet(1,1,10);
            a.isLegalSet(1, 1, 11);
            a.isLegalSet(1, 1, 12);
            fail("Do not throw IllegalArgumentExeption");
        }
        catch (IllegalArgumentException ex)
        {
            
        }         
    }
    
    @Test
    public void exceptionOutOfRangeNegativeIsLegalSet() throws IndexOutOfBoundsException
    {
        try
        {
            Grid a = new Grid();
            a.isLegalSet(2,2,-2);
            a.isLegalSet(2, 2, -1);
            a.isLegalSet(2, 2, -3);
            fail("Do not throw IllegalArgumentExeption");
        }
        catch (IllegalArgumentException ex)
        {
            
        }         
    }
    
    @Test
    public void exceptionOutOfRangeZeroIsLegalSet()
    {
        try
        {
            Grid a = new Grid();
            a.isLegalSet(1, 1, 0);
            a.isLegalSet(2,2,0);
            fail("Do not throw IllegalArgumentException");
        }
        catch (IllegalArgumentException ex)
        {
            
        }
    }
    
    @Test
    public void exceptionSavingProblems()
    {
        try
        {
            Grid a = new Grid();
            a.save("src/fakesavefile.dat");
            fail("Do not throw IOException");
        }
        catch (IOException ex)
        {
            
        }      
    }
    
    @Test
    public void exceptionIndexOutOfBoundsNegativeSetValue()
    {
        try
        {
            Grid a = new Grid();
            a.setValue(-1,-1,5);
            a.setValue(-2,-2,5);
            a.setValue(-3,-3,5);
            fail("Do not throw IndexOutOfBoundsException");
        }
        catch (IndexOutOfBoundsException ex)
        {
            
        }
                
    }
    
    @Test
    public void exceptionIndexOutOfBoundsPositiveSetValue()
    {
        try
        {
            Grid a = new Grid();
            a.setValue(10, 10, 5);
            a.setValue(11,11,5);
            a.setValue(9,9,5);
            fail("Do not throw IndexOutOfBoundsException");
        }
        catch (IndexOutOfBoundsException ex)
        {
            
        }
                
    }
    
    @Test
    public void exceptionOutOfRangePositiveSetValue()
    {
        try
        {
            Grid a = new Grid();
            a.setValue(5, 5, 10);
            a.setValue(5, 5, 11);
            a.setValue(5,5,12);
            fail("Do not throw IllegalArgumentException");
            
        }
        catch(IllegalArgumentException ex)
        {
            
        }
    }
    
    @Test
    public void exceptionOutOfRangeNegativeSetValue()
    {
        try
        {
            Grid a = new Grid();
            a.setValue(6, 6, -2);
            fail("Do not throw IllegalArgumentException");
            
        }
        catch(IllegalArgumentException ex)
        {
            
        }
    }
    
    @Test
    public void exceptionOutOfRangeZeroSetValue()
    {
        try
        {
            Grid a = new Grid();
            a.setValue(6,6,0);
            fail("Do not throw IllegalArgumentException");
        }
        catch (IllegalArgumentException ex)
        {
            
        }
    }
    @Test
    public void fileSetValueWouldInvalidateTheGrid() throws IOException, FileNotFoundException, FileFormatException
    {
        try
        {
            Grid a = new Grid("src/completedsudoku171.dat");
            a.setValue(0, 4, 6);
            fail("Do not throw IllegalArgumentException");
        }
        catch(IllegalArgumentException ex)
        {
        }
    }
    
    @Test
    public void clearValueOneItem() throws IOException, FileNotFoundException, FileFormatException
    {
        Grid a = new Grid("src/completedsudoku171.dat");
        a.clearValue(0,6);
        int value = a.getValue(0,6);
        assertEquals(value, 0);
    }
    
    @Test
    public void clearValueWholeGrid() throws IOException, FileNotFoundException, FileFormatException
    {
        Grid a = new Grid("src/completedsudoku171.dat");
        int value = 0;
        for (int i = 0; i < 9; i ++)
        {
            for (int j = 0; j < 9; j++)
            {
                a.clearValue(i, j);
                value = a.getValue(i,j);
                assertEquals(value, 0);
            }
        }
    }
    
    @Test
    public void clearValueOneColumn() throws IOException, FileNotFoundException, FileFormatException
    {
        Grid a = new Grid("src/completedsudoku171.dat");
        int value = 0;
        for (int i = 0; i < 9; i++)
        {
            a.clearValue(i, 0);
            value = a.getValue(i,0);
            assertEquals(0, value);
        }
        assertEquals(1, a.getValue(3,3));
        assertEquals(2, a.getValue(7,4));
    }
    
    @Test
    public void clearValueOneRow() throws IOException, FileNotFoundException, FileFormatException
    {
        Grid a = new Grid("src/completedsudoku171.dat");
        int value = 0;
        for (int j = 0; j < 9; j++)
        {
            a.clearValue(0, j);
            value = a.getValue(0,j);
            assertEquals(0, value);
        }
        assertEquals(6, a.getValue(3,0));
        assertEquals(2, a.getValue(7,4));
    }
    
    
    @Test
    public void isLegalSetSameCellSameValue() throws IOException, FileNotFoundException, FileFormatException
    {
        Grid a = new Grid("src/gridfromfile.dat");
        for (int j = 0; j < 9; j++)
        {
            assertTrue(a.isLegalSet(0,j,j+1));
        }
    }
    
    @Test
    public void isLegalSetKnownCompletedGrid() throws IOException, FileNotFoundException, FileFormatException
    {
        Grid a = new Grid("src/completedsudoku171.dat");
        Grid b = new Grid("src/completedsudoku171.dat");
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j ++)
            {
                assertTrue(a.isLegalSet(i, j, b.getValue(i,j)));
            }
        }
    }
    
    @Test
    public void setValueSameCellSameValue() throws IOException, FileNotFoundException, FileFormatException
    {
        Grid a = new Grid("src/gridfromfile.dat");
        int value = 0;
        for (int j = 0; j < 9; j ++)
        {
            a.setValue(0, j, j+1);
            value = a.getValue(0,j);
            assertEquals(value, j+1);
            
        }
    }
    
    @Test
    public void saveAllZeroGrid() throws IOException, FileNotFoundException, FileFormatException
    {
        Grid a = new Grid();
        a.save("src/saveallzerogrid.dat");
        Grid b = new Grid("src/saveallzerogrid.dat");
        int value = 0;
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                value = b.getValue(i,j);
                assertEquals(value,0);
            }
        }
    }
    
    @Test
    public void saveKnownGrid() throws IOException, FileNotFoundException, FileFormatException
    {
        Grid a = new Grid("src/gridfromfile.dat");
        a.save("src/savegridfromfile.dat");
        Grid b = new Grid("src/savegridfromfile.dat");
        int value = 0;
        for (int j = 0; j < 9; j++)
        {
            value = b.getValue(0,j);
            assertEquals(value, j+1);
        }
    }
    
    @Test
    public void exceptionSetOneValueForTheWholeGrid()
    {
        try
        {
            Grid a = new Grid();
            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    a.setValue(i,j,5);
                }
            }
            fail("Do not throw any exception");
        }
        catch (IllegalArgumentException ex)
        {
            
        }
    }
    
    @Test
    public void exceptionFileSameValueForTheWholeGrid() throws IOException, FileNotFoundException, FileFormatException
    {
        try
        {
            Grid a = new Grid("src/samevalueforthewholegrid.dat");
            fail("Do not throw FileFormatException");
        }
        catch(FileFormatException ex)
        {
            
        }
        
    }
    
    @Test
    public void setMultipleValues()
    {
        Grid a = new Grid ();
        a.setValue(0,0,5);
        a.setValue(4, 5, 7);
        a.setValue(7, 3, 8);
        int value = a.getValue(0, 0);
        int value2 = a.getValue(4,5);
        int value3 = a.getValue(7,3);
        assertEquals(value, 5);
        assertEquals(value2, 7);
        assertEquals(value3, 8);
    }
    
    @Test
    public void exceptionSetOneValueForAWholeRow()
    {
        try
        {
            Grid a = new Grid();
            int value = 0;
            for (int j = 0; j < 9; j ++)
            {
                a.setValue(0, j, 5);
                value = a.getValue(0, j);
                assertEquals(value, 5);
            }
            fail("Do not throw IllegalArgumentException");
        }
        catch(IllegalArgumentException ex)
        {
            
        }
    }
    
    @Test
    public void exceptionSetOneValueForAWholeColumn()
    {
        try
        {
            Grid a = new Grid();
            int value;
            for (int i = 0; i < 9; i ++)
            {
                a.setValue(i, 0, 5);
                value = a.getValue(i, 0);
                assertEquals(value, 5);
            }
            fail("Do not throw IllegalArgumentException");
        }
        catch (IllegalArgumentException ex)
        {
        
        }
                
    }
    
    @Test
    public void getMultipleKnownValues() throws IOException, FileNotFoundException, FileFormatException
    {
        Grid a = new Grid("src/completedsudoku171.dat");
        int value1 = a.getValue(0, 6);
        int value2 = a.getValue(2,0);
        int value3 = a.getValue(6,7);
        assertEquals(value1, 6);
        assertEquals(value2, 4);
        assertEquals(value3, 9);
    }
}
