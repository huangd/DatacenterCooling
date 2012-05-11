package com.ask.quora;


public class Cell {
    
    private int h;
    private int w;
    
    public Cell(int h, int w){
        this.h = h;
        this.w = w;
    }


    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }
    
    public char getStatus(char[][] matrix){
        return matrix[h][w];
    }
    
    public Cell moveUp(int maxWidth, int maxHeight){
        if(h > 0){
            return new Cell(h-1, w);
        }else{
            return null;
        }
    }

    public Cell moveDown(int maxWidth, int maxHeight){
        if(h < maxHeight-1){
            return new Cell(h+1, w);
        }else{
            return null;
        }
    }

    public Cell moveRight(int maxWidth, int maxHeight){
        if(w < maxWidth-1){
            return new Cell(h, w+1);
        }else{
            return null;
        }
    }

    public Cell moveLeft(int maxWidth, int maxHeight){
        if(w > 0){
            return new Cell(h, w-1);
        }else{
            return null;
        }
    }
    
    public int getNumberOfOut(char[][] matrix){
        int maxWidth = matrix[0].length;
        int maxHeight = matrix.length;
        int numberOfOut = 0;
        Cell cell = moveUp(maxWidth, maxHeight);
        if(cell!=null && (cell.getStatus(matrix)=='0' || cell.getStatus(matrix)=='2')){
            ++numberOfOut;
        }

        cell = moveDown(maxWidth, maxHeight);
        if(cell!=null && (cell.getStatus(matrix)=='0' || cell.getStatus(matrix)=='2')){
            ++numberOfOut;
        }

        cell = moveRight(maxWidth, maxHeight);
        if(cell!=null && (cell.getStatus(matrix)=='0' || cell.getStatus(matrix)=='2')){
            ++numberOfOut;
        }

        cell = moveLeft(maxWidth, maxHeight);
        if(cell!=null && (cell.getStatus(matrix)=='0' || cell.getStatus(matrix)=='2')){
            ++numberOfOut;
        }

        return numberOfOut;
    }
    
    public boolean equals(Object object){
        if(object instanceof Cell){
            Cell cell = (Cell)object;
            if(cell.getH() == h && cell.getW() == w){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
