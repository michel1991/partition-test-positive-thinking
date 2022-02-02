package org.example;

import java.util.ArrayList;
import java.util.List;

public class Partition {

    private List takeLastGroup(List<Integer> list, int numberOfElementToTake){
        List lastGroupList = new ArrayList();
        if(numberOfElementToTake > 0){
            int size = list.size();
            int copy = numberOfElementToTake;
            for (int i = 1; i <= numberOfElementToTake ; i++) {
                lastGroupList.add(list.get(size - copy));
                copy--;
            }
        }

        return lastGroupList;
    }

    private List<List> takeAllFirstGroup(List<Integer> list, int restToLoop, int numberOfElementToTake){
        List<List>  allFirstGroups = new ArrayList<>();
        for (int i = 0; i < restToLoop; i+=numberOfElementToTake) {
            List<Integer>  subGroup = new ArrayList<>();
            int copyNumberOfJump = i;
            while(subGroup.size() < numberOfElementToTake){
                subGroup.add(list.get(copyNumberOfJump));
                copyNumberOfJump++;
            }
            allFirstGroups.add(subGroup);

        }
        return  allFirstGroups;
    }



    public List<List> makePartition(List<Integer> list, int numberOfElementPerSubList)  throws IllegalArgumentException
    {
        if(numberOfElementPerSubList <= 0){
            throw new IllegalArgumentException("number of element per list must be positive number");
        }

        if(numberOfElementPerSubList > list.size()){
            throw new IllegalArgumentException("number of element per list is greater than the number of element in list");
        }

        int copyFirstSize = list.size();
        List takeLastGroup = this.takeLastGroup(list, copyFirstSize % numberOfElementPerSubList);
        int restOfElementToCopy = copyFirstSize - (copyFirstSize%numberOfElementPerSubList);
        List<List> listOfPartition = this.takeAllFirstGroup(list, restOfElementToCopy, numberOfElementPerSubList);
        if(takeLastGroup.size() >0 ){
            listOfPartition.add(takeLastGroup);
        }
        return listOfPartition;

    }
}
