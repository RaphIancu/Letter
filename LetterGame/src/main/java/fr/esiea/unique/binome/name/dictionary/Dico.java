package fr.esiea.unique.binome.name.dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Raphael
 *
 */

public class Dico {
	private String path;
	
	public Dico(){
		this.path = System.getProperty("user.dir")+"/target/classes/dico.txt";
	}
	
	public Dico(String path) {
		this.path = path;
	}
	
	public boolean motExiste(String mot) {
		try {
			File f = new File(path); 
			BufferedReader bfReader = new BufferedReader(new FileReader(f)); 	
			String line;
			while((line = bfReader.readLine()) != null) { 
				if(line.contains(mot) && line.equals(mot)) {
					bfReader.close();
					return true;
				}
			}
			bfReader.close();
		} catch (IOException e) {
			System.out.println("Erreur en cherchant le mot dans le dico"); 
			e.printStackTrace();
		}		
		System.out.println("Le mot "+mot +" n'est pas dans le dictionnaire");
		return false;
	}

	public ArrayList<String> getMotsDico() {
		File f = new File(path); 
		BufferedReader bfReader;
		ArrayList<String> motsDico = new ArrayList<String>();
		try {
			bfReader = new BufferedReader(new FileReader(f));
			String line;
			while((line = bfReader.readLine()) != null) { 
				motsDico.add(line);
			}
			bfReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return motsDico;
	}
}
