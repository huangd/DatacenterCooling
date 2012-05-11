package com.ask.quora;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * User: Di HUANG (di.huang@ask.com)
 * Date: 4/27/12
 * Time: 3:18 PM
 */
public class DataCenterTest {
    @Test
    public void testToString() throws Exception {
        char[][] matrix = {
                {'2', '0', '0', '0'},
                {'0', '0', '0', '0'},
                {'0', '0', '3', '1'}
        };

        DataCenter dataCenter = new DataCenter(matrix[0].length, matrix.length, matrix);
        String matrixString = dataCenter.toString();
        String expectedString = "200000000031";
        assertEquals(matrixString, expectedString);
    }
}
