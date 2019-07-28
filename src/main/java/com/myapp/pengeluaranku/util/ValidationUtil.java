package com.myapp.pengeluaranku.util;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidationUtil {

    public static final String NUMBER_PATTERN = "\\d+";
    public static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,10}$";
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    public static final String VEHICLE_PATTERN = "^([A-Z]{1,2}\\s[0-9]{1,4}\\s[A-Z]{0,3}|^[A-Z]{1,2}\\s[0-9]{1,4}[A-Z]{0,3})$";
    public static final String DATE_PATTERN = "\\d{4}-\\d{2}-\\d{2}";
    public static final String YEAR_PATTERN = "^[0-9]{4}";
    public static final String STRING_PATTERN = "^[a-zA-Z].*";
    public static final String QR_CODE_PATTERN = "^[a-zA-Z_0-9]{6}";
    public static final String UUID_PATTERN = "^[\\w]{8}-[\\w]{4}-[\\w]{4}-[\\w]{4}-[\\w]{12}";
    public static final String ORDER_ID_PATTERN = "^[\\w]{2}-[\\w]{8}-[\\w]{5}";

    public static boolean isNotEmptyOrNull(Object obj) {
        if(obj == null) return false;
        if(obj instanceof String)
            return !((String) obj).isEmpty();
        else if (obj instanceof Collection)
            return ((Collection<?>) obj).size() != 0;
        return true;
    }

    public static boolean isEmptyOrNull(Object obj) {
        if(obj == null) return true;
        if(obj instanceof String)
            return ((String) obj).isEmpty();
        else if (obj instanceof Collection)
            return ((Collection<?>) obj).size() == 0;
        return false;
    }

    public static boolean regexValidate(String value, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        return matcher.matches();
    }
}
