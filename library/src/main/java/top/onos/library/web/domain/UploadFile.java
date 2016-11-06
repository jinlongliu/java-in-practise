package top.onos.library.web.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Created by Liu on 2016/11/7.
 */
public class UploadFile implements Serializable {
    private static final long serialVersionUID = 6941456567344308682L;

    private MultipartFile multipartFile;

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
