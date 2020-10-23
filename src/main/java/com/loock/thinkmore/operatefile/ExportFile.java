package com.loock.thinkmore.operatefile;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

public class ExportFile {
    public static void main(String[] args) {

    }
    public void download(HttpServletResponse response, @PathVariable String projectName) throws IOException {
        OutputStream os = response.getOutputStream();
        try {
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("全部信息.xlsx", "utf-8"));
            response.setContentType("application/octet-stream; charset=utf-8");
            //os.write(FileUtils.readFileToByteArray(new File("/home/web/infisa/export/export.xlsx")));
            os.flush();

        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
}

