package com.example.harshraj.ilovezappos.WebServices;

import com.example.harshraj.ilovezappos.Constants.HTTPConstants;
import com.example.harshraj.ilovezappos.Constants.JSONConstants;
import com.example.harshraj.ilovezappos.Model.ItemList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Harshraj on 08-02-2017.
 */
public interface WebServices {

    @GET(HTTPConstants.searchURL)
    Call<ItemList> bringItems(@Query(JSONConstants.term) String term);
}
