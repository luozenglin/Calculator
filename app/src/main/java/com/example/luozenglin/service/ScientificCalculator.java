package com.example.luozenglin.service;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.luozenglin.calculator.MainActivity;
import com.example.luozenglin.calculator.R;
import com.example.luozenglin.common.InputItem;

public class ScientificCalculator extends StandardCalculator {
    protected Button antiBtn;
    protected Button perCent;
    protected Button sinBtn;
    protected Button cosBtn;
    protected Button tanBtn;
    protected Button powerBtn;
    protected Button lgBtn;
    protected Button lnBtn;
    protected Button leftBraBtn;
    protected Button rightBraBtn;
    protected Button squareRootBtn;
    protected Button factorialBtn;
    protected Button reciprocalBtn;
    protected Button pIBtn;
    protected Button eBtn;

    public ScientificCalculator(Activity activity){
        super(activity);
    }

    @Override
    protected void init() {
        super.init();
        antiBtn = (Button) activity.findViewById(R.id.anti_btn);
        sinBtn = (Button) activity.findViewById(R.id.sin_btn);
        cosBtn  = (Button) activity.findViewById(R.id.cos_btn);
        tanBtn = (Button) activity.findViewById(R.id.tan_btn);
        powerBtn = (Button) activity.findViewById(R.id.power_btn);
        lgBtn = (Button) activity.findViewById(R.id.log_btn);
        lnBtn = (Button) activity.findViewById(R.id.ln_btn);
        leftBraBtn = (Button) activity.findViewById(R.id.leftBracket_btn);
        rightBraBtn = (Button) activity.findViewById(R.id.rightBracket_btn);
        squareRootBtn = (Button) activity.findViewById(R.id.squareRoot_btn);
        factorialBtn = (Button) activity.findViewById(R.id.factorial_btn);
        reciprocalBtn = (Button) activity.findViewById(R.id.reciprocal_btn);
        pIBtn = (Button) activity.findViewById(R.id.PI_btn);
        eBtn = (Button) activity.findViewById(R.id.e_btn);
        perCent = (Button) activity.findViewById(R.id.perCent_btn);
        map.put(sinBtn,activity.getString(R.string.sin));
        map.put(cosBtn,activity.getString(R.string.cos));
        map.put(tanBtn,activity.getString(R.string.tan));
        map.put(powerBtn,activity.getString(R.string.power));
        map.put(perCent, "%");
        map.put(lgBtn,activity.getString(R.string.log));
        map.put(lnBtn,activity.getString(R.string.ln));
        map.put(leftBraBtn,activity.getString(R.string.leftBra));
        map.put(rightBraBtn,activity.getString(R.string.rightBra));
        map.put(squareRootBtn,activity.getString(R.string.squareRoot));
        map.put(factorialBtn,activity.getString(R.string.factorial));
        map.put(reciprocalBtn,activity.getString(R.string.reciprocal));
        map.put(pIBtn,activity.getString(R.string.PI));
        map.put(eBtn,"e");
    }

    @Override
    protected void setOnClickListener() {
        super.setOnClickListener();
        powerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputOpe(v);
            }
        });
        perCent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputOpeOpe(v);
            }
        });
        antiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transTrigon();
            }
        });
        sinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumOpe(v);
            }
        });
        cosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumOpe(v);
            }
        });
        tanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumOpe(v);
            }
        });
        lgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumOpe(v);
            }
        });
        lnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumOpe(v);
            }
        });
        squareRootBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumOpe(v);
            }
        });
        leftBraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputLeftBra();
            }
        });
        rightBraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputRightBra();
            }
        });
        factorialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputOpeOpe(v);
            }
        });
        reciprocalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputOpeOpe(v);
            }
        });
        pIBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputOpeNum(v);
            }
        });
        eBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputOpeNum(v);
            }
        });
    }

    @Override
    protected void transform() {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    protected void transTrigon(){
        if(antiBtn.getText().equals(activity.getString(R.string.radian))){
            antiBtn.setText(activity.getString(R.string.deg));
        }else if(antiBtn.getText().equals(activity.getString(R.string.deg))){
            antiBtn.setText(activity.getString(R.string.radian));
        }
    }

    protected void inputTrigonometricFunction(View view){

    }

    protected void inputNumOpe(View view){
        if( currentStatus == CurrentStatus.END){
            initEndStatus();
        }
        if(isInitInputList()){
            subInputListAndInputTV();
        } else if(getLastInputItem().getType()== InputItem.TYPE.NUM ||
                getLastInputItem().getType()== InputItem.TYPE.RIGHT_BRACKET){
            inputOpe(mulBtn);
        }
        inputList.add(new InputItem(map.get(view), InputItem.TYPE.NUM_OPE));
        addTV(view);
        inputLeftBra();
        Log.i(activity.getClass().getSimpleName(),"add ope: "+map.get(view)+
                "\ninputList: "+getInputListValues());
    }

    protected void inputOpeOpe(View view) {
        if (getLastInputItem().getType()!= InputItem.TYPE.NUM                      //OPT_OPT前必须是数字或右括号
                && getLastInputItem().getType()!= InputItem.TYPE.RIGHT_BRACKET) {
            Log.i(activity.getClass().getSimpleName(),"Last input is "+
                    getLastInputItem().getValue()+", can not add "+map.get(view));
            return;
        }
        inputList.add(new InputItem(map.get(view), InputItem.TYPE.OPE_OPE));
        addTV(view);
        Log.i(activity.getClass().getSimpleName(),"inputList:  "+getInputListValues());
    }

    protected void inputOpeNum(View view){
        if( currentStatus == CurrentStatus.END){
            initEndStatus();
        }
        if(isInitInputList()){
            subInputListAndInputTV();
        }else if(getLastInputItem().getType()== InputItem.TYPE.NUM ||
                getLastInputItem().getType()== InputItem.TYPE.RIGHT_BRACKET){
            inputOpe(mulBtn);
        }
        inputList.add(new InputItem(map.get(view), InputItem.TYPE.OPE_NUM));
        addTV(view);
        Log.i(activity.getClass().getSimpleName(),"add ope: "+map.get(view)+
                "\ninputList: "+getInputListValues());
    }

    protected void inputLeftBra(){
        if( currentStatus == CurrentStatus.END){
            initEndStatus();
        }
        if(isInitInputList()){
            subInputListAndInputTV();
        }else if(getLastInputItem().getType()!= InputItem.TYPE.OPE && getLastInputItem().getType()!= InputItem.TYPE.NUM_OPE
                && getLastInputItem().getType()!= InputItem.TYPE.LEFT_BRACKET){
            inputOpe(mulBtn);
        }
        inputList.add(new InputItem(map.get(leftBraBtn), InputItem.TYPE.LEFT_BRACKET));
        addTV(leftBraBtn);
        Log.i(activity.getClass().getSimpleName(),"add ope: "+map.get(leftBraBtn)+
                "\ninputList: "+getInputListValues());
    }

    protected void inputRightBra(){
        if(getLastInputItem().getType()== InputItem.TYPE.OPE){
            subInputListAndInputTV();
        }
        inputList.add(new InputItem(map.get(rightBraBtn), InputItem.TYPE.RIGHT_BRACKET));
        addTV(rightBraBtn);
        Log.i(activity.getClass().getSimpleName(),"add ope: "+map.get(rightBraBtn)+
                "\ninputList: "+getInputListValues());
    }
}
