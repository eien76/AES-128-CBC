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
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
public class Enc {
	
//After several tries i gained experiance and and created this method i used some projects to learn how but i didn't copy it i created it
			public static String encrypts(String input, String key,String iv)
	        throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
	        InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
		    byte[] keyByte = HexStringToByteArray(key);	//convert the hex value to byte array( i converted the key to hex before in the main) 
			SecretKeySpec TheKey = new SecretKeySpec(keyByte,"AES");//specify the key to the AES
	        IvParameterSpec IV = new IvParameterSpec(HexStringToByteArray(iv));//creating the initial value by converting hexa string to byte array
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");//identify the algorithm and the mod and the padding
	        cipher.init(Cipher.ENCRYPT_MODE,TheKey,IV);//encrypt
	        byte[] cipherText = cipher.doFinal(HexStringToByteArray(input));//convert bytes
	        return Base64.getEncoder().encodeToString(cipherText);    //convert to base 64
	    }
			
			//this method is very important also to convert a string as hexa such as "aaee11" to byte value(got it from stackoverflow)
			public static byte[] HexStringToByteArray(String s) {
			    int len = s.length();
			    byte[] data = new byte[len / 2];
			    for (int i = 0; i < len; i += 2) {
			        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
			                             + Character.digit(s.charAt(i+1), 16));
			    }
			    return data;
			}
}
