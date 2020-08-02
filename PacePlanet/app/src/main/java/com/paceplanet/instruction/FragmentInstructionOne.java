package com.paceplanet.instruction;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.paceplanet.MainActivity;
import com.paceplanet.R;

public class FragmentInstructionOne extends Fragment {
    private View view;
    private Button btn_submit;
    private String userID;
    private EditText id_edit_text;

    public static FragmentInstructionOne newInstance() {
        FragmentInstructionOne fragmentInstructionOne = new FragmentInstructionOne();
        return fragmentInstructionOne;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_instruction_one, container, false);

        id_edit_text = (EditText) view.findViewById(R.id.id_edit_text);
        btn_submit = (Button) view.findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //read in userID in Edit Text
                if (id_edit_text.length() == 0) {
                    toastMessage("Please enter your ID.");
                }
                else {
                    userID = id_edit_text.getText().toString();

                    //check if the user id is taken
                    checkUserID(userID);
                }
            }
        });

        return view;
    }

    private void checkUserID(final String userID){
        //add data using firebase
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference userNameRef = rootRef.child("UserID").child(userID);

        //check if userID exists
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(!dataSnapshot.exists()) {
                    //create new user
                    userNameRef.setValue(userID);
                    toastMessage("Welcome, " + userID + "!");

                    //move to the main activity
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    toastMessage("Your User ID is already taken.\nPlease try another one!");
                    id_edit_text.setText("");
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                toastMessage("There is an error to search if the user ID exists.");
            }
        };
        userNameRef.addListenerForSingleValueEvent(eventListener);
    }

    private void toastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}