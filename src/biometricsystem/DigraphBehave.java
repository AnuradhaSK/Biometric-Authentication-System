/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricsystem;

import java.util.ArrayList;

/**
 *
 * @author Anuradha
 */
public class DigraphBehave {
    
    public static ArrayList<Digraph> createDigraphs(String phrase, ArrayList<Character> chars){
		
		ArrayList<Digraph> digraphs = new ArrayList<Digraph>();
		
		for(int i = 0 ; i<phrase.trim().length()-1; i++){
			Digraph digraphone = new Digraph(phrase.charAt(i),'^',0);
			Digraph digraphtwo = new Digraph(phrase.charAt(i),phrase.charAt(i+1),0);
			
			digraphs.add(digraphone);
			digraphs.add(digraphtwo);
		}
		
		digraphs.add(new Digraph(phrase.charAt(phrase.trim().length()-1),'^',0));
		
		return computeDelay(digraphs,chars);
	}
    
    private static ArrayList<Digraph> computeDelay(ArrayList<Digraph> digraphs, ArrayList<Character> chars) {
		
		int count = 1;
		for(int i = 0 ; i < digraphs.size() ; i++){
			
			if(i%2 == 0){
				
				long delay = chars.get(i/2).getReleasedTime() - chars.get(i/2).getPressedTime() ; 
				digraphs.get(i).setDelay(delay);
			} else {
				
				long delay = chars.get(i-count+1).getPressedTime() - chars.get(i-count).getReleasedTime(); 
				digraphs.get(i).setDelay(delay);
				count++;
				
			}
		}
		
		
		return digraphs;
	}
    
    public static ArrayList constructMeanList(ArrayList<ArrayList<Digraph>> learndata){
		System.out.println("Computing meantime");
		ArrayList<Double> meanTime;
                meanTime = new ArrayList<Double>();
		for(int i = 0; i < learndata.get(0).size(); i++){
			double meantime = 0;
                        double sumOfX=0;
			
			for(int j = 0 ; j <learndata.size(); j++){
				
				sumOfX += learndata.get(j).get(i).getDelay();
			}
			
			meantime = sumOfX / learndata.size();
			meanTime.add(meantime);
		}
		System.out.println(learndata.size());
		return meanTime;
	}
    
}
