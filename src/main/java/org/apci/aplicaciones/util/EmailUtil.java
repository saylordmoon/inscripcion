package org.apci.aplicaciones.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apci.aplicaciones.inscripcion.models.Email;


public class EmailUtil {

   public static void send(Email pEmail) {
   
	   try {
			URL url = new URL("http://desarrollo01:9999/mail");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			OutputStream os = conn.getOutputStream();
			os.write(pEmail.toJSON().getBytes());
			os.flush();

			conn.getResponseCode();
			
			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();
		 }
   }
}