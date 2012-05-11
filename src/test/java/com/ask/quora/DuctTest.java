package com.ask.quora;

import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: Di HUANG (di.huang@ask.com)
 * Date: 4/27/12
 * Time: 3:02 PM
 */
public class DuctTest {

    @Test
    public void testGetNumberOfWays_4by3() throws Exception {
        char[][] matrix = {
                {'2', '0', '0', '0'},
                {'0', '0', '0', '0'},
                {'0', '0', '3', '1'}
        };

        DataCenter dataCenter = new DataCenter(matrix[0].length, matrix.length, matrix);
        Duct duct = new Duct();
        int numberOfWays = duct.getNumberOfWays(dataCenter);
        assertEquals(numberOfWays, 2);
    }

    @Ignore
    public void testGetNumberOfWays_7by8() throws Exception {
        char[][] matrix = {
                {'2', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'3', '0', '0', '0', '0', '1', '1'}
        };

        DataCenter dataCenter = new DataCenter(matrix[0].length, matrix.length, matrix);
        dataCenter.printMatrix();
        System.out.println(dataCenter.getStatus());

        Duct duct = new Duct();
        long start = System.currentTimeMillis();
        int n = duct.getNumberOfWays(dataCenter);
        long end = System.currentTimeMillis();
        System.out.println("It took: "+(end-start)/1000+" s to complete.");
        System.out.println("There are " + n + " ways to wire.");
    }
}
