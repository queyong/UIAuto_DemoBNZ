package com.auto.framework.config;

import com.auto.framework.base.DriverContext;

public class Setting {
    public static int GlobalTimeout = 20;
    public static String DriverPath = "src/main/resources/drivers/";
    public static DriverContext.DriverType DriverType = DriverContext.DriverType.Chrome;
    public static String reportConfigPath = "src/main/java/com/auto/framework/config/extent-config.xml";
}
