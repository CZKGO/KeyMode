package com.czk.keymode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CZK on 2017/9/28.
 */

public class KeyMode {

    public static final String DEFAULT_KEYS_DIALER = "DEFAULT_KEYS_DIALER";
    public static final String DEFAULT_KEYS_DISABLE = "DEFAULT_KEYS_DISABLE";
    public static final String DEFAULT_KEYS_SEARCH_GLOBAL = "DEFAULT_KEYS_SEARCH_GLOBAL";
    public static final String DEFAULT_KEYS_SEARCH_LOCAL = "DEFAULT_KEYS_SEARCH_LOCAL";
    public static final String DEFAULT_KEYS_SHORTCUT = "DEFAULT_KEYS_SHORTCUT";

    public List<String> getKeyList() {
        List<String> keyList = new ArrayList<>();
        keyList.add(DEFAULT_KEYS_DISABLE);
        keyList.add(DEFAULT_KEYS_DIALER);
        keyList.add(DEFAULT_KEYS_SEARCH_LOCAL);
        keyList.add(DEFAULT_KEYS_SEARCH_GLOBAL);
        keyList.add(DEFAULT_KEYS_SHORTCUT);
        return keyList;
    }
}
