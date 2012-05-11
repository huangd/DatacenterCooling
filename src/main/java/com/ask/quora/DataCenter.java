package com.ask.quora;


public class DataCenter {
    
    private int width;
    private int height;
    private char[][] matrix;
    private int zeroCount;
    private Cell preEnd;
    private Cell end;
    private Cell start;

    
    public static enum Status{
        RUNNING, VALID, INVALID
    }
    
    public DataCenter(int width, int height, char[][] matrix){
        preEnd = null;
        zeroCount = 0;
        this.width = width;
        this.height = height;
        copyMatrix(matrix);
    }
    
    private void copyMatrix(char[][] from){
        matrix = new char[height][width];
        for(int h=0; h<height; ++h){
            for(int w=0; w<width; ++w){
                matrix[h][w] = from[h][w];
                init(h, w, matrix);
            }
        }
    }

    private void init(int height, int width, char[][] matrix){
        if(matrix[height][width] == '0'){
            ++zeroCount;
        }
        if(matrix[height][width] == '2'){
            start = new Cell(height, width);
            ++zeroCount;
        }
        if(matrix[height][width] == '3'){
            end = new Cell(height, width);
        }
    }
    
    
    public void printMatrix(){
        System.out.println();
        for(int h=0; h<height; ++h){
            for(int w=0; w<width; ++w){
                System.out.print(matrix[h][w] + " ");
            }
            System.out.println();
        }
    }
    
    public boolean isGood(){
        if(preEnd == null){
            return true;
        }
        Cell cell = preEnd.moveUp(width, height);
        if(cell != null){
            int numberOfOut = cell.getNumberOfOut(matrix);
            if(numberOfOut <= 1 && cell.getStatus(matrix)=='0'){
                return false;
            }
        }
        cell = preEnd.moveDown(width, height);
        if(cell != null){
            int numberOfOut = cell.getNumberOfOut(matrix);
            if(numberOfOut <= 1 && cell.getStatus(matrix)=='0'){
                return false;
            }
        }
        cell = preEnd.moveLeft(width, height);
        if(cell != null){
            int numberOfOut = cell.getNumberOfOut(matrix);
            if(numberOfOut <= 1 && cell.getStatus(matrix)=='0'){
                return false;
            }
        }
        cell = preEnd.moveRight(width, height);
        if(cell != null){
            int numberOfOut = cell.getNumberOfOut(matrix);
            if(numberOfOut <= 1 && cell.getStatus(matrix)=='0'){
                return false;
            }
        }
        return true;
    }
    
    public Status getStatus(){
        if(start.equals(end)){
            if(zeroCount == 0){
                return Status.VALID;
            }else{
                return Status.INVALID;
            }
        }else{
            if(isGood()){
                return Status.RUNNING;
            }else{
                return Status.INVALID;
            }
        }
    } 
    
    public DataCenter moveRight(){
        Cell cell = end.moveRight(width, height);
        return updateAfterMove(cell);
    }

    public DataCenter moveLeft(){
        Cell cell = end.moveLeft(width, height);
        return updateAfterMove(cell);
    }

    public DataCenter moveUp(){
        Cell cell = end.moveUp(width, height);
        return updateAfterMove(cell);
    }

    public DataCenter moveDown(){
        Cell cell = end.moveDown(width, height);
        return updateAfterMove(cell);
    }

    private DataCenter updateAfterMove(Cell cell){
        if(cell != null){
            if(cell.getStatus(matrix) == '0' || cell.getStatus(matrix) == '2'){
                DataCenter dataCenter = (DataCenter)this.clone();
                dataCenter.matrix[cell.getH()][cell.getW()] = '3';
                dataCenter.matrix[end.getH()][end.getW()] = '1';
                --dataCenter.zeroCount;
                dataCenter.preEnd = dataCenter.end;
                dataCenter.end = cell;
                return dataCenter;
            }
            return null;
        }else{
            return null;
        }
    }
    
    protected Object clone(){
        DataCenter dataCenter = new DataCenter(width, height, matrix);
        dataCenter.zeroCount = zeroCount;
        if(preEnd == null){
            dataCenter.preEnd = null;
        }else{
            dataCenter.preEnd = new Cell(preEnd.getH(), preEnd.getW());
        }

        dataCenter.end = new Cell(end.getH(), end.getW());
        dataCenter.start = new Cell(start.getH(), start.getW());
        return dataCenter;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int h=0; h<height; ++h){
            for(int w=0; w<width; ++w){
                stringBuilder.append(matrix[h][w]);
            }
        }
        return stringBuilder.toString();
    }
}
