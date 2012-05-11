package com.ask.quora;


public class Launcher {

    public static void main(String[] args){
//        char[][] matrix = {
//                {'2', '0', '0', '0'},
//                {'0', '0', '0', '0'},
//                {'0', '0', '3', '1'}
//        };

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
        System.out.println("There are "+n+" ways to wire.");
    }

}
