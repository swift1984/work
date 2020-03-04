package com.swift.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App obj = new App();
        System.out.println("iptoLong : " + obj.ipToLong("255.255.255.255.255"));
        System.out.println("longToIp : " + obj.longToIp(1099511627775L));
    }

    public long ipToLong(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");
        long result = 0;
        for(int i=0; i<ipAddressInArray.length; i++) {
            int power = 4 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            System.out.println(ip);
            result += ip * Math.pow(256, power);
        }

        return result;
    }

    public String longToIp(long i) {
        String hexString = Long.toHexString(((i >> 32) & 0xFF)) +
            ":" + Long.toHexString(((i >> 24) & 0xFF)) +
            ":" + Long.toHexString(((i >> 16) & 0xFF)) +
            ":" + Long.toHexString(((i >> 8) & 0xFF)) +
            ":" + Long.toHexString((i & 0xFF));
        
            String ipString = ((i >> 32) & 0xFF) +
            "." + ((i >> 24) & 0xFF) +
            "." + ((i >> 16) & 0xFF) +
            "." + ((i >> 8) & 0xFF) +
            "." + (i & 0xFF);
        return "Hex: " + hexString + "\tString: " + ipString;
    }
}
