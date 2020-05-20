package com.example.vgtu_final;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

//import io.kommunicate.KmConversationBuilder;
//import io.kommunicate.Kommunicate;
//import io.kommunicate.callbacks.KmCallback;

public class ChatFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot =  inflater.inflate(R.layout.fragment_chatbot, container, false);


        final Context context = getActivity();
/*
        Kommunicate.init(context, "18c0a2f010cb7ce9766113fc0163dea6d");

        List<String> botList = new ArrayList(); botList.add("bot1"); //enter your integrated bot Ids
        new KmConversationBuilder(context)
                .setAppId("18c0a2f010cb7ce9766113fc0163dea6d")
                .launchConversation(new KmCallback() {
                    @Override
                    public void onSuccess(Object message) {
                        Utils.printLog(context, "ChatTest", "Success : " + message);
                    }

                    @Override
                    public void onFailure(Object error) {
                        Utils.printLog(context, "ChatTest", "Error : " + error);
                    }
                });

 */

        return viewRoot;
    }
}

