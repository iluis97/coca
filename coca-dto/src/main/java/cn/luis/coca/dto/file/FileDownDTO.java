package cn.luis.coca.dto.file;

import cn.luis.coca.base.constant.StandardHttpHeaders;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

/**
 * 文件下载实体 可搭配OSS使用
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 10:04
 */
@Setter
@Getter
@ToString
public class FileDownDTO implements Serializable {

    private static final long serialVersionUID = 4926558333503203471L;

    private String fileName;
    private byte[] file;
    private ObjectMetadata objectMetadata;

    public FileDownDTO(String fileName, byte[] file, ObjectMetadata objectMetadata) {
        this.fileName = fileName;
        this.file = file;
        this.objectMetadata = objectMetadata;

    }

    /**
     * 文件元数据 参考 ObjectMetadata
     */
    public static class ObjectMetadata {
        private static final long serialVersionUID = 1L;

        private final Map<String, Object> metadata;

        private final String versionId;


        public ObjectMetadata(Map<String, Object> metadata, String versionId) {
            this.metadata = metadata;
            this.versionId = versionId;
        }

        public String getContentDisposition() {
            return (String) metadata.get(StandardHttpHeaders.CONTENT_DISPOSITION);
        }

        public String getContentType() {
            return (String) metadata.get(StandardHttpHeaders.CONTENT_TYPE);
        }

        public long getContentLength() {
            Long contentLength = (Long) metadata.get(StandardHttpHeaders.CONTENT_LENGTH);

            if (contentLength == null) {
                return 0;
            }
            return contentLength;
        }

        public void setContentEncoding(String encoding) {
            metadata.put(StandardHttpHeaders.CONTENT_ENCODING, encoding);
        }

        public String getVersionId() {
            return versionId;
        }
    }

}