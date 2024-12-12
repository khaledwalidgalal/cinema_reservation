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
public class pendingstate implements iteamstate {
    @Override
    public void processOrder(iteam order) {
        order.setState(new proccessingstate());
        System.out.println("Order processed.");
    }

    @Override
    public void cancelOrder(iteam order) {
        System.out.println("Pending order cancelled.");
        order.setState(new cancelledstate());
    }

    @Override
    public void shipOrder(iteam order) {
        System.out.println("Cannot ship a pending order.");
    }
}

