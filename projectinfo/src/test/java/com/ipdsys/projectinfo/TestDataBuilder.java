package com.ipdsys.projectinfo;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestDataBuilder {
    private static String YAML_PATH = "src/test/resources/";

    public static <T> T getTestingData(String yamlFile, Class<T> cls) {
        // 读取YAML文件内容
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(YAML_PATH + yamlFile)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 反序列化为testingData对象
        Object testingData = new Yaml().load(content);

        // 类型转换
        return cls.cast(testingData);
    }

}
