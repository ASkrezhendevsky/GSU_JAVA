package by.gsu.pms;

import java.util.Comparator;

public class ButterNameComparator implements Comparator<Butter> {

    @Override
    public int compare(Butter butter1, Butter butter2) {
        if(butter1 == butter2){
            return 0;
        }

        if(butter1 == null){
            return 1;
        }

        if(butter2 == null){
            return -1;
        }

        return butter1.getName().compareTo(butter2.getName());
    }
}
