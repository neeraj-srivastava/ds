package com.baseds.dp;

import java.util.ArrayList;

/*
 * Write a method to compute power-set of a set.
 */
public class PowerSet {

	public static void main(String[] args) {
		
		ArrayList<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list);
		
		System.out.println(getPowerSet(list));

	}
	
	/**
	 * @param inputList		set of elements in the form of list
	 * @return				power set of given list
	 */
	public static <T extends Comparable<T>> ArrayList<ArrayList<T>> getPowerSet(final ArrayList<T> inputList){
		ArrayList<ArrayList<T>> setList=new ArrayList<>();
		
		System.out.println("inputList:"+inputList);
		for(T e:inputList){
			
			ArrayList<ArrayList<T>> powerSetList=new ArrayList<>();
			ArrayList<T> elementSet=new ArrayList<>();
			elementSet.add(e);
			powerSetList.add(elementSet);
			
			System.out.println("adding one more element:"+elementSet);
			
			ArrayList<T> p=null;
			for(int i=0; i<setList.size(); i++){
				p=new ArrayList<>(setList.get(i));
				p.add(e);
				powerSetList.add(p);
			}
			
			System.out.println("PowerSetList:"+powerSetList);
			setList.addAll(powerSetList);
		
		}
		return setList;
	}
}
