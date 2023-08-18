package cn.luis.coca.dto.file;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 文件上传实体（用于返回给前台）
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 10:04
 */
@Setter
@Getter
@ToString
public class FileUploadDTO implements Serializable {

    private static final long serialVersionUID = 4926558333503203470L;

    private String id;
    private String fileName;
    private String url;

    public FileUploadDTO() {
    }

    public FileUploadDTO(String id, String fileName, String url) {
        this.id = id;
        this.fileName = fileName;
        this.url = url;
    }

}