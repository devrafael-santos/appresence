package com.raffasdev.appresence.shared.util;

import jakarta.servlet.http.HttpServletRequest;

public class RequestUri {
    public static String getBaseUrl(HttpServletRequest request) {
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();

        boolean isDefault = ("http".equals(scheme) && serverPort == 80)
                || ("https".equals(scheme) && serverPort == 443);

        return isDefault
                ? String.format("%s://%s", scheme, serverName)
                : String.format("%s://%s:%d", scheme, serverName, serverPort);
    }
}
