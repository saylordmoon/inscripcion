package org.apci.aplicaciones.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	
	public static final String UPLOAD_FILE_SERVER = "c:/tmp/";
	
	public static String writeToFileServer(InputStream inputStream, String fileName) throws IOException {
		 
        OutputStream outputStream = null;
        String qualifiedUploadFilePath = UPLOAD_FILE_SERVER + fileName;
 
        try {
            outputStream = new FileOutputStream(new File(qualifiedUploadFilePath));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally{
            outputStream.close();
        }
        
        return qualifiedUploadFilePath;
    }
	
	public static boolean createDirectory(String pDirectoryName)
	{
		pDirectoryName = UPLOAD_FILE_SERVER + pDirectoryName;
		
		File theDir = new File(pDirectoryName);

		boolean result = false;

		try
		{
			if (theDir.exists()) return true;
			result = theDir.mkdirs();
			
		} 
		catch(SecurityException se)
		{
			System.out.println(se.getMessage());
		}        
		
		return result;
	}

}
