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


public interface iteamstate {
    public void processOrder(iteam order);
    public void cancelOrder(iteam order);
    public void shipOrder(iteam order);
}
