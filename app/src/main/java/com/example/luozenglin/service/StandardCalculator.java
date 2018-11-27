package com.example.luozenglin.service;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luozenglin.Utils.Calculate;
import com.example.luozenglin.calculator.R;
import com.example.luozenglin.calculator.ScientificCalculatorActivity;
import com.example.luozenglin.common.InputItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardCalculator {
    protected Activity activity;
    protected TextView showResultTv;
    protected TextView showInputTv;
    protected Button cBtn;
    protected Button delBtn;
    protected Button resBtn;
    protected Button divBtn;
    protected Button sevenBtn;
    protected Button eightBtn;
    protected Button nineBtn;
    protected Button mulBtn;
    protected Button fourBtn;
    protected Button fiveBtn;
    protected Button sixBtn;
    protected Button subBtn;
    protected Button oneBtn;
    protected Button twoBtn;
    protected Button threeBtn;
    protected Button addBtn;
    protected Button transformBtn;
    protected Button zeroBtn;
    protected Button pointBtn;
    protected Button equBtn;
    protected Map<View, String> map; //将View和String映射起来
    protected List<InputItem> inputList; //定义记录每次输入的数
    protected String lastResult;
    protected String expressionHistory;
    protected CurrentStatus currentStatus = CurrentStatus.INIT;

    public static enum CurrentStatus {
        INIT, CALCU,END, ERROR
    }

    public StandardCalculator() {
    }

    public StandardCalculator(Activity activity) {
        this.activity = activity;
        init();
        setOnClickListener();
    }

    protected void init() {
        showResultTv = (TextView) activity.findViewById(R.id.show_result_tv);
        showInputTv = (TextView) activity.findViewById(R.id.show_input_tv);
        cBtn = (Button) activity.findViewById(R.id.c_btn);
        delBtn = (Button) activity.findViewById(R.id.del_btn);
        resBtn = (Button) activity.findViewById(R.id.res_btn);
        divBtn = (Button) activity.findViewById(R.id.divide_btn);
        sevenBtn = (Button) activity.findViewById(R.id.seven_btn);
        eightBtn = (Button) activity.findViewById(R.id.eight_btn);
        nineBtn = (Button) activity.findViewById(R.id.nine_btn);
        mulBtn = (Button) activity.findViewById(R.id.multiply_btn);
        fourBtn = (Button) activity.findViewById(R.id.four_btn);
        fiveBtn = (Button) activity.findViewById(R.id.five_btn);
        sixBtn = (Button) activity.findViewById(R.id.six_btn);
        subBtn = (Button) activity.findViewById(R.id.sub_btn);
        oneBtn = (Button) activity.findViewById(R.id.one_btn);
        twoBtn = (Button) activity.findViewById(R.id.two_btn);
        threeBtn = (Button) activity.findViewById(R.id.three_btn);
        addBtn = (Button) activity.findViewById(R.id.add_btn);
        transformBtn = (Button) activity.findViewById(R.id.transform_btn);
        zeroBtn = (Button) activity.findViewById(R.id.zero_btn);
        pointBtn = (Button) activity.findViewById(R.id.point_btn);
        equBtn = (Button) activity.findViewById(R.id.equal_btn);
        map = new HashMap<>();
        map.put(zeroBtn, "0");
        map.put(oneBtn, "1");
        map.put(twoBtn, "2");
        map.put(threeBtn, "3");
        map.put(fourBtn, "4");
        map.put(fiveBtn, "5");
        map.put(sixBtn, "6");
        map.put(sevenBtn, "7");
        map.put(eightBtn, "8");
        map.put(nineBtn, "9");
        map.put(pointBtn, activity.getString(R.string.point));
        map.put(addBtn, "+");
        map.put(subBtn, "-");
        map.put(mulBtn, activity.getString(R.string.multiply) );
        map.put(divBtn, activity.getString(R.string.divide));
        map.put(equBtn, "=");
        inputList = new ArrayList<>();
        lastResult = "";
        initInput();
    }

    protected void setOnClickListener() {
        cBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
        resBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputLastRes();
            }
        });
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputOpe(v);
            }
        });
        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputOpe(v);
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputOpe(v);
            }
        });
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputOpe(v);
            }
        });
        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum(v);
            }
        });
        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum(v);
            }
        });
        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum(v);
            }
        });
        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum(v);
            }
        });
        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum(v);
            }
        });
        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum(v);
            }
        });
        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum(v);
            }
        });
        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum(v);
            }
        });
        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum(v);
            }
        });
        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum(v);
            }
        });
        pointBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNum(v);
            }
        });
        transformBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transform();
            }
        });
        equBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getResult(v);
            }
        });
    }

    protected void transform() {
        Intent intent = new Intent(activity, ScientificCalculatorActivity.class);
        activity.startActivity(intent);
    }


    protected void clear() {
        if (!isInitInputList()) {
            initInput();
            Log.i(activity.getClass().getSimpleName(),"cleaned inputTV \n inputTV: "+showInputTv.getText()
                   +"\n inputList:"+getInputListValues());
        } else {
            showResultTv.setText("");
            Log.i(activity.getClass().getSimpleName(),"cleaned resultTV");
        }
    }

    protected void delete() {
        if (!isInitInputList()) {
            if (inputList.size() == 1) {
                initInput();
            } else {
                Log.i(activity.getClass().getSimpleName(),"delete input: "+ subInputListAndInputTV().getValue());
            }
        }
    }


    protected boolean isInitInputList() {
        if(inputList.size()==1 && inputList.get(0).getValue().equals(map.get(zeroBtn))){
            return true;
        }
        return false;
    }

    protected void initInput() {
        inputList.clear();
        inputList.add(new InputItem(map.get(zeroBtn), InputItem.TYPE.NUM));
        showInputTv.setText(map.get(zeroBtn));
        currentStatus = CurrentStatus.INIT;
    }


    protected void addTV(View view) {
        showInputTv.setText(showInputTv.getText() + map.get(view));
    }

    protected String updateInputTV(){
        String inputString = "";
        for(InputItem inputItem: inputList){
            inputString += inputItem.getValue();
        }
        showInputTv.setText(inputString);
        return inputString;
    }

    protected InputItem subInputListAndInputTV(){
        if(inputList.size()>0){
            InputItem inputItem =  inputList.remove(inputList.size()-1);
            updateInputTV();
            return inputItem;
        }
        return null;
    }

    protected InputItem getLastInputItem(){
        if(inputList.size()>0){
            return inputList.get(inputList.size()-1);
        }
        return null;
    }

    protected void inputLastRes(){
        if(!lastResult.isEmpty() && (getLastInputItem().getType()!= InputItem.TYPE.NUM
                || currentStatus==CurrentStatus.INIT)){
            for(int i = 0;i<lastResult.length();i++){
                inputNum(String.valueOf(lastResult.charAt(i)));
            }
            updateInputTV();
        }
    }


    protected void inputOpe(View view) {
        if(getLastInputItem().getType()== InputItem.TYPE.OPE){    //连续输入两个OPR型操作符，删除第一个
            Log.i(activity.getClass().getSimpleName(),"delete OPT: "+  subInputListAndInputTV().getValue());
        }
        inputList.add(new InputItem(map.get(view), InputItem.TYPE.OPE));
        addTV(view);
        Log.i(activity.getClass().getSimpleName(),"Add OPT; "+map.get(view)+
                "\ninputList:  "+getInputListValues());
    }

    protected void inputNum(View view){
        inputNum(map.get(view));
    }

    protected void inputNum(String num) {
        initEndStatus();
        if(getLastInputItem().getType()== InputItem.TYPE.OPE_NUM){
            inputOpe(mulBtn);
        }
        if (isInitInputList() && (!num.equals("."))) {      //初始状态下输入数字替换原始0，小数点不替换
            Log.i(activity.getClass().getSimpleName(),"delete inputTV:  "+subInputListAndInputTV().getValue());
        }
        if(num.equals(".")){       //限制一个数中最多只有一个小数点
            for (int i = inputList.size() - 1; i > 0; i--) {
                if (inputList.get(i).getType() != InputItem.TYPE.NUM) {
                    break;
                } else if (inputList.get(i).getValue() == map.get(pointBtn)) {
                    return;
                }
            }
        }
        inputList.add(new InputItem(num, InputItem.TYPE.NUM));
        showInputTv.setText(showInputTv.getText() + num);
        Log.i(activity.getClass().getSimpleName(), "add:  " + num+
                "\ninputList:  " + getInputListValues());
    }

    protected String getInputListValues(){   //给日志打印inputList信息
        String s = "";
        for(InputItem inputItem: inputList){
            s += inputItem.getValue()+" ";
        }
        return s;
    }

    protected void initEndStatus(){    //上次计算结束后，初始化input
        if(currentStatus == CurrentStatus.END && getLastInputItem().getType()== InputItem.TYPE.NUM){
                showResultTv.setText(String.valueOf(showResultTv.getText())+showInputTv.getText());
                initInput();
                currentStatus = CurrentStatus.CALCU;
        }
    }

    protected void getResult(View view) {
        Calculate calculate = new Calculate();
        if (showInputTv.getText().charAt(showInputTv.length() - 1) != '=') {
            addTV(view);
        }
        String res = "";
        try{
            res = Calculate.getResult(inputList,activity);    //
            resultManage(res);
        }catch (ArithmeticException e){
            res = "0不能做除数！";
            Toast.makeText(activity,res,Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            res = "算术式不正确！";
            Toast.makeText(activity,res,Toast.LENGTH_SHORT).show();
        }
        Log.i(activity.getClass().getSimpleName(),"got result: "+res+
        "\ninputList:"+getInputListValues());
    }

    protected void resultManage(String result){
        showResultTv.setText(showInputTv.getText());
        showInputTv.setText(result);
        inputList.clear();
        lastResult = result;
        for(char c : result.toCharArray()){
            inputList.add(new InputItem(String.valueOf(c), InputItem.TYPE.NUM));
        }
        currentStatus = CurrentStatus.END;
    }
}
