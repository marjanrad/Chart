package com.example.chart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BarChart barChart;
    LineChart lineChartDownFill;
    PieChart pieChart;
    int[] colorClassArray=new int[]{Color.BLUE,Color.RED,Color.YELLOW,Color.CYAN,Color.DKGRAY,Color.GRAY,Color.GREEN,Color.LTGRAY,Color.MAGENTA,Color.TRANSPARENT,Color.WHITE,Color.BLACK};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   //     barChart=findViewById(R.id.bargraph);

//        ArrayList<BarEntry> barEntries=new ArrayList<>();
//        barEntries.add(new BarEntry(55f,0));
//        barEntries.add(new BarEntry(35f,1));
//        barEntries.add(new BarEntry(65f,2));
//        barEntries.add(new BarEntry(40f,3));
//        barEntries.add(new BarEntry(30f,4));
//        barEntries.add(new BarEntry(37f,5));
//        BarDataSet barDataSet=new BarDataSet(barEntries,"Dates");
//
//        ArrayList<String> theDates=new ArrayList<>();
//        theDates.add("فروردین");
//        theDates.add("اردیبهشت");
//        theDates.add("خرداد");
//        theDates.add("تیر");
//        theDates.add("مرداد");
//        theDates.add("شهریور");
//
//        BarData thedata=new BarData(barDataSet);
//        barChart.setData(thedata);
//        barChart.setTouchEnabled(true);
//        barChart.setDragEnabled(true);
//        barChart.setScaleEnabled(true);
//


        //line chart
            lineChartDownFill = findViewById(R.id.lineChart);
            lineChartDownFill.setTouchEnabled(false);
            lineChartDownFill.setDragEnabled(true);
            lineChartDownFill.setScaleEnabled(true);
            lineChartDownFill.setPinchZoom(false);
            lineChartDownFill.setDrawGridBackground(false);
            lineChartDownFill.setMaxHighlightDistance(200);
            lineChartDownFill.setViewPortOffsets(0, 0, 0, 0);
            lineChartDownFillWithData();
         //


            pieChart=findViewById(R.id.pieChart);
        PieDataSet pieDataSet=new PieDataSet(dataValues1(),"");
        pieDataSet.setColors(colorClassArray);
        PieData pieData=new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.invalidate();


    }


    //line chart
    private void lineChartDownFillWithData() {


        Description description = new Description();
        description.setText("Days Data");

        lineChartDownFill.setDescription(description);


        ArrayList<Entry> entryArrayList = new ArrayList<>();
        entryArrayList.add(new Entry(0, 60f, "1"));
        entryArrayList.add(new Entry(1, 55f, "2"));
        entryArrayList.add(new Entry(2, 60f, "3"));
        entryArrayList.add(new Entry(3, 40f, "4"));
        entryArrayList.add(new Entry(4, 45f, "5"));
        entryArrayList.add(new Entry(5, 36f, "6"));
        entryArrayList.add(new Entry(6, 30f, "7"));
        entryArrayList.add(new Entry(7, 40f, "8"));
        entryArrayList.add(new Entry(8, 45f, "9"));
        entryArrayList.add(new Entry(9, 60f, "10"));
        entryArrayList.add(new Entry(10, 45f, "10"));
        entryArrayList.add(new Entry(11, 40f, "10"));


        //LineDataSet is the line on the graph
        LineDataSet lineDataSet = new LineDataSet(entryArrayList, "This is y bill");

        lineDataSet.setLineWidth(3f);
        lineDataSet.setColor(Color.CYAN);
       // lineDataSet.setCircleColorHole(Color.GREEN);
        lineDataSet.setCircleColor(R.color.colorAccent);
        lineDataSet.setHighLightColor(Color.RED);
        lineDataSet.setDrawValues(false);
        lineDataSet.setCircleRadius(10f);
        lineDataSet.setCircleColor(Color.YELLOW);

        //to make the smooth line as the graph is adrapt change so smooth curve
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        //to enable the cubic density : if 1 then it will be sharp curve
        lineDataSet.setCubicIntensity(0.2f);

        //to fill the below of smooth line in graph
        lineDataSet.setDrawFilled(true);
        lineDataSet.setFillColor(Color.BLACK);
        //set the transparency
        lineDataSet.setFillAlpha(80);

        //set the gradiant then the above draw fill color will be replace
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.twocolor);
        lineDataSet.setFillDrawable(drawable);

        //set legend disable or enable to hide {the left down corner name of graph}
        Legend legend = lineChartDownFill.getLegend();
        legend.setEnabled(false);

        //to remove the cricle from the graph
        lineDataSet.setDrawCircles(false);

        //lineDataSet.setColor(ColorTemplate.COLORFUL_COLORS);


        ArrayList<ILineDataSet> iLineDataSetArrayList = new ArrayList<>();
        iLineDataSetArrayList.add(lineDataSet);

        //LineData is the data accord
        LineData lineData = new LineData(iLineDataSetArrayList);
        lineData.setValueTextSize(13f);
        lineData.setValueTextColor(Color.BLACK);


        lineChartDownFill.setData(lineData);
        lineChartDownFill.invalidate();


    }


    //Pie chart
    ArrayList<PieEntry> dataValues1(){
        ArrayList<PieEntry> dataVals=new ArrayList<PieEntry>();
        dataVals.add(new PieEntry(15,"فروردین"));
        dataVals.add(new PieEntry(30,"اردیبهشت"));
        dataVals.add(new PieEntry(60,"خرداد"));
        dataVals.add(new PieEntry(50,"تیر"));
        dataVals.add(new PieEntry(5,"مرداد"));
        dataVals.add(new PieEntry(80,"شهریور"));
        dataVals.add(new PieEntry(23,"مهر"));
        dataVals.add(new PieEntry(70,"آبان"));
        dataVals.add(new PieEntry(33,"آذر"));
        dataVals.add(new PieEntry(10,"دی"));
        dataVals.add(new PieEntry(8,"بهمن"));
        dataVals.add(new PieEntry(55,"اسفند"));
        return dataVals;
    }
}
