package com.loock.thinkmore.jsonandstr;

import org.springside.modules.mapper.JsonMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author loock
 * @date 2020.11.3
 */
public class JsonTransformString {

    public static void main(String[] args) throws IOException {
        String fileName = "/home/wjht/JavaDevelopmentInfo/json.txt";
        FileReader fr = null;
        BufferedReader bf = null;
        try {
            fr = new FileReader(fileName);
            bf = new BufferedReader(fr);

            String jsons = bf.readLine();
            StringBuilder sb = new StringBuilder();
            while (jsons != null){
                sb.append(jsons);
                jsons = bf.readLine();
            }
            //System.out.println(sb);
            JsonMapper jm = new JsonMapper();

            List fromJson = jm.fromJson(sb.toString(), List.class);
            System.out.println(fromJson.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bf.close();
            fr.close();
        }
    }
}
