import com.codeborne.selenide.Condition;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class IssueLambdaTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUES_NUMBER = 68;

    @Owner("GulbisSV")
    @DisplayName("Проверка вкладки Issue")
    @Severity(SeverityLevel.MINOR)
    @Link(name = "GitHub", url = "https://github.com")

    @Test
    public void selenideListenerTest() {

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим в  " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверяем что сушествует Issues с номером " + ISSUES_NUMBER, () -> {
            $(withText("#" + ISSUES_NUMBER)).should(Condition.visible);
        });
    }
}
