package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        if (messageLen%rows==0 && messageLen!=0) {
            return messageLen/rows;
        }else if (messageLen==0) {
            return 1;
        }
        int multiple=1;
        while(messageLen>rows*multiple){
            multiple++;
        }
        return multiple;
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        String [][] newString= new String[rows][determineColumns(message.length(), rows)];
        int idx=0;

        for(int i=0; i<newString.length;i++){
            for(int j=0; j<newString[i].length;j++){
                if(idx<message.length()-1){
                    newString[i][j]=message.substring(idx, idx+1);
                    idx++;
                }else if(idx==message.length()-1){
                    newString[i][j]=message.substring(idx);
                    idx++;
                }
            } 
        } 

        for(int i=0; i<newString.length;i++){
            for(int j=0; j<newString[i].length;j++){
                if (newString[i][j]==null) {
                    newString[i][j]= "=";
                }
            }
        }
        return newString;
    }

    public static String encryptMessage(String message, int rows){
        String [][] msg= generateEncryptArray(message, rows);
        String result= "";
       for(int i=msg[0].length-1; i>=0;i--){
        for(int j=0; j<rows;j++){
            result+=msg[j][i];
        }
       }
        return result;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
    int msgLen=encryptedMessage.length();
     int col=determineColumns(msgLen, rows);
     String [][] msg= new String[rows][col];
     int idx=0;
     for(int i=col-1; i>=0; i--){
        for(int j=0; j<rows;j++){
            if (idx<msgLen) {
                msg[j][i]=encryptedMessage.substring(idx, idx+1);
                idx++;
            }
        }
     }
     String result= new String();
     for(int i=0; i<rows; i++){
        for(int j=0; j<col; j++){
            if (msg[i][j] != null &&!msg[i][j].equals("=")) {
                result+= msg[i][j];
            }
        }
     }
     return result.toString();
    }
}