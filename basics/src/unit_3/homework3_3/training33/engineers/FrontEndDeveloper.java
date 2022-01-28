package unit_3.homework3_3.training33.engineers;

import unit_3.homework3_3.training33.Css;
import unit_3.homework3_3.training33.Html;

public class FrontEndDeveloper extends Engineer implements Css, Html {

    public FrontEndDeveloper() {

    }

    @Override
    public void createHtml() {
        System.out.println("Зацени мой HTML!!!");
    }

    @Override
    public void createCss() {
        System.out.println("Зацени мой CSS!!!");
    }
}
