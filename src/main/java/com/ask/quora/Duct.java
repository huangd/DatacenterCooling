package com.ask.quora;


import java.util.concurrent.ConcurrentHashMap;

public class Duct {

    private static ConcurrentHashMap<String, Integer> cache = new ConcurrentHashMap<String, Integer>();

    public int getNumberOfWays(DataCenter dataCenter){
        if(dataCenter ==  null){
            return 0;
        }else if(dataCenter.getStatus()== DataCenter.Status.INVALID){
            return 0;
        }else if(dataCenter.getStatus() == DataCenter.Status.VALID){
            return 1;
        }else if(dataCenter.getStatus() == DataCenter.Status.RUNNING){
            Integer numberOfWays;
            numberOfWays = cache.get(dataCenter.toString());
            if(numberOfWays != null){
                return numberOfWays;
            }else{
                int up = getNumberOfWays(dataCenter.moveUp());
                int down = getNumberOfWays(dataCenter.moveDown());
                int left = getNumberOfWays(dataCenter.moveLeft());
                int right = getNumberOfWays(dataCenter.moveRight());
                numberOfWays = up+down+left+right;
                cache.put(dataCenter.toString(), numberOfWays);
                return numberOfWays;
            }
        }else{
            throw new RuntimeException("Something wrong.");
        }
    }
}
