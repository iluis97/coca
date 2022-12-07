package cn.luis.coca.jackson;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RedisDelayQueue<T> {

    private final String queueKey;

    @Getter
    @Setter
    static class TaskItem<T> {
        public String id;
        public T msg;
    }
}