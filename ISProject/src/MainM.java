package crypto;


import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class Main {
public static void main(String []args) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, IOException, InvalidKeySpecException {

	
 
	File file =new File("C:\\Users\\Mohammed\\Desktop\\wordlist.txt");
	FileWriter WRITE=new FileWriter("C:\\Users\\Mohammed\\Desktop\\output.txt");
	Scanner scan =new Scanner(file);
	
	
	while(scan.hasNextLine()){
	String KEY=scan.nextLine();
	String pound="#";
	 if(KEY.length()>16)
		KEY="abc";
	while(KEY.length()<16) 
		KEY+=pound;
	
	
        String IV="aabbccddeeff00998877665544332211";
        String PlainText=seedLab.decrypt("764aa26b55a4da654df6b19e4bce00f4ed05e09346fb0e762583cb7da2ac93a2",seedLab.toHex(KEY),IV,"AES/CBC/NoPadding");
	
	WRITE.write(PlainText+"=====> KEY:"+KEY+"\n");
	  
	
	}
   

}



}	
public class seedLab {
	
	public static String decrypt(String cipherText, String key,String IV,String algorithm)//from bealdung 
                throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		
			byte[] keyByte = HexStringToByteArray(key);	    
			SecretKeySpec secretKey = new SecretKeySpec(keyByte,"AES");
	        IvParameterSpec ivparameterspec = new IvParameterSpec(HexStringToByteArray(IV));
	        Cipher cipher = Cipher.getInstance(algorithm);
	        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivparameterspec);
	        byte[] plainText = cipher.doFinal(HexStringToByteArray(cipherText));
	        return new String(plainText);
	        
	    }
	public static byte[] HexStringToByteArray(String s) //from STACKOVERFLOW
        {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)+ Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
        
        public static String toHex(String arg)// from geeksforgeeks
        {
	
    return String.format("%2x", new BigInteger(1, arg.getBytes()));
 }
	
}
	

	
