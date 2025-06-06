public class Customer {

    private int entry_hour,entry_minute,exit_hour,exit_minute;

    public Customer (int entry_hour, int entry_minute, int exit_hour, int exit_minute) {

        this.entry_hour = entry_hour;
        this.entry_minute = entry_minute;
        this.exit_hour = exit_hour;
        this.exit_minute = exit_minute;
    }

    public boolean getIfHourIsFull (int entry_minute,int exit_minute) {
        return exit_minute - entry_minute >= 0 ? true : false;
    }

    public int getParkedHours (int entry_hour, int exit_hour) {

        int hours_parked = 0;

        while (true) {

            if (entry_hour == exit_hour) {
                break;
            }
            else {
                hours_parked ++;
            }
            entry_hour ++;
            if (entry_hour == 24) {
                entry_hour = 0;
            }
        }

        boolean hour_is_full = getIfHourIsFull(this.entry_minute,this.exit_minute);
        if (!hour_is_full) {
            hours_parked -= 1;
        }

        return hours_parked;
    }

    public int getParkedMinutes (int entry_minutes, int exit_minutes) {

        int difference = exit_minutes - entry_minutes;

        return difference < 0 ? difference += 60 : difference;
    }

    private double calculateParkingFee (int hours, int minutes) {

        double fee = 0.0;

        if (hours >= 3) {
            fee = 2;
            hours -= 3;
        }
        else {
            return 2;
        }

        while (hours >= 1) {
            fee += 0.5;
            hours -= 1;
        }

        if (minutes >= 1) {
            fee += 0.5;
        }

        return  fee > 10 ? 10:fee;
    }

    public double getParkingFee () {

        int time_parked_in_hours = getParkedHours(this.entry_hour,this.exit_hour);
        int remaining_minutes = getParkedMinutes(this.entry_minute,this.exit_minute);
        double fee = calculateParkingFee(time_parked_in_hours,remaining_minutes);
        return fee;
    }

}
