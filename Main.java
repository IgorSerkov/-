package org.dstu;

import org.dstu.domain.IMathematics;
import org.dstu.domain.Arithmetic;
import org.dstu.domain.Geometric;
import org.dstu.tools.MyCsvReader;
import org.dstu.tools.Serializer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Need input and output file arguments!");
            return;
        }

        List<String[]> strings = MyCsvReader.readCsv(args[0], ";");
        System.out.println(strings.size());
        List<IMathematics> people = new ArrayList<>();
        for (String[] strArray: strings) {
            // Create teachers and students
            if (strArray[0].equals("0")) {
                people.add(new Geometric(strArray));
            } else {
                people.add(new Arithmetic(strArray));
            }
        }

        people.forEach(IMathematics::printInfo);

        Serializer.serialize(people, args[1]);
        List<IMathematics> newPeople = (List<IMathematics>) Serializer.deserialize(args[1]);
        newPeople.forEach(IMathematics::printInfo);
    }
}
