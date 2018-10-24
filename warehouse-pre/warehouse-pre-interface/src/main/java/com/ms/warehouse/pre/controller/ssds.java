package com.ms.warehouse.pre.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ssds {
	public static void main(String[] args){
        Path path = Paths.get("E:\\银川文档\\应用软件\\宁夏广玉面粉有限公司\\yinchuan-trace\\src\\main\\java\\com\\jiuzhou\\yctrace\\servlet\\FileServlet.java");  
        String contentType = null;  
        try {  
            contentType = Files.probeContentType(path);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        System.out.println("File content type is : " + contentType);   
    }
}
