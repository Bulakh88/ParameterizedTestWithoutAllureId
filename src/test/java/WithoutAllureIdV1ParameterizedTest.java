import io.qameta.allure.Allure;
import org.example.extension_v1.CustomAllureId;
import org.example.enums.EventType;
import org.example.enums.UserRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class WithoutAllureIdV1ParameterizedTest {

    @DisplayName("С использованием аннотации @CustomAllureId. ")
    @ParameterizedTest(name = " Участник с ролью {0}")
    @EnumSource(
            value = UserRole.class,
            names = {"USER", "ADMIN"})
    void test1(@CustomAllureId UserRole role) {
        Allure.step("User role: " + role);
    }

    @DisplayName("С использованием аннотации @CustomAllureId. ")
    @ParameterizedTest(name = " Мероприятие с типом {0}")
    @EnumSource(EventType.class)
    void test2(@CustomAllureId EventType type) {
        Allure.step("Event type: " + type);
    }
}
