/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes;

/**
 *
 * @author Administrator
 */
public class AES {
    public static final String[][] subByteTable = {
        {"63", "7C", "77", "7B", "F2", "6B", "6F", "C5", "30", "01", "67", "2B", "FE", "D7", "AB", "76"},
        {"CA", "82", "C9", "7D", "FA", "59", "47", "F0", "AD", "D4", "A2", "AF", "9C", "A4", "72", "C0"},
        {"B7", "FD", "93", "26", "36", "3F", "F7", "CC", "34", "A5", "E5", "F1", "71", "D8", "31", "15"},
        {"04", "C7", "23", "C3", "18", "96", "05", "9A", "07", "12", "80", "E2", "EB", "27", "B2", "75"},
        {"09", "83", "2C", "1A", "1B", "6E", "5A", "A0", "52", "3B", "D6", "B3", "29", "E3", "2F", "84"},
        {"53", "D1", "00", "ED", "20", "FC", "B1", "5B", "6A", "CB", "BE", "39", "4A", "4C", "58", "CF"},
        {"D0", "EF", "AA", "FB", "43", "4D", "33", "85", "45", "F9", "02", "7F", "50", "3C", "9F", "A8"},
        {"51", "A3", "40", "8F", "92", "9D", "38", "F5", "BC", "B6", "DA", "21", "10", "FF", "F3", "D2"},
        {"CD", "0C", "13", "EC", "5F", "97", "44", "17", "C4", "A7", "7E", "3D", "64", "5D", "19", "73"},
        {"60", "81", "4F", "DC", "22", "2A", "90", "88", "46", "EE", "B8", "14", "DE", "5E", "0B", "DB"},
        {"E0", "32", "3A", "0A", "49", "06", "24", "5C", "C2", "D3", "AC", "62", "91", "95", "E4", "79"},
        {"E7", "C8", "37", "6D", "8D", "D5", "4E", "A9", "6C", "56", "F4", "EA", "65", "7A", "AE", "08"},
        {"BA", "78", "25", "2E", "1C", "A6", "B4", "C6", "E8", "DD", "74", "1F", "4B", "BD", "8B", "8A"},
        {"70", "3E", "B5", "66", "48", "03", "F6", "0E", "61", "35", "57", "B9", "86", "C1", "1D", "9E"},
        {"E1", "F8", "98", "11", "69", "D9", "8E", "94", "9B", "1E", "87", "E9", "CE", "55", "28", "DF"},
        {"8C", "A1", "89", "0D", "BF", "E6", "42", "68", "41", "99", "2D", "0F", "B0", "54", "BB", "16"}
    };
    public static final String [] rcon = {"01","02","04","08","10","20","40","80","1B","36"};
    
    public static String[][] constant = {
            {"02", "03", "01", "01"},
            {"01", "02", "03", "01"},
            {"01", "01", "02", "03"},
            {"03", "01", "01", "02"}
        };
//    String w1 = keyInHexa.substring(0, 8);
//    String w2 = keyInHexa.substring(8,16);
//    String w3 = keyInHexa.substring(16,24);
//    String w4 = keyInHexa.substring(24,32);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //displayArray
        //arrayKey
        //shiftRow
        //SubBytesTransformation
        //rotWord
        //copyMatrix
        //Gfunction
        //==============================================================================================
        //for the plain text
        String plainText = "00041214120412000C00131108231919";
        System.out.println(plainText+", length: "+plainText.length());
        String [][] state = arrayKey(plainText);
        String [][] state_subByted = SubBytesTransformationWord(state);
        String [][] state_subByted_shifted = shiftRow(state_subByted);
        String [][] state_subByted_shifted_Mixed = mixColumns(state_subByted_shifted);
        //==============================================================================================
        //for the key
        //String k = "736174697368636A6973626F72696E67";
        String k = "2B7E151628AED2A6ABF7158809CF4F3C";
        //String k = "5468617473206D79204B756E67204675";
        //String k = "28AED2A6ABF7158809CF4F3C2B7E1516";
        String [][] key= arrayKey(k);
        checkLengthForEachElementIn2DArray(key);
        
        String [] t4 = Gfunction(key, 0);
        String [][] key1 = GeneratKey(key, t4);
        checkLengthForEachElementIn2DArray(key1);
        
        String [] t8 = Gfunction(key1,1);
        String [][] key2 = GeneratKey(key1, t8);
        checkLengthForEachElementIn2DArray(key2);
        
        String [] t12 = Gfunction(key2,2);
        String [][] key3 = GeneratKey(key2, t12);
        checkLengthForEachElementIn2DArray(key3);
        
        String [] t16 = Gfunction(key3,3);
        String [][] key4 = GeneratKey(key3, t16);
        checkLengthForEachElementIn2DArray(key4);
        
        String [] t20 = Gfunction(key4,4);
        String [][] key5 = GeneratKey(key4, t20);
        checkLengthForEachElementIn2DArray(key5);
        
        String [] t24 = Gfunction(key5,5);
        String [][] key6 = GeneratKey(key5, t24);
        checkLengthForEachElementIn2DArray(key6);
        
        String [] t28 = Gfunction(key6,6);
        String [][] key7 = GeneratKey(key6, t28);
        checkLengthForEachElementIn2DArray(key7);
        
        String [] t32 = Gfunction(key7,7);
        String [][] key8 = GeneratKey(key7, t32);
        checkLengthForEachElementIn2DArray(key8);
        
        String [] t36 = Gfunction(key8,8);
        String [][] key9 = GeneratKey(key8, t36);
        checkLengthForEachElementIn2DArray(key9);
        
        String [] t40 = Gfunction(key9,9);
        String [][] key10 = GeneratKey(key9, t40);
        checkLengthForEachElementIn2DArray(key10);
        
        //==============================================================================================
        //displaying key process
        System.out.print("The following is the key: ");
        displayArray(key);
        
        System.out.println("t4 from w3 after G function: "+displayVector(t4));
        System.out.print("Key number 1: ");
        displayArray(key1);
        
        System.out.println("t8 from w7 after G function: "+displayVector(t8));
        System.out.print("Key number 2 ");
        displayArray(key2);
        
        System.out.println("t12 from w11 after G function: "+displayVector(t12));
        System.out.print("Key number 3 ");
        displayArray(key3);
        
        System.out.println("t16 from w11 after G function: "+displayVector(t16));
        System.out.print("Key number 4 ");
        displayArray(key4);
        
        System.out.println("t20 from w11 after G function: "+displayVector(t20));
        System.out.print("Key number 5 ");
        displayArray(key5);
        
        System.out.println("t24 from w11 after G function: "+displayVector(t24));
        System.out.print("Key number 6 ");
        displayArray(key6);
        
        System.out.println("t28 from w11 after G function: "+displayVector(t28));
        System.out.print("Key number 7 ");
        displayArray(key7);
        
        System.out.println("t32 from w11 after G function: "+displayVector(t32));
        System.out.print("Key number 8 ");
        displayArray(key8);
        
        System.out.println("t36 from w11 after G function: "+displayVector(t36));
        System.out.print("Key number 9 ");
        displayArray(key9);
        
        System.out.println("t40 from w11 after G function: "+displayVector(t40));
        System.out.print("Key number 10 ");
        displayArray(key10);
        
        
        //==============================================================================================
        //displaying state process
        System.out.print("The following is the state: ");
        displayArray(state);
        System.out.print("State after applying subByte transformation: ");
        displayArray(state_subByted);
        System.out.print("state after applying shift rows: ");
        displayArray(state_subByted_shifted);
        System.out.print("state after mixing the columns: ");
        displayArray(state_subByted_shifted_Mixed);
    }
    
    
    public static String[][] GeneratKey (String [][] originKey, String [] t4){
        String [][] newKey = new String [4][4];
        for (int i = 0; i < t4.length; i++) {
//            newKey[i][0] = convertingBinaryToHexa_seriesOf4Digits(
//                                XorBinary(
//                                            convertingHexaIntoBinary_setOfDigits(originKey[i][0]),convertingHexaIntoBinary_setOfDigits(t4[i])
//                                )
//                            );
            newKey[i][0] = checkLength(Integer.toHexString(Integer.parseInt(originKey[i][0],16)^Integer.parseInt(t4[i],16)),2);
        }
        for (int i = 0; i < t4.length; i++) {
//            newKey[i][1] = convertingBinaryToHexa_seriesOf4Digits(
//                                XorBinary(
//                                            convertingHexaIntoBinary_setOfDigits(originKey[i][1]),convertingHexaIntoBinary_setOfDigits(newKey[i][0])
//                                )
//                            );
            newKey[i][1] = checkLength(Integer.toHexString(Integer.parseInt(originKey[i][1],16)^Integer.parseInt(newKey[i][0],16)),2);
        }
        for (int i = 0; i < t4.length; i++) {
//            newKey[i][2] = convertingBinaryToHexa_seriesOf4Digits(
//                                XorBinary(
//                                            convertingHexaIntoBinary_setOfDigits(newKey[i][1]),convertingHexaIntoBinary_setOfDigits(originKey[i][2])
//                                )
//                            );
            newKey[i][2] = checkLength(Integer.toHexString(Integer.parseInt(newKey[i][1],16)^Integer.parseInt(originKey[i][2],16)),2);
        }
        for (int i = 0; i < t4.length; i++) {
//            newKey[i][3] = convertingBinaryToHexa_seriesOf4Digits(
//                                XorBinary(
//                                            convertingHexaIntoBinary_setOfDigits(newKey[i][2]),convertingHexaIntoBinary_setOfDigits(originKey[i][3])
//                                )
//                            );
            newKey[i][3] = Integer.toHexString(Integer.parseInt(newKey[i][2],16)^Integer.parseInt(originKey[i][3],16));
        }
        return newKey;
    }
    public static String [] Gfunction (String [][] Originkey,int Rcon){
        //System.out.print("After Applying rotWord on word0 at Key 1: ");
        //displayMatrix(key1);
        //System.out.print("After Applying s-box transformaton on word0 at Key 1: ");
        String [][] key1 = rotWord(copyMatrix(Originkey));
        SubBytesTransformationWord(key1);
        //displayMatrix(key1);
        //System.out.print("After Applying Xor with 01 on word0 at Key 1: ");
        XorWithRcon(key1,Rcon);
        //displayMatrix(key1);
        String [] w = new String [4];
        for (int i = 0; i < w.length; i++) {
            w[i] = key1[i][3];
        }
        return w;
    }
    public static void XorWithRcon (String [][] key, int indexOfRconElement){
            key [0][3] = checkLength(Integer.toHexString(Integer.parseInt(key[0][3],16)^Integer.parseInt(rcon[indexOfRconElement],16)),2);
            //key[0][3] = convertingBinaryToHexa_seriesOf4Digits(XorBinary(Integer.toBinaryString(Integer.parseInt(key[0][3],16)),Integer.toBinaryString(Integer.parseInt(rcon[indexOfRconElement],16))));
            //return Integer.toHexString(Integer.parseInt(XorBinary(Integer.toBinaryString(Integer.parseInt(key[0][3],16)),Integer.toBinaryString(Integer.parseInt(rcon[indexOfRconElement],16)))));
            //return Integer.toHexString(Integer.parseInt("F3",16)^Integer.parseInt("01",16));
    }
    public static String[][] SubBytesTransformationWord(String [][] state){
        for (int i = 0; i<state.length;i++){
                String element = state[i][3];
                int row = Integer.parseInt(element.charAt(0)+"",16);
                int column = Integer.parseInt(element.charAt(1)+"",16);
                state[i][3] = subByteTable[row][column];
        }
        return state;
    }
    public static String[][] rotWord (String [][] w0){
        String el0 = w0[0][3];
        for (int i = 1; i< w0[3].length;i++){
            w0[i-1][3] = w0[i][3];
        }
        w0[3][3] = el0;
        return w0;
    }   
    //these method are for plain text
    public static String[][] mixColumns (String [][]state){
        String [][]mixColumns = new String [4][4];
        String multiTwoNumbers = "";
        String addition = "00";
        for (int i = 0; i < 4;i++){
            
            for (int j = 0; j < 4; j++){
                
                for (int k = 0; k<4;k++){
                    if ("01".equals(constant[j][k]) || "02".equals(constant[j][k])){
                        multiTwoNumbers = Integer.toBinaryString(Integer.parseInt(constant[j][k],16)*Integer.parseInt(state[k][i],16));
                    }else{
                        String inBinary = Integer.toBinaryString(Integer.parseInt(state[k][i],16));
                        while (inBinary.length()<8){
                            inBinary = "0"+inBinary;
                        }
                        String shifted = inBinary+"0";
                        multiTwoNumbers = Integer.toBinaryString((Integer.parseInt(shifted,2))^Integer.parseInt(state[k][i],16));
                    }
                    multiTwoNumbers = checkMultiplicationLength(multiTwoNumbers);
                    addition = Integer.toHexString(Integer.parseInt(addition,16)^Integer.parseInt(multiTwoNumbers,16));
                }
                mixColumns[j][i] = checkLength(addition,2);
                addition = "00";
            }
            
        }
        
        return mixColumns;
    }
    public static String checkMultiplicationLength(String mul){ 
        if (mul.length()<9){
            mul = Integer.toHexString(Integer.parseInt(mul,2));
            return mul;
        }else{
            String ans;
            mul = mul.substring(1);
            ans = Integer.toHexString(Integer.parseInt("00011011",2)^Integer.parseInt(mul,2));
            return ans;
        }
    }
    public static String[][] shiftRow (String [][] state){
        String [][] shiftedstate = new String [state.length][state[0].length];
        for (int i = 0;i < shiftedstate.length;i++){
            for (int j = 0;j<shiftedstate[i].length;j++){
                shiftedstate[i][j] = state[i][j];
            }
        }
        shiftedstate[1] = new String[]{shiftedstate[1][1],shiftedstate[1][2],shiftedstate[1][3],shiftedstate[1][0]};
        shiftedstate[2] = new String[]{shiftedstate[2][2],shiftedstate[2][3],shiftedstate[2][0],shiftedstate[2][1]};
        shiftedstate[3] = new String[]{shiftedstate[3][3],shiftedstate[3][0],shiftedstate[3][1],shiftedstate[3][2]};
        
        return shiftedstate;
    }
    //the following method are commone in use
    public static String [][] arrayKey (String key){
        String [][] arr = new String [4][4];
        
        for (int i = 0, k = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[j][i] = key.substring(k, k+2);
                k+=2;
            }
        }
        return arr;
    }
    public static void displayArray (String [][] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
        }
        System.out.println();
    }
    public static String[][] copyMatrix(String [][] origin){
        String newMatrix [][] = new String [origin.length][origin[0].length];
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin[i].length; j++) {
                newMatrix[i][j] = origin[i][j];
            }
        }
        return newMatrix;
    }
    public static String displayVector(String [] vec){
        String v = "";
        for (int i = 0; i < vec.length; i++) {
            v +=" "+vec[i]; 
        }
        return v;
    }
    public static String checkLength(String x, int k){
        while (x.length()<k){
            x = "0"+x;
        }
        return x;
    }
    public static void checkLengthForEachElementIn2DArray(String [][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = checkLength(arr[i][j],2);
            }
        }
    }
}
