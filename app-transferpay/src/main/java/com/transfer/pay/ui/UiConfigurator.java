package com.transfer.pay.ui;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Spinner;

import com.transfer.pay.factories.SpinnerAdapterFactory;
import com.transfer.pay.ui.list.adapter.RecyclerAdapter;
import com.transfer.pay.ui.list.binder.ViewHolderBinder;
import com.transfer.pay.utils.ResourceUtils;

import java.util.List;

/**
 * Created by i.statkevich on 6/2/17.
 */

public class UiConfigurator {

    public static void initRecyclerView(RecyclerView.Adapter adapter, View root, int recyclerId) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(root.getContext());
        RecyclerView recyclerView = (RecyclerView) root.findViewById(recyclerId);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    public static <B extends ViewDataBinding, I> RecyclerAdapter<B, I> initRecyclerAndGetAdapter(List<I> items,
                                                                                                 ViewHolderBinder<B, I> binder,
                                                                                                 View root,
                                                                                                 RecyclerView.LayoutManager layoutManager,
                                                                                                 int recyclerId) {
        RecyclerView recyclerView = (RecyclerView) root.findViewById(recyclerId);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        RecyclerAdapter<B, I> adapter = new RecyclerAdapter<>(
                items,
                binder
        );

        recyclerView.setAdapter(adapter);
        return adapter;
    }

    public static void initSpinnerAdapterWithResourceData(Spinner spinner, int arrayId) {
        Context context = spinner.getContext();
        List<String> countries = ResourceUtils.arrayToList(context, arrayId);
        SpinnerAdapterFactory factory = new SpinnerAdapterFactory(context);
        spinner.setAdapter(factory.createArrayAdapter(countries));
    }

    public static void initSpinnerAdapterWithObjects(Spinner spinner, List<?> objects){
        SpinnerAdapterFactory factory = new SpinnerAdapterFactory(spinner.getContext());
        spinner.setAdapter(factory.createArrayAdapter(objects));
    }

}
