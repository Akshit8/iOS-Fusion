package com.adgvit.iosfusion.ui.notifications;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.adgvit.iosfusion.R;

public class NotificationsFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_notifications,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPref = this.getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = sharedPref.getString("username","");
        String reg = sharedPref.getString("userno","");
        TextView Name=view.findViewById(R.id.ParticipantName);
        TextView Reg= view.findViewById(R.id.ParticipantRegNo);
        Name.setText(name);
        Reg.setText(reg);
    }
}