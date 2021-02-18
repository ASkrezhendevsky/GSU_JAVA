import by.gsu.pms.BusinessTrip;

public class Runner {
    public static void main(String[] args) {
        //task 1
        BusinessTrip[] businessTrips = {
                new BusinessTrip("Tom", 705, 6),
                new BusinessTrip("John", 750, 3),
                null,
                new BusinessTrip("Mike", 52000, 7),
                new BusinessTrip("May", 70000, 2),
                new BusinessTrip("Brian", 47000, 4),
                new BusinessTrip(),
        };

        //task 2
        for (BusinessTrip businessTrip : businessTrips) {
            if(businessTrip != null) {
                businessTrip.show();
            }
        }

        //task 3
        businessTrips[businessTrips.length - 1].setTransportExpenses(3000);

        //task 4
        System.out.println("Duration = " + (businessTrips[0].getDays() + businessTrips[1].getDays()));

        //task 5
        for (BusinessTrip businessTrip : businessTrips) {
            System.out.println(businessTrip);
        }

        //task 6
        int totalExpenses = 0;
        for (BusinessTrip businessTrip : businessTrips) {
            if(businessTrip != null){
                totalExpenses += businessTrip.getTotal();
            }
        }
        System.out.println("Total expenses = " + totalExpenses);

        //task 7
        double maxTotal = 0;
        String account = "";
        for (BusinessTrip businessTrip : businessTrips) {
            if(businessTrip != null && businessTrip.getTotal() > maxTotal){
                maxTotal = businessTrip.getTotal();
                account = businessTrip.getAccount();
            }
        }
        System.out.println(account);
    }
}
