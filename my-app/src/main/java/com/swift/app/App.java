package com.swift.app;

import java.util.regex.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App obj = new App();
        //System.out.println("iptoLong : " + obj.ipToLong("255.255.255.255.255"));
        //System.out.println("longToIp : " + obj.longToIp(1099511627775L));
        String EXAMPLE_TEST = "{   objectFullName: svc-mgr:service-1047:36.36.36.36,   objectFullName: svc-mgr:service-1047:36.36.36.36:interface-lag_1-inner-tag-4095-outer-tag-2002,   objectFullName: svc-mgr:service-1047:36.36.36.36:interface-1/1/5-inner-tag-0-outer-tag-2002,   objectFullName: svc-mgr:service-1047:36.36.36.36:interface-lag_1-inner-tag-4095-outer-tag-2002:svc-21port-1342177281encap-268371922,   objectFullName: svc-mgr:service-1047:36.36.36.36:interface-1/1/5-inner-tag-0-outer-tag-2002:svc-21port-35815424encap-2002   }";
        //System.out.println(EXAMPLE_TEST);
        //Pattern pattern = Pattern.compile("objectFullName:([\\w- :.]+)");
        Pattern pattern = Pattern.compile("objectFullName:([\\w- .]+):(service-[0-9]*:).*(interface-lag).*(inner-tag).*(outer-tag).*");
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
        while (matcher.find()) {
            System.out.println("Start index: " + matcher.start());
            System.out.println("End index: " + matcher.end());
            System.out.println(matcher.group());
        }
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
