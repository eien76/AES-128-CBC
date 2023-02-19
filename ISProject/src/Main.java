

//I will explain every step with a comment

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.BadPaddingException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.SealedObject;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Scanner;
public class Main {
	//this method is very important to converet any method such as "hello" to hexa value because we will use the key plain text and also the iv as a hexa to encrypt(got it from stackoverflow)
	public static String StringtoHexValue(String arg) {
		
	    return String.format("%2x", new BigInteger(1, arg.getBytes()));
	}
	
	
	public static void main(String []args)
		throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException
		,IllegalBlockSizeException, IOException, InvalidKeySpecException{

		//Initialize the file reader, file writer and scanner
	String Thekey = null;
	File file =new File("C:\\Users\\Abdullah\\Desktop\\Project\\WordsList.txt");
	FileWriter writer=new FileWriter("C:\\Users\\Abdullah\\Desktop\\Project\\EncryptedText.txt");
	Scanner scan =new Scanner(file);
	
	//This nested while loop is to append # after the word to complete the 16 byte and print all the words as keys to show you doctor how the keys became but the resault will be in the EncryptedText.txt file.
	while(scan.hasNextLine()) {
	Thekey=scan.nextLine();
	String pound="#";
	 if(Thekey.length()>16)
			Thekey="Discarded";
	while(Thekey.length()<16) 
		Thekey+=pound;
    System.out.println(Thekey); 
    writer.write(Enc.encrypts(StringtoHexValue("This is a top secret."),StringtoHexValue(Thekey),"aabbccddeeff00998877665544332211")+" The Used Key is: "+Thekey+"\n");	  
    
	}
}
}
	

	
