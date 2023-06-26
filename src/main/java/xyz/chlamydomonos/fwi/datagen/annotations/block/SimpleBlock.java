package xyz.chlamydomonos.fwi.datagen.annotations.block;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleBlock {
    enum Type {
        CUBE_ALL,
        CUSTOM_MODEL
    }
    Type type();
}
