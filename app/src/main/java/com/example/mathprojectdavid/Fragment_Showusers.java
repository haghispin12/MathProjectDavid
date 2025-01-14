package com.example.mathprojectdavid;

import static android.app.Activity.RESULT_OK;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fragment_Showusers extends Fragment implements MenuProvider {

    private Button addapictuer;

    private EditText name;

    private TextView score;

    private TextView rate;

    private Button addUser;

    private ImageView Pic;

    private Uri uri;

    MainViewModel viewModelMain;

    private RecyclerView rcUsers;

    private MenuItem itemDelete;

    private User currentUser;

    ActivityResultLauncher<Intent> startcamera = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==RESULT_OK){

                        Pic.setImageURI(uri);
                        viewModelMain.getUser().setUri(uri);

                    }
                }
            });



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
        addUser = view.findViewById(R.id.adduser);
        rcUsers = view.findViewById(R.id.rcUsers);

        addapictuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContentValues values = new ContentValues();
                    values.put(MediaStore.Images.Media.TITLE, "New Picture");
                    values.put(MediaStore.Images.Media.DESCRIPTION, "From Camera");
                    uri = requireContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    startcamera.launch(cameraIntent);

            }

        });

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getActivity()!=null){
                    long id = viewModelMain.dbAddUser(getActivity());
                    Toast.makeText(getActivity(), "insert get row id"+id, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }








    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment__showusers, container, false);
        initView(view);
        viewModelMain = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        this.score.setText("your score:"+viewModelMain.getUser().getScore()+"");
        this.name.setText("your name: "+viewModelMain.getUser().getName());
        this.rate.setText("rate:"+viewModelMain.getUser().getRate());

        requireActivity().addMenuProvider(this);

        viewModelMain.users.observe(requireActivity(), new Observer<ArrayList<User>>() {
            @Override
            public void onChanged(ArrayList<User> users) {
                int n =10;
                UsersAdapter usersAdapter = new UsersAdapter(users, new UsersAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(User item) {
                        Toast.makeText(requireActivity(), item.getName(), Toast.LENGTH_SHORT).show();
                        viewModelMain.currentUser = item;
                        //User newUser = item;
                        score.setText("your score:"+viewModelMain.getCurrentUser().getScore()+"");
                        name.setText("your name: "+viewModelMain.getCurrentUser().getName());
                        rate.setText("rate:"+viewModelMain.getCurrentUser().getRate());



                    }
                });
                rcUsers.setLayoutManager(new LinearLayoutManager(requireActivity()));
                rcUsers.setAdapter(usersAdapter);
                rcUsers.setHasFixedSize(true);
            }
        });

        viewModelMain.getUsersDB(requireActivity());


        return view;
    }



    @Override
    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu, menu);
        itemDelete = menu.findItem(R.id.action_delete);
        //itemDelete.setVisible(false);
        super.onCreateOptionsMenu(menu, menuInflater);

    }

    public void openDeleteDialog(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(requireActivity());
        alertDialog.setTitle("Delete");
        alertDialog.setMessage("Delete this user?");
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                viewModelMain.dbDeleteUser(requireActivity());
                dialogInterface.dismiss();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialog.show();
    }

    @Override
    public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id){
            case R.id.action_delete:
                openDeleteDialog();
            case R.id.action_edit:
                viewModelMain.currentUser.setName(name.getText()+"");
                viewModelMain.dbUpdateUser(requireActivity());
                return true;
        }
        return false;
    }
}