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
public class iteam {
    private int orderId;
    // ... other members ...
    private iteamstate state;

    public iteam(int orderId) {
        this.orderId = orderId;
        this.state = new pendingstate(); // Initial state
    }

    public void setState(iteamstate state) {
        this.state = state;
    }

    public void processOrder() {
        state.processOrder(this);
    }

    public void cancelOrder() {
        state.cancelOrder(this);
    }

    public void shipOrder() {
        state.shipOrder(this);
    }

    public int getOrderId() {
        return orderId;
    }

    // ... other methods ...
}