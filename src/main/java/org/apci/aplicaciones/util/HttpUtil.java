package org.apci.aplicaciones.util;

public class HttpUtil {

	public static enum StatusCode {
		
		OK(200),
		CREATED(201),
		NO_CONTENT(204),
		UNAUTHORIZED(401);
	
		private int value;
 
		private StatusCode(int value) {
                this.value = value;
        }
     
        public int value(){
        	return value;
        }
	}
}
