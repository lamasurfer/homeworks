package unit_3.homework3_3.training33.engineers;

import unit_3.homework3_3.training33.Prog;

public class PythonDeveloper extends Engineer implements Prog {

    public PythonDeveloper() {
    }

    @Override
    public void createProg() {
        System.out.println("Hello World!");
    }
}
