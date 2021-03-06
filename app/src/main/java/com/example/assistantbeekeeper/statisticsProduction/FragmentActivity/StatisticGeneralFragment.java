package com.example.assistantbeekeeper.statisticsProduction.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.statisticsProduction.FragmentStatisticsPre.StatisticGeneralPre;
import com.example.assistantbeekeeper.statisticsProduction.detailStatistic.detailStatisticActivity.ListOfOperationsActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.assistantbeekeeper.R.id;
import static com.example.assistantbeekeeper.R.layout;

public class StatisticGeneralFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private ArrayList<CustomItems> customList=new ArrayList<>();
    private TextView apiaryName;
    private static final String TAG="STATISTIC_GENERAL_STATIC";
    private OverviewFragmentActivityListener listener;
    private List<ApiaryEntity> apiaryListItem;
    private StatisticGeneralPre statisticGeneralPre;
    private TextView costsInCurentYear, profitInCurentYear, productionInCurentYear;
    private Button seeMoreButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         statisticGeneralPre = new StatisticGeneralPre();

        //Create mydatabase
        AssistantDbAbstract databaseStatistic = statisticGeneralPre.createDatabase(getContext());
        apiaryListItem=statisticGeneralPre.loadTableApiaryEntity(apiaryListItem, databaseStatistic);
        if(apiaryListItem.isEmpty()){
            Toast.makeText(getContext(), "Baza Apiery jest pusta", Toast.LENGTH_LONG).show();
        }
       // databaseStatistic.close();

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(layout.general_statistics_fragment, container, false);
        initComponent(view);

        Spinner customSpinnerStatistics = view.findViewById(id.spinner_statistic);
        customSpinnerStatistics.setOnItemSelectedListener(this);

        customList=statisticGeneralPre.loadDataToCustomList(apiaryListItem);
        Log.i(TAG, String.valueOf(customList.size()));

        CustomAdapterSpinner customAdapter=new CustomAdapterSpinner(getContext(), customList);
        customSpinnerStatistics.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();

        seeMoreButton.setOnClickListener(view1 -> {
            Intent intent=new Intent(getActivity(), ListOfOperationsActivity.class);
            intent.putExtra("placeName", apiaryName.getText());
            startActivity(intent);
        });

        return view ;
    }

    public void setTotalCost(double totalValueCost) {

        String total=Double.toString(totalValueCost);
        costsInCurentYear.setText(total);
    }

    public void setTotalProfit(double totalValueProfit) {
        String total=Double.toString(totalValueProfit);
        profitInCurentYear.setText(total);
    }

    public  void setTotalProduction(double totalProduction){
        String total= String.valueOf(totalProduction);
        productionInCurentYear.setText(total);
    }


    //interface for communication between fragments

    public interface OverviewFragmentActivityListener{

        //method for communication between Static General Fragment and Panel button
        void sendIdApiaryToPanelButton(String name_apiary);
    }


    public void setOverviewFragmentActivityListener(OverviewFragmentActivityListener callBack){
        listener=callBack;
    }




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.i("POSITION", String.valueOf(adapterView.getAdapter().getItem(i)));

        String placeName=customList.get(i).getSpinnerText();
        setApiaryName(placeName);
        listener.sendIdApiaryToPanelButton(placeName);


        statisticGeneralPre.loadDataForPlaceName(getContext(),this, placeName);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }


    private void setApiaryName(String name){
        apiaryName.setText(name);
    }



    private void initComponent(View view){

        apiaryName=view.findViewById(id.apiaryName);
        costsInCurentYear=view.findViewById(id.textView6);
        profitInCurentYear=view.findViewById(id.textView7);
        productionInCurentYear=view.findViewById(id.textView8);
        seeMoreButton=view.findViewById(id.seeMoreButton);
    }
}
