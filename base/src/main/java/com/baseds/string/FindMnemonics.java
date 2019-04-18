package com.baseds.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Compute All mnemonics.
 * 
 * 	Each digit, apart from 0 and 1, in a phone keypad corresponds to one of three
 *	or four letters of the alphabet, as shown in Figure 7.1. Since words are easier to
 *	remember than numbers, it is natural to ask if a 7 or 10-digit phone number can be
 *	represented by a word. For example, “2276696” corresponds to “ACRONYM” as
 *	well as “ABPOMZN”.
 */

public class FindMnemonics {

	static Map<Character,List<Character>> charmap;

	static{

		charmap=new HashMap<>();
		charmap.put('0', null);
		charmap.put('1', null);

		List<Character> temp=new ArrayList<>();
		temp.add('a');
		temp.add('b');
		temp.add('c');
		charmap.put('2', temp);

		temp=new ArrayList<>();
		temp.add('d');
		temp.add('e');
		temp.add('f');
		charmap.put('3', temp);

		temp=new ArrayList<>();
		temp.add('g');
		temp.add('h');
		temp.add('i');
		charmap.put('4', temp);

		temp=new ArrayList<>();
		temp.add('j');
		temp.add('k');
		temp.add('l');
		charmap.put('5', temp);

		temp=new ArrayList<>();
		temp.add('m');
		temp.add('n');
		temp.add('o');
		charmap.put('6', temp);

		temp=new ArrayList<>();
		temp.add('p');
		temp.add('q');
		temp.add('r');
		temp.add('s');
		charmap.put('7', temp);

		temp=new ArrayList<>();
		temp.add('t');
		temp.add('u');
		temp.add('v');
		charmap.put('8', temp);

		temp=new ArrayList<>();
		temp.add('w');
		temp.add('x');
		temp.add('y');
		temp.add('z');
		charmap.put('9', temp);
	}

	public static void main(String[] args) throws Exception {

		String s1="3256";
		System.out.println(computeAllMnemonics(s1));
	}

	/**
	 * 
	 * @param str		input string like "2345" etc.
	 * @return			list containing all the possible mnemonics.		
	 * @throws Exception
	 */
	public static List<String> computeAllMnemonics(String str) throws Exception{

		int n=str.length();
		List<Character>[] listArray=(ArrayList<Character>[])new ArrayList[n];
		List<String> output=new ArrayList<>();

		for(int i=0; i<n; i++){
			List<Character> p=charmap.get(str.charAt(i));
			if(p==null){

				String err="Invalid input";
				throw new Exception(err);
			}

			listArray[i]=p;
		}

		char[] ch=new char[n];
		mnemonicsHelper(listArray, ch, 0, output);

		return output;
	}
	

	private static void mnemonicsHelper(List<Character>[] listArray, char[] ch, int level, List<String> output){
		if(level==ch.length){
			output.add(new String(ch));
			return;
		}

		List<Character> list=listArray[level];
		for(int i=0; i<list.size(); i++){

			ch[level]=list.get(i);
			mnemonicsHelper(listArray, ch, level+1, output);
		}
	}
}
