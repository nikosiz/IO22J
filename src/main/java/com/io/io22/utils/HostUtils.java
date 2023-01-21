package com.io.io22.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostUtils {

    public static String getHostAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }
}
