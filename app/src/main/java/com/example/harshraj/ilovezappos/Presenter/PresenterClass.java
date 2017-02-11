package com.example.harshraj.ilovezappos.Presenter;

import android.util.Log;

import com.example.harshraj.ilovezappos.Contractor.ContractorClass;
import com.example.harshraj.ilovezappos.Model.ItemDescription;
import com.example.harshraj.ilovezappos.Model.ItemList;
import com.example.harshraj.ilovezappos.WebServices.ServiceClass;
import com.example.harshraj.ilovezappos.WebServices.WebServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Harshraj on 09-02-2017.
 */
public class PresenterClass implements ContractorClass.IPresenter {

    public ContractorClass.IView iView;
    ItemList itemList;

    public PresenterClass(ContractorClass.IView iView){ this.iView=iView;}

    @Override
    public void doQuery(String term) {
        WebServices webServices = ServiceClass.serviceConnection();
        Call<ItemList> call = webServices.bringItems(term);
        call.enqueue(new Callback<ItemList>() {
            @Override
            public void onResponse(Call<ItemList> call, Response<ItemList> response) {
                if(response.isSuccessful()){
                    Log.d("Service URL",call.request().url().toString()); //URL to see if it is correct or not
                    itemList = response.body(); // passing the body of response to itemList
                    iView.onSerachResult(itemList); //passing the itemList to iView and which can be accessed in the Activity
                }
            }

            @Override
            public void onFailure(Call<ItemList> call, Throwable t) {
                Log.d("Service Failure Message",t.getMessage()); //Failure Message
            }
        });
    }
}
