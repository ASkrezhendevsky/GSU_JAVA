import by.gsu.pms.beans.*;

import java.time.Year;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        AbstractTax[] taxes = {
                new IncomeTax(Year.of(2020), new Byn(9000000), 0.16),
                new IncomeTax(Year.of(2020), new Byn(7000000), 0.16),
                new PresentTax(Year.of(2020), new Byn(400000), false),
                new PresentTax(Year.of(2020), new Byn(700000), true),
                new AuthorIncomeTax(Year.of(2020), new Byn(70000), 0.16),
        };

        Arrays.sort(taxes);
        for (AbstractTax tax: taxes) {
            System.out.println(tax);
        }

        System.out.println(taxes[taxes.length - 1]);
    }
}
