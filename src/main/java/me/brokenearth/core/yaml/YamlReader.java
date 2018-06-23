package me.brokenearth.core.yaml;

import com.sun.istack.internal.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

/**
 * Copyright 2018 github.com/BrokenEarthDev
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 *
 * @author BrokenEarth // BrokenEarthDev
 * @version 1.0
 * @see YamlConfiguration
 * @see YamlWriter
 */
public class YamlReader {
    /**
     * The map that stores key entries
     */
    private Map<String, Object> map;
    /**
     * The yaml file
     */
    private File file;
    /**
     * A file reader
     */
    private FileReader fileReader;
    YamlReader(@NotNull YamlConfiguration config) {
        this.file = config.getFile();
        try {
            this.fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.map = config.getWriter().map;
        if (!config.getWriter().saved) getContents().clear();
    }
    /**
     * Gets the object from a specified path
     * @param path the path of the object
     * @return the object found
     */
    public Object get(@NotNull String path) {
        return getContents().get(path);
    }
    /**
     * Gets the integer from a specified path
     * @param path the path of the integer
     * @return the integer found
     */
    public int getInt(@NotNull String path) {
        return (Integer) getContents().get(path);
    }
    /**
     * Gets the boolean from a specified path
     * @param path the path of the boolean
     * @return the boolean found
     */
    public boolean getBoolean(@NotNull String path) {
        return (Boolean) getContents().get(path);
    }
    /**
     * Gets the long from a specified path
     * @param path the path of the long
     * @return the long found
     */
    public long getLong(@NotNull String path) {
        return (Long) getContents().get(path);
    }
    /**
     * Gets the short from a specified path
     * @param path the path of the short
     * @return the short found
     */
    public short getShort(@NotNull String path) {
        return (Short) getContents().get(path);
    }
    /**
     * Gets the byte from a specified path
     * @param path the path of the byte
     * @return the byte found
     */
    public byte getByte(@NotNull String path) {
        return (Byte) getContents().get(path);
    }
    /**
     * Gets the contents in the yaml file
     * @return the contents
     */
    public Map<String, Object> getContents() {
        return map;
    }
}
