package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в {repository}")
    public void goToRepository(String repository){
        $(linkText(repository)).click();
    }

    @Step("Открываем Issues")
    public void openIssueTab(){
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем что сушествует Issues с номером {issues_number}")
    public void checkIssueWithNumber(int issues_number){
        $(withText("#" + issues_number)).should(Condition.visible);
    }
}
