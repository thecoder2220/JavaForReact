package com.claurier.common.commons.persistence;

import java.net.InetAddress;
import java.util.Random;

public class IdGenerator {
    private static long counterMax = 0;
    private static long counter = counterMax + 1;

    private static void calcCounter() {
        counter = (System.currentTimeMillis() / 1000 & 0x3FFFFFFF) << 33;
        String ip = "127.0.0.1";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        }
        catch (Throwable var1_1) {
            // empty catch block
        }
        counter = ip.equals("127.0.0.1") ? (counter |= ((long)new Random().nextInt(256) & 255) << 25) : (counter |= (Long.parseLong(ip.substring(ip.lastIndexOf(".") + 1)) & 255) << 25);
        counterMax = (counter |= ((long)new Random().nextInt(16) & 15) << 21) + 0x1FFFFF;
    }

    public static synchronized long generate() {
        if (counter > counterMax) {
            IdGenerator.calcCounter();
        }
        return counter++;
    }
}

