package com.transfer.pay.ui.fragments.wallet;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.transfer.pay.R;
import com.transfer.pay.databinding.WalletBinding;

public class ProfitViewHelper extends ViewHelper<ProfitPresenter, WalletBinding> {

    @Override
    protected void onBindVariables(WalletBinding binding) {
        getPresenter().bindVariables(binding);
    }

    @Override
    protected void onInitView() {
        super.onInitView();
        initGraph();
    }

    private void initGraph() {
        LineGraphSeries<DataPoint> points = getPresenter().getListOfPoints();

        GraphView graph = getBinding().graph;
        points.setTitle("Profit");
        points.setDrawDataPoints(true);
        points.setAnimated(true);
        graph.addSeries(points);

        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(graph.getContext()));
        graph.getGridLabelRenderer().setNumHorizontalLabels(2);

        graph.getViewport().setMinX(points.getLowestValueX());
        graph.getViewport().setMaxX(points.getHighestValueX());
        graph.getViewport().setXAxisBoundsManual(true);


        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.wallet;
    }
}
