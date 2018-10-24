package uy.com.antel;


import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Assert;

public class hash{

public static void main(String args[]) throws NoSuchAlgorithmException {
        String hash = "W35454B055CC325EA1AF2126E27707052";
        String password = "ILoveJava";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        if (myHash.equals(hash)){
                System.out.println("son iguales");
        }else {
                System.out.println("son distintos");
        }
        //assertThat(myHash,is(equalTo(hash)));
}


}