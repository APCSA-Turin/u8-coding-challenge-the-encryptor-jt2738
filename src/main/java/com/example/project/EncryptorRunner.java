package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;
public class EncryptorRunner{
    public static void main(String[] args) {
        String encryptedMessage = "aegs rniu ihoedtyra ";
        int rows = 4;
        String actualDecrypted = Encryptor.decryptMessage(encryptedMessage, rows);
        // int rows = 4;
        // String [][] result= Encryptor.generateEncryptArray(message, rows);
        // for(int i=0; i<result.length;i++){
        //     for(int j=0; j<result[i].length;j++){
        //         System.out.print(result[i][j]);
        //     }
        //     System.out.println();
        // }
        System.out.println(actualDecrypted);
    }
}