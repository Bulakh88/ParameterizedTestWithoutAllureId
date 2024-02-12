import io.qameta.allure.Allure;
import org.example.extension_v1.CustomAllureId;
import org.example.enums.EventType;
import org.example.enums.UserRole;
import org.example.extension_v2.AllureFullName;
import org.example.extension_v2.WithoutAllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static java.lang.String.valueOf;

public class WithoutAllureIdV2ParameterizedTest {

    @DisplayName("С использованием аннотации @WithoutAllureId. ")
    @ParameterizedTest(name = " Участник с ролью {0}")
    @WithoutAllureId()
    @EnumSource(
            value = UserRole.class,
            names = {"MODERATOR", "ADMIN"})
    void test1(UserRole role, @AllureFullName String fullName) {
        Allure.getLifecycle().updateTestCase(
                test -> test.setTestCaseId(valueOf((fullName + " " + role).hashCode())));
        Allure.step("User role: " + role);
    }

    @DisplayName("С использованием аннотации @CustomAllureId. ")
    @ParameterizedTest(name = " Мероприятие с типом {0}")
    @WithoutAllureId()
    @EnumSource(EventType.class)
    void test2(EventType type, @AllureFullName String fullName) {
        Allure.getLifecycle().updateTestCase(
                test -> test.setTestCaseId(valueOf((fullName + " " + type).hashCode())));
        Allure.step("Event type: " + type);
    }
}
