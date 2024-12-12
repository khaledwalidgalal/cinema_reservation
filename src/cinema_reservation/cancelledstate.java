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
public class cancelledstate implements iteamstate {
    @Override
    public void processOrder(iteam order) {
        System.out.println("Cannot process a cancelled order.");
    }

    @Override
    public void cancelOrder(iteam order) {
        System.out.println("Order has already been cancelled.");
    }

    @Override
    public void shipOrder(iteam order) {
        System.out.println("Cannot ship a cancelled order.");
    }
}
