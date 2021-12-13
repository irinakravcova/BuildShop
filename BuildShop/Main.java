package BuildShop;

import javax.swing.*;

public class Main {

    public static final int MENU_EXIT = 0;
    public static final int MENU_ADD_CUSTOMER = 1;
    public static final int MENU_ADD_STORE = 2;
    public static final int MENU_ADD_SALE = 3;
    public static final int MENU_REPORT = 4;

    public static void main(String[] args) {
        UiCli ui;
        ui = new UiCli();
//        ui = new UiGui();
        Shop shop = new Shop();

        boolean work = true;
        while (work) {
            int menuChoice = ui.getUserAction();
            switch (menuChoice) {
                case MENU_EXIT:
                    work = false;
                    break;
                case MENU_ADD_CUSTOMER:
                    ui.addCustomer(shop);
                    break;
                case MENU_ADD_STORE:
                    ui.addStoreItem(shop);
                    break;
                case MENU_ADD_SALE:
                    ui.addSale(shop);
                    break;
                case MENU_REPORT:
                    ui.report(shop);
                    break;
                default:
                    continue;
            }
        }
    }

}
