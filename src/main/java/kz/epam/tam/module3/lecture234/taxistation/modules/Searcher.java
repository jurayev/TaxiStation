package kz.epam.tam.module3.lecture234.taxistation.modules;

import kz.epam.tam.module3.lecture234.taxistation.exceptions.EmptySearchResultException;
import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;
import kz.epam.tam.module3.lecture234.taxistation.utils.FindByParameter;

import java.util.List;
import java.util.ResourceBundle;

public class Searcher {

    public static String searchACar(List<Taxi> taxiList){
        String search;
        try {
            String param = ResourceBundle.getBundle("workflowvariables").getString("search");
            search = FindByParameter.findACarByParameter(param, taxiList);
        } catch (EmptySearchResultException e) {
            search = e.getMessage();
            System.out.println(e.getMessage());
        }
        return search;
    }
}
