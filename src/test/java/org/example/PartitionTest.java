package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PartitionTest{
    private List<Integer> listOfValues;
    @Before
    public void setUp() {
        this.listOfValues = new ArrayList<>();
        listOfValues.add(1);
        listOfValues.add(2);
        listOfValues.add(3);
        listOfValues.add(4);
        listOfValues.add(5);
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void makePartitionWithTwoNumberPerSubList() {
        Partition partition = new Partition();
        List<List> actual = partition.makePartition(this.listOfValues, 2);
        List<List> expected = new ArrayList<>();
        List firstSubGroup = new ArrayList<Integer>();
        List secondSubGroup = new ArrayList<Integer>();
        List thirdSubGroup = new ArrayList<Integer>();

        firstSubGroup.add(1);
        firstSubGroup.add(2);


        secondSubGroup.add(3);
        secondSubGroup.add(4);

        thirdSubGroup.add(5);

        expected.add(firstSubGroup);
        expected.add(secondSubGroup);
        expected.add(thirdSubGroup);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void makePartitionWithThreeNumberPerSubList() {
        Partition partition = new Partition();
        List<List> actual = partition.makePartition(this.listOfValues, 3);
        List<List> expected = new ArrayList<>();
        List firstSubGroup = new ArrayList<Integer>();
        List secondSubGroup = new ArrayList<Integer>();

        firstSubGroup.add(1);
        firstSubGroup.add(2);
        firstSubGroup.add(3);


        secondSubGroup.add(4);
        secondSubGroup.add(5);


        expected.add(firstSubGroup);
        expected.add(secondSubGroup);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void makePartitionWithOneNumberPerSubList() {
        Partition partition = new Partition();
        List<List> actual = partition.makePartition(this.listOfValues, 1);
        List<List> expected = new ArrayList<>();
        List firstSubGroup = new ArrayList<Integer>();
        List secondSubGroup = new ArrayList<Integer>();
        List threeSubGroup = new ArrayList<Integer>();
        List fourSubGroup = new ArrayList<Integer>();
        List fiveSubGroup = new ArrayList<Integer>();

        firstSubGroup.add(1);
        secondSubGroup.add(2);
        threeSubGroup.add(3);
        fourSubGroup.add(4);
        fiveSubGroup.add(5);

        expected.add(firstSubGroup);
        expected.add(secondSubGroup);
        expected.add(threeSubGroup);
        expected.add(fourSubGroup);
        expected.add(fiveSubGroup);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    /**
     * Rigorous Test :-)
     */
    @Test(expected = IllegalArgumentException.class)
    public void makePartitionWithNegativeNumberPerSubList() {
        Partition partition = new Partition();
        partition.makePartition(this.listOfValues, -1);
    }

    /**
     * Rigorous Test :-)
     */
    @Test(expected = IllegalArgumentException.class)
    public void makePartitionWithBigNumberPerSubList() {
        Partition partition = new Partition();
        partition.makePartition(this.listOfValues, 7);
    }

}