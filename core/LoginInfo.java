package core;

public class LoginInfo {
    private static String username;
    private static String email;
    private static String admin_username;

    public static void setUsername (String name) {
        // System.out.println("set successfully");
        System.out.println(name);
        username = name;
    }

    public static String getUsername() {
        // System.out.println("get successfully");
        // System.out.println(username);
        return username;
    }

    public static void setEmail (String text) {
        email = text;
    }

    public static String getEmail() {
        return email;
    }

    public static void setAdminUsername (String name) {
        admin_username = name;
    }

    public static String getAdminUsername() {
        return admin_username;
    }
}
