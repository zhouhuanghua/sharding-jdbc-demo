package cn.zhh.keygen;

import io.shardingsphere.core.keygen.KeyGenerator;

import java.util.UUID;

public class UUIDKeyGenerator implements KeyGenerator {

    @Override
    public Number generateKey() {
        return UUID.randomUUID().hashCode();
    }
}
