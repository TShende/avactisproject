package com.avactis.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConfigReader {

	private static Properties pro;
<<<<<<< HEAD
	private static String filepath = "./src/main/resources/";
	private static List<String> files =new ArrayList<String>();
	private static String file_extension = ".properties";
	
	public static void files() {
		
=======
	private static String filepath = "./src/main/resources/properties/";
	private static List<String> files = new ArrayList<String>();
	private static String file_extension = ".properties";

	private static void files() {
>>>>>>> branch 'master' of https://github.com/TShende/avactisproject.git
		File[] filenames = new File(filepath).listFiles();
<<<<<<< HEAD
			for(File file: filenames) {
				if(file.isFile()) {
					files.add(file.getName());
=======
		for (File file : filenames) {
			if (file.isFile()) {
				files.add(file.getName());
>>>>>>> branch 'master' of https://github.com/TShende/avactisproject.git
			}
		}
	}
<<<<<<< HEAD
	
	public static void loadFile(String file){
		 BufferedReader reader;
		 try {
			 reader = new BufferedReader(new FileReader(filepath+file));
			 pro = new Properties();
			 pro.load(reader);
		 		} catch (FileNotFoundException e) {
		 			e.printStackTrace();
		 		} catch (IOException e) {
		 			e.printStackTrace();
		 		}
		
		}
	
	public static String getPropertyWithKey(String Key) throws Exception {
=======

	private static void loadFile(String file) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filepath + file));
			pro = new Properties();
			pro.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getPropertyWithKey(String Key) {
>>>>>>> branch 'master' of https://github.com/TShende/avactisproject.git
		String value = null;
		files();
<<<<<<< HEAD
		for(String file : files){	
			loadFile(file);
			value =pro.getProperty(Key);
			if(value !=null){
=======
		for (String file : files) {
			loadFile(file);
			value = pro.getProperty(Key);
			if (value != null) {
>>>>>>> branch 'master' of https://github.com/TShende/avactisproject.git
				break;
			}
		}
		return value;
<<<<<<< HEAD
=======
	}

	public static String getPropertyfromFile(String filename, String key) {
		String value = null;
		files();
		for (String file : files) {
			String t = filename + file_extension;
			if (t.equalsIgnoreCase(file)) {
				loadFile(file);
				value = pro.getProperty(key);
				if (value != null) {
					break;
				}
			}
		}
		return value;
>>>>>>> branch 'master' of https://github.com/TShende/avactisproject.git
	}
<<<<<<< HEAD
	
	public static String getPropertyfromFile(String filename, String key) throws Exception {
		String value = null;
		files();
		for(String file : files){	
			String t = filename +file_extension;
				if(t.equalsIgnoreCase(file)){
					loadFile(file);
					value =pro.getProperty(key);
					if(value !=null){
						break;
					}
				}
			}
		return value;
	}
	
=======

>>>>>>> branch 'master' of https://github.com/TShende/avactisproject.git
}
