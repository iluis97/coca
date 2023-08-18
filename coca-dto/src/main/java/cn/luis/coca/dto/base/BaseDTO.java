package cn.luis.coca.dto.base;

import java.io.Serializable;

/**
 * BaseDTO DTO都来继承，做标识符，避免DTO互相继承
 *
 * @author Lius
 * @since 1.0
 * created 2022/6/7 17:14
 */
public abstract class BaseDTO implements Serializable {

    private static final long serialVersionUID = -4704024739600883215L;

}
