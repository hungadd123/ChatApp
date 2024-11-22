/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap14_chatroom_client;

import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import static sun.security.x509.CertificateAlgorithmId.ALGORITHM;

/**
 *
 * @author hunga
 */
public class KeyManager {
    //TtolmmFr8phWqn9RuznK2AyxMKyy2v5upuD2+ttWtc0=
    private static KeyManager instance;
    private String chuoiKey = "TtolmmFr8phWqn9RuznK2AyxMKyy2v5upuD2+ttWtc0=";
   // private SecretKey key = ()javax.crypto.spec.SecretKeySpec@fffeb76d;
    private byte[] decodedKey = Base64.getDecoder().decode(chuoiKey);

    // Tạo đối tượng SecretKey từ mảng byte
   private SecretKey key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
//     private SecretKey key;
  
    private KeyManager() {
        // Private constructor to prevent instantiation
    }

    public static synchronized KeyManager getInstance() {
        if (instance == null) {
            instance = new KeyManager();
        }
        return instance;
    }

    public SecretKey getKey() {
        return key;
    }

    public void setKey(SecretKey key) {
        this.key = key;
    }
}
