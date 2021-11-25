import com.codeborne.selenide.Condition;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.WebSteps;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class IssueStepsAnnotatedTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUES_NUMBER = 68;
    private WebSteps steps = new WebSteps();

    @Owner("GulbisSV")
    @DisplayName("Проверка вкладки Issue")
    @Severity(SeverityLevel.MINOR)
    @Link(name = "GitHub", url = "https://github.com")

    @Test
    public void selenideStepsTest() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.checkIssueWithNumber(ISSUES_NUMBER);

    }
}
