package net.salesianos.activities.activity4;

import net.salesianos.activities.activity4.utils.menu.Menu;

public class App {
    public static void main(String[] args) {
        Menu.setKeepAsking(true);
        while (Menu.isKeepAsking()) {
            Menu.showMainMenu();
            Menu.userSelection();
        }
        
    }
}
