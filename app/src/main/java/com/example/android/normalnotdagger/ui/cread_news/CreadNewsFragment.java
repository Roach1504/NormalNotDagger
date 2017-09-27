package com.example.android.normalnotdagger.ui.cread_news;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.normalnotdagger.R;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;

public class CreadNewsFragment extends Fragment implements CreadNewsMVP {


    SharedPreferences user;
    CreadNewsPresentr creadNewsPresentr;
    static final int GALLERY_REQUEST = 1;

    List<Uri> imags = new ArrayList<>();

    @BindView(R.id.gallery_imag)
    ImageView imageView;
    @BindView(R.id.title)
    EditText title;
    @BindView(R.id.shorts)
    EditText shorts;
    @BindView(R.id.text)
    EditText text;

    @BindView(R.id.cread)
    Button cread;
    @BindView(R.id.addimag)
    FloatingActionButton addImag;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cread_new, container, false);
        ButterKnife.bind(this, view);
        user = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        creadNewsPresentr = new CreadNewsPresentr(this, user, this.getActivity());
        addImag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
            }
        });
        cread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creadNewsPresentr.loadNew(title.getText().toString(), shorts.getText().toString(), text.getText().toString(), imags);
            }
        });

        return view;
    }

    @Override
    public void showStatus(String status) {

        Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startProgresBar() {

    }

    @Override
    public void stopProgresBar() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = null;
        switch (requestCode) {
            case GALLERY_REQUEST:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();

                    final InputStream imageStream;
                    try {
                        imageStream = getActivity().getContentResolver().openInputStream(selectedImage);
                        final Bitmap selectedImages = BitmapFactory.decodeStream(imageStream);
                        imageView.setImageBitmap(selectedImages);
                        imags.add(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    Log.e("Image", "URL: " + selectedImage);
                }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //null.unbind();
    }
}
