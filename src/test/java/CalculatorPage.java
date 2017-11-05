
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;


public class CalculatorPage {

    private WebDriver driver;

    @FindBy(css="input[type='button'][value='1']")
    WebElement num1;

    @FindBy(css="input[type='button'][value='2']")
    WebElement num2;

    @FindBy(css="input[type='button'][value='3']")
    WebElement num3;

    @FindBy(css="input[type='button'][value='4']")
    WebElement num4;

    @FindBy(css="input[type='button'][value='5']")
    WebElement num5;

    @FindBy(css="input[type='button'][value='6']")
    WebElement num6;

    @FindBy(css="input[type='button'][value='7']")
    WebElement num7;

    @FindBy(css="input[type='button'][value='8']")
    WebElement num8;

    @FindBy(css="input[type='button'][value='9']")
    WebElement num9;

    @FindBy(css="input[type='button'][value='0']")
    WebElement num0;

    @FindBy(css="input[type='button'][value='+']")
    WebElement plus;

    @FindBy(css="input[type='button'][value='-']")
    WebElement minus;

    @FindBy(css="input[type='button'][value='x']")
    WebElement mult;

    @FindBy(css="input[type='button'][value='/']")
    WebElement division;

    @FindBy(css="input[type='button'][value='=']")
    WebElement equal;

    @FindBy(id="resultsbox")
    WebElement res;

    Map<Integer, WebElement> map=new HashMap<Integer,WebElement>();


    public CalculatorPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        map.put(1, num1);
        map.put(2, num2);
        map.put(3, num3);
        map.put(4, num4);
        map.put(5, num5);
        map.put(6, num6);
        map.put(7, num7);
        map.put(8, num8);
        map.put(9, num9);
        map.put(0, num0);
    }

    private void inputNum(int num){
        String strNum = String.valueOf(num);
        for (int i=0; i<strNum.length(); i++){
            int key = Integer.parseInt(Character.toString(strNum.charAt(i)));
            map.get(key).click();
        }
    }

    public String add (int a, int b){

        inputNum(a);
        plus.click();
        inputNum(b);
        equal.click();

        return res.getAttribute("value");
    }

    public String subtract(int a, int b){
        inputNum(a);
        minus.click();
        inputNum(b);
        equal.click();

        return res.getAttribute("value");
    }

    public String multiply(int a, int b){
        inputNum(a);
        mult.click();
        inputNum(b);
        equal.click();

        return res.getAttribute("value");
    }

    public String divide(int a, int b){
        inputNum(a);
        division.click();
        inputNum(b);
        equal.click();

        return res.getAttribute("value");
    }

}
