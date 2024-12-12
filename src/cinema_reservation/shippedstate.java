/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_reservation;

/**
 *
 * @author HP
 */
public class shippedstate implements iteamstate {
    @Override
    public void processOrder(iteam order) {
        System.out.println("Cannot process a shipped order.");
    }

    @Override
    public void cancelOrder(iteam order) {
        System.out.println("Cannot cancel a shipped order.");
    }

    @Override
    public void shipOrder(iteam order) {
        System.out.println("Order has already been shipped.");
    }
}
