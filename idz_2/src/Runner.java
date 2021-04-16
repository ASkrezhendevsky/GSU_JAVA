import by.gsu.pms.beans.AbstractTax;
import by.gsu.pms.beans.Byn;
import by.gsu.pms.beans.IncomeTax;

import java.time.Year;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        AbstractTax[] taxes = {
                new IncomeTax(new Byn(9000000), 0.16, Year.of(2020)),
                new IncomeTax(new Byn(7000000), 0.16, Year.of(2020)),
        };

        Arrays.sort(taxes);

        System.out.println(taxes[0]);
    }
}
