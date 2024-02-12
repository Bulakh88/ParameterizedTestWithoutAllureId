package org.example.extension_v1;

import org.junit.jupiter.params.converter.ConvertWith;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@ConvertWith(CustomAllureIdResolver.class)
public @interface CustomAllureId {

}

