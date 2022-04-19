package pdp.uz.helpers;


import pdp.uz.securtiy.JwtProvider;

import javax.servlet.http.HttpServletRequest;


public class Utils {

    public static String getUsername(HttpServletRequest request) {
        JwtProvider jwtProvider = new JwtProvider();
        String token = request.getHeader("Authorization").substring(7);
        return jwtProvider.getLoginFromToken(token);
    }

}
