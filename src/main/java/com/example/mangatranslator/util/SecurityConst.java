package com.example.mangatranslator.util;

public class SecurityConst {

    // White list
    private static final String STATIC = "/static/**";
    private static final String HOME = "/";
    private static final String REGISTRATION = "/registration";
    private static final String CREATE_USER = "/register/**";
    private static final String FAQ = "/faq";
    private static final String CATALOG = "/catalog/**";
    private static final String RECIPE = "/recipe/**";
    private static final String LOGIN_PROCESS = "/login/**";
    public static final String CREATE_RECIPE_PAGE = "/create/recipe";
    public static final String[] WHITE_LIST_URL = {STATIC,HOME,REGISTRATION,CREATE_USER,LOGIN_PROCESS,CATALOG,RECIPE,FAQ,CREATE_RECIPE_PAGE};

    // Const settings
    public static final String LOGIN = "/login";
    public static final String EMAIL_LOGIN = "email";
    public static final String PASSWORD_LOGIN = "password";
    public static final String HOME_PAGE = "/";



}
