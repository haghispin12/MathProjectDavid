package com.example.mathprojectdavid;

import static android.app.Activity.RESULT_OK;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_Showusers extends Fragment {

    private Button addapictuer;

    private EditText name;

    private TextView score;

    private TextView rate;

    ImageView Pic;

    private Uri uri;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    public void initView(View view){
        addapictuer = view.findViewById(R.id.button2);
        name = view.findViewById(R.id.name);
        score = view.findViewById(R.id.score);
        rate = view.findViewById(R.id.rate);
        Pic = view.findViewById(R.id.imageView2);

        addapictuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityResultLauncher<Intent> startcamera = registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                            @Override
                            public void onActivityResult(ActivityResult result) {
                                if(result.getResultCode()==RESULT_OK){

                                    Pic.setImageURI(uri);

                                }
                            }
                        });
                ContentValues values = new ContentValues();
                    values.put(MediaStore.Images.Media.TITLE, "New Picture");
                    values.put(MediaStore.Images.Media.DESCRIPTION, "From Camera");
                    uri = requireContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    startcamera.launch(cameraIntent);

            }

        });

    }








    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment__showusers, container, false);
        initView(view);
        return view;
    }


}