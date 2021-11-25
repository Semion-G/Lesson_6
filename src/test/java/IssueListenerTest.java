import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class IssueListenerTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUES_NUMBER = 68;

    @Owner("GulbisSV")
    @DisplayName("Проверка вкладки Issue")
    @Severity(SeverityLevel.MINOR)
    @Link(name = "GitHub", url = "https://github.com")

    @Test
    public void selenideTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());


        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(linkText(REPOSITORY)).click();
        $(partialLinkText("Issues")).click();
        $(withText("#" + ISSUES_NUMBER)).should(Condition.visible);
    }
}
