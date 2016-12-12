package com.duwei.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileOprator {
	/**
	 * ��ȡ�ļ����ݵ��ֽ����鲢����
	 * @param filePath	�ļ�·��
	 * @return	�ļ����ֽ�����
	 * @throws IOException 
	 */
	public static byte[] getByteFromFile(String filePath) throws IOException{
		
		File file  = new File(filePath);
		if (!file.exists()) {
			throw new FileNotFoundException();
		}
		
		byte[] b = new byte[(int) file.length()];
		
		FileInputStream in = new FileInputStream(file);
		
		int offset = 0;  
        int numRead = 0;  								//�ֶζ��뻺���ֽ�����
        while (offset < b.length && (numRead = in.read(b, offset, b.length - offset)) >= 0) {  
            offset += numRead;  
        } 
		
     // ȷ���������ݾ�����ȡ  
        if (offset != b.length) {  
        	throw new IOException("Could not completely read file " + file.getName());  
        }  
        in.close();  
        return b;  
		
	}
	
	
	


}
