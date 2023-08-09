package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import source.Constants;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import static org.assertj.core.api.Assertions.*;
import static source.TestEnvironmentConfig.*;

public class StepsDefinitionsCucumber {
    @Given("I open url {string}")
    public void iOpenUrl(String url) {
        getDriver().get(url);
    }

    @Given("I open {string} page")
    public void iOpenSomePage(String page) {
        switch (page) {
            case "Login":
                getDriver().get(Constants.URL_LOGIN);
                break;
            case "Registration":
                getDriver().get(Constants.URL_REGISTRATION);
                break;
            case "Forgot password":
                getDriver().get(Constants.URL_FORGOT_PASSWORD);
                break;
            default:
                System.out.println("\nTHE ERROR: Wrong page \"" + page + "\", double check page name in the cucumber step!\n");
        }
    }

    @Then("I sign in as a {string}")
    public void iSignInAsTheUser(String name) throws InterruptedException {
        switch (name) {
            case "Milan Teacher":
                getDriver().findElement(By.xpath(Constants.FIELD_EMAIL_XPATH)).sendKeys(Constants.MILAN_TEACHER_EMAIL);
                getDriver().findElement(By.xpath(Constants.FIELD_PASSWORD_XPATH)).sendKeys(Constants.MILAN_TEACHER_PASSWORD);
                getDriver().findElement(By.xpath(Constants.BUTTON_SIGN_IN_XPATH)).click();
                break;
            case "Alex Student":
                getDriver().findElement(By.xpath(Constants.FIELD_EMAIL_XPATH)).sendKeys(Constants.ALEX_STUDENT_EMAIL);
                getDriver().findElement(By.xpath(Constants.FIELD_PASSWORD_XPATH)).sendKeys(Constants.ALEX_STUDENT_PASSWORD);
                getDriver().findElement(By.xpath(Constants.BUTTON_SIGN_IN_XPATH)).click();
                break;
            case "volha teacher":
                getDriver().findElement(By.xpath(Constants.FIELD_EMAIL_XPATH)).sendKeys(Constants.VOLHA_TEACHER_EMAIL);
                getDriver().findElement(By.xpath(Constants.FIELD_PASSWORD_XPATH)).sendKeys(Constants.VOLHA_TEACHER_PASSWORD);
                getDriver().findElement(By.xpath(Constants.BUTTON_SIGN_IN_XPATH)).click();
                break;
            case "Diana Brown":
                getDriver().findElement(By.xpath(Constants.FIELD_EMAIL_XPATH)).sendKeys(Constants.DIANA_TEACHER_EMAIL);
                getDriver().findElement(By.xpath(Constants.FIELD_PASSWORD_XPATH)).sendKeys(Constants.DIANA_TEACHER_PASSWORD);
                getDriver().findElement(By.xpath(Constants.BUTTON_SIGN_IN_XPATH)).click();
                break;
            case "Chris":
                getDriver().findElement(By.xpath(Constants.FIELD_EMAIL_XPATH)).sendKeys(Constants.CHRIS_STUDENT_EMAIL);
                getDriver().findElement(By.xpath(Constants.FIELD_PASSWORD_XPATH)).sendKeys(Constants.CHRIS_STUDENT_PASSWORD);
                getDriver().findElement(By.xpath(Constants.BUTTON_SIGN_IN_XPATH)).click();
                break;
            default:
                System.out.println("\nTHE ERROR: User \"" + name + "\" doesn't exist, double check page name in the cucumber step!\n");
        }
        Thread.sleep(1000);
    }

    @Then("^I resize window to (\\d+) and (\\d+)$")
    public void iResizeWindowToAnd(int width, int height) {
        Dimension dimension = new Dimension(width, height);
        getDriver().manage().window().setSize(dimension);
    }

    @Then("^I wait for (\\d+) sec$")
    public void iWaitForSec(int sec) throws Exception {
        Thread.sleep(sec * 1000L);
    }

    @When("^I maximize window$")
    public void iMaximizeWindow() {
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        Dimension maxWindowSize = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
        getDriver().manage().window().setPosition(new Point(0, 0));
        getDriver().manage().window().setSize(maxWindowSize);
    }

    @Then("The element with xpath {string} should be presented")
    public void elementWithXpathShouldBePresented(String xpath) {
        assertThat(getDriver().findElements(By.xpath(xpath))).hasSize(1);
    }

    @Then("^The element with xpath \"([^\"]*)\" should not be presented$") //OLD
    public void elementWithXpathShouldNotBePresent(String xpath) {
        assertThat(getDriver().findElements(By.xpath(xpath))).hasSize(0);
    }

    @Then("^I wait for element with xpath \"([^\"]*)\" to be present$")
    public void iWaitForElementWithXpathToAppear(String xpath) {
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    @Then("^I wait for element with xpath \"([^\"]*)\" to not be present$")
    public void iWaitForElementWithXpathToNotBePresent(String xpath) {
        new WebDriverWait(getDriver(), 10).
                until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))));
    }

    @Then("^element with xpath \"([^\"]*)\" should be displayed$")
    public void elementWithXpathShouldBeDisplayed(String xpath) {
        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();
    }

    @Then("^element with xpath \"([^\"]*)\" should not be displayed$")
    public void elementWithXpathShouldNotBeDisplayed(String xpath) {
        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isFalse();
    }

    @Then("^element with xpath \"([^\"]*)\" should be enabled$")
    public void elementWithXpathShouldBeEnabled(String xpath) {
        assertThat(getDriver().findElement(By.xpath(xpath)).isEnabled()).isTrue();
    }

    @Then("^element with xpath \"([^\"]*)\" should be disabled")
    public void elementWithXpathShouldBeDisabled(String xpath) {
        assertThat(getDriver().findElement(By.xpath(xpath)).isEnabled()).isFalse();
    }

    @Then("^element with xpath \"([^\"]*)\" should be selected$")
    public void elementWithXpathShouldBeSelected(String xpath) {
        assertThat(getDriver().findElement(By.xpath(xpath)).isSelected()).isTrue();
    }

    @Then("^element with xpath \"([^\"]*)\" should not be selected$")
    public void elementWithXpathShouldNotBeSelected(String xpath) {
        assertThat(getDriver().findElement(By.xpath(xpath)).isSelected()).isFalse();
    }

    @When("^I type \"([^\"]*)\" into element with xpath \"([^\"]*)\"$")
    public void iTypeIntoElementWithXpath(String text, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }

    @Then("^I click on element with xpath \"([^\"]*)\"$")
    public void iClickOnElementWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    @Then("^I click on element using JavaScript with xpath \"([^\"]*)\"$")
    public void iClickOnElementUsingJavaScriptWithXpath(String xpath) {
        WebElement element = getDriver().findElement(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    @Then("^I take screenshot$")
    public void iTakeScreenshot() throws Exception {
        TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();
        File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("target/cucumber/screenshot " + new Date() + ".png"));
    }

    @Then("^element with xpath \"([^\"]*)\" should have text as \"([^\"]*)\"$")
    public void elementWithXpathShouldHaveTextAs(String xpath, String text) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).isEqualTo(text);
    }

    @Then("^element with xpath \"([^\"]*)\" should not have text as \"([^\"]*)\"$")
    public void elementWithXpathShouldNotHaveTextAs(String xpath, String text) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).isNotEqualTo(text);
    }

    @Then("^element with xpath \"([^\"]*)\" should contain text \"([^\"]*)\"$")
    public void elementWithXpathShouldContainText(String xpath, String text) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).containsIgnoringCase(text);
    }

    @Then("^element with xpath \"([^\"]*)\" should not contain text \"([^\"]*)\"$")
    public void elementWithXpathShouldNotContainText(String xpath, String text) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).doesNotContain(text);
    }

    @Then("^element with xpath \"([^\"]*)\" should have attribute \"([^\"]*)\" as \"([^\"]*)\"$")
    public void elementWithXpathShouldHaveAttributeAs(String xpath, String attribute, String attributeValue) {
        assertThat(getDriver().findElement(By.xpath(xpath)).getAttribute(attribute)).isEqualTo(attributeValue);
    }

    @Then("^element with xpath \"([^\"]*)\" should not have attribute \"([^\"]*)\" as \"([^\"]*)\"$")
    public void elementWithXpathShouldNotHaveAttributeAs(String xpath, String attribute, String attributeValue) {
        assertThat(getDriver().findElement(By.xpath(xpath)).getAttribute(attribute)).isNotEqualTo(attributeValue);
    }

    @Then("^I switch to iframe with xpath \"([^\"]*)\"$")
    public void iSwitchToIframeWithXpath(String xpath) {
        getDriver().switchTo().frame(getDriver().findElement(By.xpath(xpath)));
    }

    @Then("^I switch to default content$")
    public void iSwitchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }

    @Then("^I switch to new window$")
    public void iSwitchToNewWindow() {
        Iterator<String> iterator = getDriver().getWindowHandles().iterator();
        String newWindow = iterator.next();
        while (iterator.hasNext()) {
            newWindow = iterator.next();
        }
        getDriver().switchTo().window(newWindow);
    }

    @Then("^I switch to first window$")
    public void iSwitchToFirstWindow() {
        getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next());
    }

    @Then("^I accept alert$")
    public void iAcceptAlert() {
        getDriver().switchTo().alert().accept();
    }

    @Then("^I dismiss alert$")
    public void iDismissAlert() {
        getDriver().switchTo().alert().dismiss();
    }

    @When("^I clear element with xpath \"([^\"]*)\"$")
    public void iClearElementWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).clear();
    }

    @Then("^I should see page title as \"([^\"]*)\"$")
    public void iShouldSeePageTitleAs(String title) {
        assertThat(getDriver().getTitle()).isEqualTo(title);
    }

    @Then("^I should see page title as not \"([^\"]*)\"$")
    public void iShouldNotSeePageTitleAsNot(String title) {
        assertThat(getDriver().getTitle()).isNotEqualTo(title);
    }

    @Then("^I should see page title contains \"([^\"]*)\"$")
    public void iShouldSeePageTitleContains(String title) {
        assertThat(getDriver().getTitle()).contains(title);
    }

    @Then("^I should see page title does not contain \"([^\"]*)\"$")
    public void iShouldSeePageTitleDoesNotContain(String title) {
        assertThat(getDriver().getTitle()).doesNotContain(title);
    }

    @Then("^I scroll to the element with xpath \"([^\"]*)\" with offset (\\d+)$")
    public void iScrollToTheElementWithXpathWithOffset(String xpath, int offset) {
        WebElement element = getDriver().findElement(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].scrollIntoView(false);", element);
        executor.executeScript("window.scrollBy(0, " + offset + ");", element);
    }

    @When("^I mouse over element with xpath \"([^\"]*)\"$")
    public void iMouseOverElementWithXpath(String xpath) {
        new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath(xpath))).perform();
    }

    @Then("I move slider {int} step {string} for xpath {string}")
    public void iMoveSliderStepRightForXpath(int numberOfSteps, String direction, String sliderXpath) {
        for (int i = 0; i < numberOfSteps; i++) {
            if (direction.equals("right")) {
                getDriver().findElement(By.xpath(sliderXpath)).sendKeys(Keys.ARROW_RIGHT);
            } else if (direction.equals("left")) {
                getDriver().findElement(By.xpath(sliderXpath)).sendKeys(Keys.ARROW_LEFT);
            } else {
                System.out.println("\nERROR: Unknown direction for slider in the cucumber step\n");
            }
        }
    }
}
