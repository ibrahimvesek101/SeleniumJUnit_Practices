package Practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Practice0001 {

        /*
       1. Launch browser
       2. Navigate to url 'http://automationexercise.com'
       3. Verify that home page is visible successfully
       4. Click on 'Signup / Login' button
       5. Verify 'New User Signup!' is visible
       6. Enter name and email address
       7. Click 'Signup' button
       8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
       9. Fill details: Title, Name, Email, Password, Date of birth
       10. Select checkbox 'Sign up for our newsletter!'
       11. Select checkbox 'Receive special offers from our partners!'
       12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
       13. Click 'Create Account button'
       14. Verify that 'ACCOUNT CREATED!' is visible
       15. Click 'Continue' button
       16. Verify that 'Logged in as username' is visible
       17. Click 'Delete Account' button
       18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    WebDriver driver=new ChromeDriver();
    //1. Launch browser
    @Before
    public void setup(){
        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

        //    @After
//    public void tearDown(){
//        driver.close();
//    }

    //2. Navigate to url 'http://automationexercise.com'
    @Test
    public void test01(){
        driver.get("https://www.automationexercise.com/");

        //3. Verify that home page is visible successfully
        WebElement homepage = driver.findElement(By.xpath("//a[contains(.,'Home')]"));
        Assert.assertTrue("Homepage is visible", homepage.isDisplayed());

        // 4. Click on 'Signup / Login' button
        WebElement signUpButton = driver.findElement(By.xpath("//a[@href='/login']"));
        signUpButton.click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUser= driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        // WebElement newUserSignUp = driver.findElement(By.cssSelector("div[class='signup-form'] h2"));
        Assert.assertTrue("New User signup is displayed", newUser.isDisplayed());

        //6. Enter name and email address
        WebElement nameInput = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        nameInput.sendKeys("lyvybeni");
        WebElement emailInput = driver.findElement(By.xpath("//div[@class='signup-form']//input[@name='email']"));
        emailInput.sendKeys("lyvymai@kellychibale-researchgroup-uct.com");

        // 7. Click 'Signup' button
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit'][@data-qa='signup-button']"));
        submitButton.click();

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInfoText = driver.findElement(By.xpath("//b[.='Enter Account Information']"));
        // WebElement information = driver.findElement(By.xpath("//b[contains(.,'Account')]"));
        Assert.assertTrue("Enter account is displayed",enterAccountInfoText.isDisplayed());

        //   9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement genderSelection = driver.findElement(By.xpath("//input[@value='Mr']"));
        genderSelection.click();
        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        password.sendKeys("123456");
        WebElement dayOfBirth = driver.findElement(By.id("days"));
        dayOfBirth.click();
        dayOfBirth.sendKeys("1");
        WebElement monthOfBirth = driver.findElement(By.id("months"));
        monthOfBirth.click();
        monthOfBirth.sendKeys("April");
        WebElement yearOfBirth = driver.findElement(By.id("years"));
        yearOfBirth.click();
        yearOfBirth.sendKeys("2000");

        //  10. Select checkbox 'Sign up for our newsletter!'
        // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstNameInput = driver.findElement(By.id("first_name"));
        firstNameInput.sendKeys("zakkoburki");
        WebElement lasttNameInput = driver.findElement(By.id("last_name"));
        lasttNameInput.sendKeys("somename");
        WebElement companyInput = driver.findElement(By.id("company"));
        companyInput.sendKeys("apple");
        WebElement address01Input = driver.findElement(By.id("address1"));
        address01Input.sendKeys("California");
        WebElement address02Input = driver.findElement(By.id("address2"));
        address02Input.sendKeys("mountainview");
        WebElement country = driver.findElement(By.id("country"));
        country.click();
        country.sendKeys("Canada");
        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("Arizona");
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Washington");
        WebElement zipCode = driver.findElement(By.id("zipcode"));
        zipCode.sendKeys("654987");
        WebElement mobileNumber = driver.findElement(By.id("mobile_number"));
        mobileNumber.sendKeys("987644");

        //     13. Click 'Create Account button'
        //   14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement createAccountButton = driver.findElement(By.xpath("//button[.='Create Account']"));
        createAccountButton.click();
        WebElement accountCreated=driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());

//        15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
//        16. Verify that 'Logged in as username' is visible
        WebElement loginSuccesfull = driver.findElement(By.xpath("//a[contains(.,'Logged in as')]"));
        Assert.assertTrue(loginSuccesfull.isDisplayed());
//        17. Click 'Delete Account' button
        //WebElement deleteAccount = driver.findElement(By.xpath("//a[@href='/delete_account')]"));
        //deleteAccount.click();
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        //WebElement accountDeleted = driver.findElement(By.xpath("//b[.='Account Deleted!')]"));
        WebElement deleteAccount = driver.findElement(By.xpath("//h2[@data-qa='account-deleted']"));
        Assert.assertTrue(deleteAccount.isDisplayed());

    }
}