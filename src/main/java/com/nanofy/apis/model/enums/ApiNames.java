package com.nanofy.apis.model.enums;

import java.util.Arrays;
import java.util.List;

public enum ApiNames {
    REGISTER_CLIENT("register client","/users"),
    LOGIN("login","/users/sessions"),
    LIST_USERS("user list","/users"),
    LIST_ALBUMS("albums list","/albums"),
    LIST_PHOTOS("list photos","/albums/{idAlbum}/photos"),
    LIST_PURCHASED_ALBUMS("list purchased albums","/users/{idUser}/albums") ,
    BUY_ALBUM("buy album","/albums/{idAlbum}"),
    INVALIDATE_SESSIONS("session invalidation","/users/sessions/invalidate_all") ;


private String name;
    private String path;

    private ApiNames(String name, String path) {
        this.name = name;
        this.path = path;
    }
    public String getName() {
        return name;
    }
    public String getPath() {
        return path;
    }
    public static ApiNames get(String name) {
        ApiNames[] paths = ApiNames.values();
        List<ApiNames> pathsList = Arrays.asList(paths);
        for(ApiNames path: pathsList) {
            if(path.getName().equals(name))
                return path;
        }
        return null;
    }
}
