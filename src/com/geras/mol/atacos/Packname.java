package com.geras.mol.atacos;

import java.io.File;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
public class Packname {

public static void main(String[] args) {
	boolean x=false;
	try{

		File f = new File(args[0]);
		if(f.exists() && !f.isDirectory()) { 
			System.out.println(args[0]);
			x=true;
		}
		else{
			System.out.println("error is a invalide file or a Directory. I need jar file!");
		}
	}
	catch (Exception e) {

		System.out.println("usage :\njava -jar Packname.jar path_of_file.jar");

	}
	try{
	if (x==true) {		
		JarFile jar =new JarFile(args[0]);

		jar.stream()
		    .map(ZipEntry::getName)
		    .filter(name -> name.endsWith(".class"))
		    .map(name -> name
			.substring(0, name.lastIndexOf('/'))
			.replace('/', '.')
		    )
		    .distinct()
		    .forEach(System.out::println);
		}
	}
	catch (Exception e) {

		System.out.println(e.getMessage());

	}
		
	}

}

