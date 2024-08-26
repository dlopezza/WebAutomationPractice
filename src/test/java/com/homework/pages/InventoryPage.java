package com.homework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@id, 'add-to-cart')]")
    private List<WebElement> addToCartButtons;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartButton;

    public void clickShoppingCartButton(){
        shoppingCartButton.click();
    }

    public int getAmountOfItems(){
        return addToCartButtons.size();
    }

    public void pressAddToCartButton(int index){
        addToCartButtons.get(index).click();
    }
}
