package unit_3.homework3_3.training33;


import unit_3.homework3_3.training33.engineers.FrontEndDeveloper;
import unit_3.homework3_3.training33.engineers.PythonDeveloper;

public class Main {

    public static void main(String[] args) {

        FrontEndDeveloper eng1 = new FrontEndDeveloper();
        eng1.createCss();
        eng1.createHtml();

        Css a = new FrontEndDeveloper();
        System.out.println(a);

        eng1.createCss();

        FrontEndDeveloper eng2 = new FrontEndDeveloper();
        eng2.createCss();
        eng2.createHtml();

        PythonDeveloper eng3 = new PythonDeveloper();
        eng3.createProg();

        PythonDeveloper top = new PythonDeveloper();
        top.createProg();


    }
}
