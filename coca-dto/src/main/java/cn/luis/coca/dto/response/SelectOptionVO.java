package cn.luis.coca.dto.response;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 封装下拉列表数据给前台（适用于VUE）
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 10:07
 */
public class SelectOptionVO<V, E> implements Serializable {

    private static final long serialVersionUID = -4704024739600883285L;

    /**
     * VUE绑定响应数据使用
     */
    private LinkedHashMap<V, String> map;

    /**
     * 组装下拉列表数据
     */
    private List<Option<V>> options;

    /**
     * 携带更多数据一同返回给前端
     */
    private LinkedHashMap<V, E> data;

    public SelectOptionVO() {
    }

    public SelectOptionVO(LinkedHashMap<V, String> map, List<Option<V>> options) {
        this.map = map;
        this.options = options;
    }

    public SelectOptionVO(LinkedHashMap<V, String> map, List<Option<V>> options, LinkedHashMap<V, E> data) {
        this.map = map;
        this.options = options;
        this.data = data;
    }

    public LinkedHashMap<V, String> getMap() {
        return map;
    }

    public SelectOptionVO<V, E> setMap(LinkedHashMap<V, String> map) {
        this.map = map;
        return this;
    }

    public List<Option<V>> getOptions() {
        return options;
    }

    public SelectOptionVO<V, E> setOptions(List<Option<V>> options) {
        this.options = options;
        return this;
    }

    public LinkedHashMap<V, E> getData() {
        return data;
    }

    public SelectOptionVO<V, E> setData(LinkedHashMap<V, E> data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "SelectOptionVo{" +
                "map=" + map +
                ", options=" + options +
                ", data=" + data +
                '}';
    }

    public static class Option<V> {
        private String label;
        private V value;

        public Option() {
        }

        public String getLabel() {
            return label;
        }

        public Option<V> setLabel(String label) {
            this.label = label;
            return this;
        }

        public V getValue() {
            return value;
        }

        public Option<V> setValue(V value) {
            this.value = value;
            return this;
        }

        @Override
        public String toString() {
            return "Option{" +
                    "label='" + label + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

}