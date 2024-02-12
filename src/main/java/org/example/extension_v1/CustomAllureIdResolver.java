package org.example.extension_v1;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

@Slf4j
public class CustomAllureIdResolver implements ArgumentConverter {

    @Override
    public Object convert(Object o, ParameterContext parameterContext) throws ArgumentConversionException {
        var customId = parameterContext.getDeclaringExecutable().toString() + " " + o;
        Allure.getLifecycle().updateTestCase(test -> test.setTestCaseId(String.valueOf(customId.hashCode())));
        log.info("customId " + customId);
        log.info("customId hash " + customId.hashCode());
        return o;
    }
}

