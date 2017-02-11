package com.example.harshraj.ilovezappos.Contractor;

import com.example.harshraj.ilovezappos.Model.ItemList;

/**
 * Created by Harshraj on 09-02-2017.
 */


//Contractor Class for the Model-View-Presenter logic
//It contains two interfaces for the View and presnter class
//Web Service will be called from the IPresneter implemented class and the results will be given to IView implemented class
// which in fact will be accessed by the Main Activity.


public class ContractorClass {

    public interface IView{
        void onSerachResult(ItemList itemList);
    }

    public interface IPresenter{
        void doQuery(String term);
    }
}
