package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] result = new byte[4];
        result[0] = (byte)(ip[0] & mask[0]);
        result[1] = (byte)(ip[1] & mask[1]);
        result[2] = (byte)(ip[2] & mask[2]);
        result[3] = (byte)(ip[3] & mask[3]);
        return result;
    }

    public static void print(byte[] bytes) {
        System.out.println(String.format("%8s",Integer.toBinaryString(bytes[0] & 0xFF)).replace(" ", "0") + " " +
                String.format("%8s",Integer.toBinaryString(bytes[1] & 0xFF)).replace(" ", "0") + " " +
                String.format("%8s",Integer.toBinaryString(bytes[2] & 0xFF)).replace(" ", "0") + " " +
                String.format("%8s",Integer.toBinaryString(bytes[3] & 0xFF)).replace(" ", "0"));
    }
}
