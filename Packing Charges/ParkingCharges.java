import javax.swing.JOptionPane;

public class ParkingCharges {

    public static void main (String[] args) {

        double total_fee = 0.0;
        int calculate_fee_int;

        JOptionPane.showMessageDialog(null,"Our app calculate the garage fee\n3 Hours == $2 and Other extra time == $0.5 but 24 hours == $10 which is the  maximum fee, Below 3 Hours it's also $2\nEnter the hour the customer has entered in the garage\nand the hour the customer has exited the garage");

         calculate_fee_int = 1;

         while (calculate_fee_int != 0) {

             int entry_hour = Integer.parseInt(JOptionPane.showInputDialog("Enter the hour by which the customer has entered the garage: "));
             int entry_minute = Integer.parseInt(JOptionPane.showInputDialog("Enter the minute by which the customer has entered the garage: "));

             int exit_hour = Integer.parseInt(JOptionPane.showInputDialog("Enter the hour by which the customer has exited the garage: "));
             int exit_minute = Integer.parseInt(JOptionPane.showInputDialog("Enter the minute by which the customer has exited the garage: "));

             Customer a_customer = new Customer(entry_hour,entry_minute,exit_hour,exit_minute);

             double fee = a_customer.getParkingFee();
             total_fee += fee;

             JOptionPane.showMessageDialog(null,"The customer entered at: "+entry_hour+":"+entry_minute+"\nAnd exited at: "+exit_hour+":"+exit_minute+"\nThe customer parked for: "+a_customer.getParkedHours(entry_hour,exit_hour)+" hours and "+a_customer.getParkedMinutes(entry_minute,exit_minute)+" minutes\nFee to pay is: $"+fee);

             calculate_fee_int = Integer.parseInt(JOptionPane.showInputDialog("Press any number which isn't 0 to calculate the customer fee: "));
         }

         JOptionPane.showMessageDialog(null,"Thank you for using our app\nTotal fee collected: "+total_fee);
    }
}
