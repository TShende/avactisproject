package com.avactis.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConfigReader {

	static Properties pro;
	static String filepath = "./src/main/resources/";
	static List<String> files =new ArrayList<String>();
	static String file_extension = ".property";
	
	public static void filename() {
		
		File[] filenames = new File(filepath).listFiles();
		for(File file: filenames) {
			if(file.isFile()) {
				files.add(file.getName());
			}
		}
	}
	
	public static void filereader(String file) throws Exception
	{
		 BufferedReader reader;
		 reader = new BufferedReader(new FileReader(filepath+file));
		 pro = new Properties();
		pro.load(reader);
	}
	public static String getPropertyWithKey(String Key) throws Exception {
		String value = null;
		filename();
		for(String file : files)
		{	
			filereader(file);
			value =pro.getProperty(Key);
			if(value !=null)
			{
				break;
			}
		}
		return value;
		}
	public static String getPropertyfromFile(String filename, String key) throws Exception {
		String value = null;
		filename();
		for(String file : files)
		{	
			String t = filename +file_extension;
			if(t.equalsIgnoreCase(file))
			{
			filereader(file);
			value =pro.getProperty(key);
			if(value !=null)
			{
				break;
			}
			}
		}
		return value;
	}
	
	}
