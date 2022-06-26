package com.example.demo.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.example.demo.controller.DemoParams.ID;
import static com.example.demo.controller.DemoParams.USERS;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DemoPaths {

    public static final String BASE_URL = "/";
    public static final String USER_URL = BASE_URL + "user";
    public static final String ID_URL = "{" + ID + "}";

    public static final String PRINCIPAL = "principal";

    public static final String API = "api";

    public static final String BASE_API = BASE_URL + API;

    public static final String GET_USER_URL = BASE_URL + API + BASE_URL + PRINCIPAL;

    public static final String API_URL = BASE_URL + API + BASE_URL + ID_URL;


}
