package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

class AppOrderTest {

    private WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
//        driver = new ChromeDriver();
        driver.get("http://localhost:9999/");
    }

    @AfterEach
    void teardown() {
        driver.quit();
        driver = null;
    }

    @Test
    void SuccessTest() {
//        List<WebElement> elements = driver.findElements(By.className("input__control"));
//        elements.get(0).sendKeys("Андрей Юлия");
//        elements.get(1).sendKeys("+79194866677");
//        driver.findElement(By.cssSelector("[type=\"text\"]")).sendKeys("Андрей Иванов-Федоров");
//        driver.findElement(By.cssSelector("[type=\"tel\"]")).sendKeys("+79194866677");
//        driver.findElement(By.className("checkbox")).click();
//        driver.findElement(By.className("button")).click();
//        String text = driver.findElement(By.className("paragraph")).getText();
//        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.",text.trim());
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Иван-Иван Иван");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79145876677");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.",text.trim());

    }
//
//    @Test
//    void allEmptyTest1() {
//        driver.findElement(By.cssSelector("button")).click();
//        String text = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText();
//        assertEquals("Поле обязательно для заполнения",text.trim());
//    }
//
//    @Test
//    void allEmptyTest2() {
//        driver.findElement(By.cssSelector("button")).click();
//        String text = driver.findElement(By.cssSelector("[data-test-id='phone'].input_type_tel .input__sub")).getText();
//        assertEquals("На указанный номер моб. тел. будет отправлен смс-код для подтверждения заявки на карту. Проверьте, что номер ваш и введен корректно.",text.trim());
//    }
//
//    @Test
//    void StartTest2() {
//        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("але");
//        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+7914586677");
//        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
//        driver.findElement(By.cssSelector("button")).click();
//        String text = driver.findElement(By.className("input__sub")).getText();
//        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.",text.trim());
//    }
//
//

}

