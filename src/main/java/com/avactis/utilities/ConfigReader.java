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
	private static String filepath = "./src/main/resources/";
	private static List<String> files =new ArrayList<String>();
	private static String file_extension = ".properties";
	
	public static void files() {
		
	File[] filenames = new File(filepath).listFiles();
			for(File file: filenames) {
				if(file.isFile()) {
					files.add(file.getName());
				}
			}
	}

	
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
		String value = null;
		files();
		for(String file : files){	
			loadFile(file);
			value =pro.getProperty(Key);
			if(value !=null){
				break;
			}
		}
		return value;

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


}
