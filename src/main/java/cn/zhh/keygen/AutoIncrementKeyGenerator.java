package cn.zhh.keygen;

import io.shardingsphere.core.keygen.KeyGenerator;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 自增主键生成器
 */
public class AutoIncrementKeyGenerator implements KeyGenerator {

    private static final AtomicLong KEY_GENERATOR = new AtomicLong(1L);

    @Override
    public Number generateKey() {
        return KEY_GENERATOR.getAndIncrement();
    }
}