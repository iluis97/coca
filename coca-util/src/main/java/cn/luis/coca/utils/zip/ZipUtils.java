package cn.luis.coca.utils.zip;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * 字符串压缩与解压
 *
 * @author luis
 */
public class ZipUtils {

    /**
     * 压缩 （ISO_8859_1）
     *
     * @param text 对字符串压缩
     * @return 返回压缩后的字符串
     */
    public static String compress(String text) {
        if (StringUtils.isBlank(text)) {
            return "";
        }
        // 创建一个新的 byte 数组输出流
        // 使用默认缓冲区大小创建新的输出流
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             GZIPOutputStream gos = new GZIPOutputStream(out)) {
            // 将 b.length 个字节写入此输出流
            gos.write(text.getBytes());
            gos.close(); // 需手动关闭
            // 使用指定的 charsetName，通过解码字节将缓冲区内容转换为字符串
            return out.toString(StandardCharsets.ISO_8859_1.name());
        } catch (IOException e) {
            throw new RuntimeException("compress Error", e);
        }
    }

    /**
     * 字符串的解压
     *
     * @param text 对字符串解压
     * @return 返回解压缩后的字符串
     */
    public static String unCompress(String text) {
        if (StringUtils.isBlank(text)) {
            return "";
        }
        try ( // 创建一个新的 byte 数组输出流
              ByteArrayOutputStream out = new ByteArrayOutputStream();
              // 创建一个 ByteArrayInputStream，使用 buf 作为其缓冲区数组
              ByteArrayInputStream in = new ByteArrayInputStream(text.getBytes(StandardCharsets.ISO_8859_1));
              // 使用默认缓冲区大小创建新的输入流
              GZIPInputStream gis = new GZIPInputStream(in)) {
            byte[] buffer = new byte[256];
            int n = 0;
            // 将未压缩数据读入字节数组
            while ((n = gis.read(buffer)) >= 0) {
                // 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此 byte数组输出流
                out.write(buffer, 0, n);
            }
            // 使用指定的 charsetName，通过解码字节将缓冲区内容转换为字符串
            return out.toString(StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            throw new RuntimeException("unCompress Error", e);
        }
    }

    /**
     * 字符串的压缩: "ISO-8859-1"
     *
     * @param text 待压缩的字符串
     * @return 返回压缩后的字符串
     */
    public static String compressAndBase64Encode(String text) {
        if (StringUtils.isNotBlank(text)) {
            String compress = compress(text);
            // 使用指定的 charsetName，通过解码字节将缓冲区内容转换为字符串
            byte[] encode = Base64.getEncoder().encode(compress.getBytes(StandardCharsets.ISO_8859_1));
            return new String(encode, StandardCharsets.ISO_8859_1);
        }
        return text;
    }

    /**
     * 字符串的解压
     *
     * @param text 对字符串解压
     * @return 返回解压缩后的字符串
     */
    public static String base64DecodeAndUnCompress(String text) {
        if (StringUtils.isBlank(text)) {
            return "";
        }
        // str ISO_8859_1
        byte[] decodeByte = Base64.getDecoder().decode(text);
        try {
            String decompress = unCompress(new String(decodeByte, StandardCharsets.ISO_8859_1));
            return new String(decompress.getBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("base64DecodeAndUnCompress Error", e);
        }
    }

    /**
     * 数据压缩
     */
    public static byte[] compress(byte[] data) throws Exception {
        byte[] output;
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            compress(bais, baos);
            output = baos.toByteArray();
            baos.flush();
        }
        return output;
    }


    public static void compress(InputStream is, OutputStream os) throws Exception {
        try (GZIPOutputStream gos = new GZIPOutputStream(os)) {
            int count;
            byte[] data = new byte[1024];
            while ((count = is.read(data, 0, 1024)) != -1) {
                gos.write(data, 0, count);
            }
            gos.finish();
            gos.flush();
        }
    }

    /**
     * 对数据进行解压缩
     */
    public static byte[] decompress(byte[] data) throws Exception {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            // 解压缩
            decompress(bais, baos);
            data = baos.toByteArray();
            baos.flush();
        }
        return data;
    }

    /**
     * 数据解压缩
     */
    public static void decompress(InputStream is, OutputStream os) throws Exception {
        try (GZIPInputStream gis = new GZIPInputStream(is)) {
            int count;
            byte[] data = new byte[1024];
            while ((count = gis.read(data, 0, 1024)) != -1) {
                os.write(data, 0, count);
            }
        }
    }

    /**
     * 功能:压缩多个文件成一个zip文件
     *
     * @param srcfile：源文件列表
     * @param zipfile：压缩后的文件
     */
    public static void zipFiles(File[] srcfile, File zipfile) throws IOException {
        byte[] buf = new byte[1024];
        //ZipOutputStream类：完成文件或文件夹的压缩
        ZipOutputStream out = new ZipOutputStream(Files.newOutputStream(zipfile.toPath()));
        for (File file : srcfile) {
            FileInputStream in = new FileInputStream(file);
            out.putNextEntry(new ZipEntry(file.getName()));
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.closeEntry();
            in.close();
        }
        out.close();
    }

    /**
     * 功能:解压缩
     *
     * @param zipfile：需要解压缩的文件
     * @param descDir：解压后的目标目录
     */
    public static void unZipFiles(File zipfile, String descDir) throws IOException {
        ZipFile zf = new ZipFile(zipfile);
        for (Enumeration<?> entries = zf.entries(); entries.hasMoreElements(); ) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zf.getInputStream(entry);
            OutputStream out = Files.newOutputStream(Paths.get(descDir + zipEntryName));
            byte[] buf1 = new byte[1024];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
        }
    }

}