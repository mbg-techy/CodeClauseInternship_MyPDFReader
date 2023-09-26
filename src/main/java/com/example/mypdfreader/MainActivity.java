package com.example.mypdfreader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.os.Environment;

public class MainActivity extends AppCompatActivity implements OnPdfSelect{

    private MainAdapt adapt;
    private List<File> pdfList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runtimePermission();
    }

    private void runtimePermission(){
        Dexter.withContext(MainActivity.this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                displayPdf();

            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();

            }
        }).check();
    }

    public ArrayList<File> findPdf (File file)
    {
        ArrayList<File> arrayList= new ArrayList<>();
        File[] files=file.listFiles();

        for(File singleFile : files){
            if(singleFile.isDirectory() && !singleFile.isHidden())
            {
                arrayList.addAll(findPdf(singleFile));
            }
            else {
                if(singleFile.getName().endsWith(".pdf")){
                    arrayList.add(singleFile);
                }
            }
        }return arrayList;
    }
    public void displayPdf()
    {
        recyclerView=findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        pdfList=new ArrayList<>();
        pdfList.addAll(findPdf(Environment.getExternalStorageDirectory()));
        adapt=new MainAdapt(this,pdfList,this);
        recyclerView.setAdapter(adapt);
    }

    @Override
    public void onPdfSelected(File file) {
        startActivity(new Intent(MainActivity.this, PdfActivity.class).putExtra("path",file.getAbsolutePath()));

    }
}
