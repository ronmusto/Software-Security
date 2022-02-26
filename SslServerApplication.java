package com.snhu.sslserver;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}
@RestController
class ServerController{
    @RequestMapping("/hash")
    public String myHash(){
    StringBuilder sb = new StringBuilder();
   
    try {
MessageDigest md = MessageDigest.getInstance("SHA-256");
    String data = "Renaldo Musto's Project!";    
    byte[] messageDigest = md.digest(data.getBytes());
       
    for(byte b : messageDigest) {
    sb.append(String.format("%02x", b));
    }
   
       return "<p>data:"+ data + "<p>SHA-256 Cipher Algorithm Used. CheckSum Value: "+ sb;              
       
} catch (NoSuchAlgorithmException e) {
//Auto-generated catch block
e.printStackTrace();
return null;
}

    }
}